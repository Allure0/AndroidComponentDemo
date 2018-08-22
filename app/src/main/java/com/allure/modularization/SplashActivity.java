package com.allure.modularization;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.allure.common.ARouterManager;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public  void go(View view){
        ARouterManager.start2Main();
    }
}
