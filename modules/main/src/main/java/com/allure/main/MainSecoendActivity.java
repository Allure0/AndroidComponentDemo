package com.allure.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.allure.common.ARouterPathConfig;

/**
 * <p>描述：(这里用一句话描述这个类的作用)</p>
 * Created by Cherish on 2018/8/17.<br>
 */
@Route(path = ARouterPathConfig.MAIN_SECOND)

public class MainSecoendActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity_second);
    }
}
