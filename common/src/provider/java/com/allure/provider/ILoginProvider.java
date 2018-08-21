package com.allure.provider;

import android.content.Context;

import com.alibaba.android.arouter.facade.template.IProvider;
import com.allure.common.bean.LoginInfoBean;

/**
 * <p>描述：(这里用一句话描述这个类的作用)</p>
 * Created by Cherish on 2018/8/17.<br>
 */
public  interface ILoginProvider extends IProvider {

    LoginInfoBean getLoginInfo();
    boolean isLogin();
    void start2Login();

    @Override
    void init(Context context);
}