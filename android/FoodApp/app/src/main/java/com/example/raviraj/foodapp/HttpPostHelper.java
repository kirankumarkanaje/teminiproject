package com.example.raviraj.foodapp;

import android.os.AsyncTask;
import android.util.Log;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;

import org.json.JSONObject;

public class HttpPostHelper extends AsyncTask<String, Void, String> {

    @Override
    protected String doInBackground(String... params) {

        String url = params[0];
        String userName = params[1];
        String password = params[2];


        try {
            JSONObject json = new JSONObject();
            json.put("username", userName);
            json.put("password", password);
            RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json.toString());

            final OkHttpClient httpClient = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(url).post(requestBody)
                    .build();

            Response response = httpClient.newCall(request).execute();
            String responseBody = response.body().string();
            Log.i("Response of post" , responseBody);

            return responseBody;
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
