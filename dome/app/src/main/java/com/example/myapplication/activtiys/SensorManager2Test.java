package com.example.myapplication.activtiys;

import android.Manifest;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.fingerprint.FingerprintManager;
import android.nfc.NfcAdapter;
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.Parcelable;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.example.myapplication.R;
import com.example.myapplication.utils.NfcUtils;

public class SensorManager2Test extends AppCompatActivity {

    private NfcUtils nfcUtils;

    //在onNewIntent中处理由NFC设备传递过来的intent
    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.e(TAG, "--------------NFC-------------" );
        processIntent(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        //---------nfc操作
        nfcUtils = new NfcUtils(this);
        //设定intentfilter和tech-list。如果两个都为null就代表优先接收任何形式的TAG action。也就是说系统会主动发TAG intent。
        if (nfcUtils.mNfcAdapter != null) {
            nfcUtils.mNfcAdapter.enableForegroundDispatch(this, NfcUtils.mPendingIntent, NfcUtils.mIntentFilter, NfcUtils.mTechList);
        }else {
            Toast.makeText(this, "调用失败", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        nfcUtils.mNfcAdapter = null;
    }
    @Override
    protected void onPause() {
        super.onPause();
        if (nfcUtils.mNfcAdapter != null) {
            nfcUtils.mNfcAdapter.disableForegroundDispatch(this);
        }
    }

    FingerprintManager manager;
    KeyguardManager mKeyManager;
    private final static int REQUEST_CODE_CONFIRM_DEVICE_CREDENTIALS = 0;
    private final static String TAG = "finger_log";

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_manager2_test);
        initView();
        setView();
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void setView() {
        //----指纹操作
//        if(isFinger()){
//            Toast.makeText(SensorManager2Test.this, "请进行指纹识别", Toast.LENGTH_LONG).show();
//            startListening(null);
//        }

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void initView() {
        manager = (FingerprintManager) this.getSystemService(Context.FINGERPRINT_SERVICE);
        mKeyManager = (KeyguardManager) this.getSystemService(Context.KEYGUARD_SERVICE);
    }
    //-----------------------------NFC操作
    public void processIntent(Intent intent) {
        Parcelable[] rawmsgs = intent.getParcelableArrayExtra(NfcAdapter.EXTRA_NDEF_MESSAGES);//获取数据
        Toast.makeText(this, "读取成功!", Toast.LENGTH_SHORT).show();
    }
    //-------------------------------指纹操作

    @RequiresApi(api = Build.VERSION_CODES.M)
    public boolean isFinger() {

        //android studio 上，没有这个会报错
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.USE_FINGERPRINT) != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "没有指纹识别权限", Toast.LENGTH_SHORT).show();
            return false;
        }
        Log.d(TAG, "有指纹权限");
        //判断硬件是否支持指纹识别
        if (!manager.isHardwareDetected()) {
            Toast.makeText(this, "没有指纹识别模块", Toast.LENGTH_SHORT).show();
            return false;
        }
        Log.d(TAG, "有指纹模块");
        //判断 是否开启锁屏密码

        if (!mKeyManager.isKeyguardSecure()) {
            Toast.makeText(this, "没有开启锁屏密码", Toast.LENGTH_SHORT).show();
            return false;
        }
        Log.d(TAG, "已开启锁屏密码");
        //判断是否有指纹录入
        if (!manager.hasEnrolledFingerprints()) {
            Toast.makeText(this, "没有录入指纹", Toast.LENGTH_SHORT).show();
            return false;
        }
        Log.d(TAG, "已录入指纹");

        return true;
    }
    CancellationSignal mCancellationSignal = new CancellationSignal();
    //回调方法 
    FingerprintManager.AuthenticationCallback mSelfCancelled = new FingerprintManager.AuthenticationCallback() {
        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        @Override
        public void onAuthenticationError(int errorCode, CharSequence errString) {
            //但多次指纹密码验证错误后，进入此方法；并且，不能短时间内调用指纹验证 
            Toast.makeText(SensorManager2Test.this, errString, Toast.LENGTH_SHORT).show();
            showAuthenticationScreen();
        }

        @Override
        public void onAuthenticationHelp(int helpCode, CharSequence helpString) {

            Toast.makeText(SensorManager2Test.this, helpString, Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult result) {

            Toast.makeText(SensorManager2Test.this, "指纹识别成功", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onAuthenticationFailed() {
            Toast.makeText(SensorManager2Test.this, "指纹识别失败", Toast.LENGTH_SHORT).show();
        }
    };


    @RequiresApi(api = Build.VERSION_CODES.M)
    public void startListening(FingerprintManager.CryptoObject cryptoObject) {
        //android studio 上，没有这个会报错 
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.USE_FINGERPRINT) != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "没有指纹识别权限", Toast.LENGTH_SHORT).show();
            return;
        }
        manager.authenticate(cryptoObject, mCancellationSignal, 0, mSelfCancelled, null);


    }

    /**
     * 锁屏密码
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void showAuthenticationScreen() {

        Intent intent = mKeyManager.createConfirmDeviceCredentialIntent("finger", "测试指纹识别");
        if (intent != null) {
            startActivityForResult(intent, REQUEST_CODE_CONFIRM_DEVICE_CREDENTIALS);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_CONFIRM_DEVICE_CREDENTIALS) {
            // Challenge completed, proceed with using cipher 
            if (resultCode == RESULT_OK) {
                Toast.makeText(this, "识别成功", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "识别失败", Toast.LENGTH_SHORT).show();
            }
        }
    }
}