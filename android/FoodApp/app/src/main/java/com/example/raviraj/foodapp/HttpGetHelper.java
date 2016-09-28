package com.example.raviraj.foodapp;

import android.os.AsyncTask;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;


public class HttpGetHelper extends AsyncTask<String, Void, String> {

    @Override
    protected String doInBackground(String... params) {
        String url = params[0];
        final OkHttpClient httpClient = new OkHttpClient();

        Request request = new Request.Builder()
                .url(url)
                .build();
        String body = null;
        try {
            Response response = httpClient.newCall(request).execute();
            body = response.body().string();
        } catch(Exception e) {
            e.printStackTrace();
        }

        return body;
    }
}
