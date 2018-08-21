package com.allure.login.application;

import android.app.Application;
import android.util.Log;

import com.allure.base.application.ApplicationImpl;

/**
 * <p>描述：(这里用一句话描述这个类的作用)</p>
 * Created by Cherish on 2018/8/16.<br>
 */
public class LoginApplication implements ApplicationImpl {

    private static final String TAG = "LoginApplication";

    @Override
    public void onCreate(Application baseApplication) {
        Log.e(TAG, "初始化LoginApplication");

    }

}
