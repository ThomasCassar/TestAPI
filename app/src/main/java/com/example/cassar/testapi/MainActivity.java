package com.example.cassar.testapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WelcomeMessageAPI task = new WelcomeMessageAPI();
        task.execute();

        AuthenticateUserAPI task2 = new AuthenticateUserAPI();
        task2.execute();
    }
}
