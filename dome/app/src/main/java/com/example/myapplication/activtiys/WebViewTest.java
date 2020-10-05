package com.example.myapplication.activtiys;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class WebViewTest extends AppCompatActivity {

    private WebView mWebviewWvTest;
    private ProgressBar mWebviewProValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_test);
        initView();
        setView();
    }

    private void initWebView() {
        //初始化webview
        mWebviewWvTest.setWebViewClient(new WebViewClient());
        WebSettings webSettings = mWebviewWvTest.getSettings();
        webSettings.setUseWideViewPort(true);
    }

    private void setView() {
        initWebView();
        String url = "https://www.baidu.com/s?ie=UTF-8&wd=%E5%9B%BE%E7%89%87&tn=88093251_75_hao_pg";
        String htmlData = "<h2>你好世界!</h2>";

        mWebviewWvTest.loadUrl(url);
//        mWebviewWvTest.loadDataWithBaseURL("about:blank",htmlData,"text/html","UTF-8",null);

        //监听
        mWebviewWvTest.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                mWebviewProValue.setVisibility(View.GONE);
            }
        });
        mWebviewWvTest.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                mWebviewProValue.setProgress(newProgress);
            }
        });
    }

    private void initView() {
        mWebviewWvTest = (WebView) findViewById(R.id.webview_wv_test);
        mWebviewProValue = (ProgressBar) findViewById(R.id.webview_pro_value);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (mWebviewWvTest.canGoBack()) {
                mWebviewWvTest.goBack();
            } else {
                return super.onKeyDown(keyCode, event);
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}