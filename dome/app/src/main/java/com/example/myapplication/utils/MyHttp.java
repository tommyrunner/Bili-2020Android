package com.example.myapplication.utils;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class MyHttp {
    static  RequestQueue queue;
    public static void get(String path, final Context context, Response.Listener<JSONObject> res) {
        if(queue==null){
            queue  = Volley.newRequestQueue(context);
        }

        queue.add(new JsonObjectRequest(path, res, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(context, "访问失败!", Toast.LENGTH_SHORT).show();
            }
        }));
    }
}
