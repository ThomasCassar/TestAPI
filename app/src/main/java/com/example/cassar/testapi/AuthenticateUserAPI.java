package com.example.cassar.testapi;

import android.annotation.TargetApi;
import android.os.AsyncTask;
import android.os.Build;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by cassar on 09/05/16.
 */
public class AuthenticateUserAPI extends AsyncTask<Void, Integer, String> {

    protected void onProgressUpdate(Integer... progress) {

    }

    @Override
    protected String doInBackground(Void... params) {
        URL url = null;
//        URLConnection urlConnection = null;
//        OutputStream in = null;
//        try {
//            url = new URL(" http://staging.makerble.com/users/sign_in\n");
//            urlConnection = url.openConnection();
//            in = new BufferedOutputStream(urlConnection.getOutputStream());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//
//        try(java.util.Scanner s = new java.util.Scanner(String.valueOf(in)))
//        {
//            Log.d("API test 2", s.useDelimiter("\\A").hasNext() ? s.next() : "");
//
//
//
//        }
//        return null;


        HttpURLConnection urlConnection = null;
        try {
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setDoOutput(true);
            urlConnection.setChunkedStreamingMode(0);
            OutputStream out = new BufferedOutputStream(urlConnection.getOutputStream());

            writeStream(out);
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            try(java.util.Scanner s = new java.util.Scanner(in))
            {
                Log.d("API test 2", s.useDelimiter("\\A").hasNext() ? s.next() : "");

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            urlConnection.disconnect();
        }

    }

    protected void onPostExecute(String result) {

    }
}