package com.example.tommynews.utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class MyHttp {
    private static RequestQueue queue ;
    public static String HEAD_URL = "http://rap2api.taobao.org/app/mock/271384/";
    private static final String TAG = "MyHttp";


    public static void Call(final Context context, String url,boolean isLog, final Response.Listener<JSONObject> jsonObjectListener){
        try {
            if (queue == null)
                queue = Volley.newRequestQueue(context);
            final ProgressDialog progressDialog = new ProgressDialog(context);
            progressDialog.setTitle("正在加载...");
            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            if (isLog){
                progressDialog.show();
            }

            queue.add(new JsonObjectRequest(HEAD_URL + url, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject jsonObject) {
                    try {
                        progressDialog.cancel();
                        jsonObjectListener.onResponse(jsonObject);
                    }catch (Exception e){
                        progressDialog.cancel();
                        Toast.makeText(context, "解析数据错误!", Toast.LENGTH_SHORT).show();
                    }
                    Log.d(TAG,jsonObject.toString());
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError volleyError) {
                    progressDialog.cancel();
                    Toast.makeText(context, "服务器错误!", Toast.LENGTH_SHORT).show();
                    Log.d(TAG,volleyError.toString());
                }
            }));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
