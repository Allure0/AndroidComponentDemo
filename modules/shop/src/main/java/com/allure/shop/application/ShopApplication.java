package com.allure.shop.application;

import android.app.Application;
import android.util.Log;

import com.allure.base.application.ApplicationImpl;

/**
 * <p>描述：(这里用一句话描述这个类的作用)</p>
 * Created by Cherish on 2018/8/16.<br>
 */
public class ShopApplication implements ApplicationImpl {

    private static final String TAG = "ShopApplication";

    @Override
    public void onCreate(Application baseApplication) {
        Log.e(TAG, "初始化ShopApplication");
    }
}
