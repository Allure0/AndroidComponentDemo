package com.allure.shop;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.allure.common.ARouterManager;
import com.allure.common.ARouterPathConfig;
import com.allure.provider.ILoginProvider;
import com.blankj.utilcode.util.ToastUtils;

/**
 * <p>描述：(商店，进入商店前需要判断是否登录,没有登录进入登录页面)</p>
 * Created by Cherish on 2018/8/15.<br>
 */
@Route(path = ARouterPathConfig.SHOP_START, extras = 1)
public class ShopActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shop_activity_start);
        findViewById(R.id.btn_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouterManager.start2Login();
            }
        });


        findViewById(R.id.btn_info).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ILoginProvider iLoginProvider = (ILoginProvider) ARouter.getInstance().build(ARouterPathConfig.SERVICE_LOGIN).navigation();
                ToastUtils.showShort(
                        iLoginProvider.getLoginInfo().getName()
                );
            }
        });
    }
}
