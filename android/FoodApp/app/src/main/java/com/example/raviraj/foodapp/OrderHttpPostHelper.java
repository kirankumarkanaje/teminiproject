package com.example.raviraj.foodapp;

import android.os.AsyncTask;
import android.util.Log;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import org.json.JSONObject;

/**
 * Created by kiran on 9/28/16.
 */
public class OrderHttpPostHelper extends AsyncTask<String, Void, Void> {

    @Override
    protected Void doInBackground(String... params) {

        String url = params[0];
        String body = params[1];

        try {

            RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), body);

            final OkHttpClient httpClient = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(url).post(requestBody)
                    .build();

            Response response = httpClient.newCall(request).execute();
            String responseBody = response.body().string();
            Log.i("Response of post", responseBody);

        } catch(Exception e) {
            e.printStackTrace();
        }

        return null;

    }
}
