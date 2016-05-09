package com.example.cassar.testapi;

import android.annotation.TargetApi;
import android.os.AsyncTask;
import android.os.Build;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by cassar on 09/05/16.
 */
public class WelcomeMessageAPI extends AsyncTask<Void, Integer, String> {


    protected void onProgressUpdate(Integer... progress) {

    }

    @Override
    protected String doInBackground(Void... params) {
        URL url = null;
        URLConnection urlConnection = null;
        InputStream in = null;
        try {
            url = new URL(" http://staging.makerble.com/api/v1/welcome/messages\n");
            urlConnection = url.openConnection();
            in = new BufferedInputStream(urlConnection.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }


        try(java.util.Scanner s = new java.util.Scanner(in))
        {
            Log.d("API test", s.useDelimiter("\\A").hasNext() ? s.next() : "");

        }
        return null;
    }

    protected void onPostExecute(String result) {

    }
}