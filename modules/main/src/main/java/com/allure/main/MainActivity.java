package com.allure.main;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.allure.common.ARouterManager;
import com.allure.common.ARouterPathConfig;
import com.allure.provider.ILoginProvider;

/**
 * <p>描述：(这里用一句话描述这个类的作用)</p>
 * Created by Cherish on 2018/8/17.<br>
 */
@Route(path = ARouterPathConfig.MAIN_START)
public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private Button mButtonLigin;
    private Button mButtonShop;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity_start);
        mButtonLigin = findViewById(R.id.btn_login);
        //登录
        mButtonLigin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ILoginProvider iLoginProvider = (ILoginProvider) ARouter.getInstance().build(ARouterPathConfig.SERVICE_LOGIN).navigation();
                iLoginProvider.start2Login();
            }
        });

        //商店
        mButtonShop = findViewById(R.id.btn_shop);
        mButtonShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ARouterManager.start2Shop(MainActivity.this);
            }
        });


        //二级页面
        findViewById(R.id.btn_second).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ARouterManager.start2MainSecond();
            }
        });
    }


    public void go2Login() {
        try {
            PackageManager packageManager = MainActivity.this.getPackageManager();  // 当前Activity获得packageManager对象
            Intent intent = new Intent();
            intent = packageManager.getLaunchIntentForPackage("com.allure.login");
            startActivity(intent);
        } catch (Exception e) {
            Log.i(TAG, e.toString());
        }
    }


}
