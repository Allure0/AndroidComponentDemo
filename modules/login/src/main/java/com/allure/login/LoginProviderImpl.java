package com.allure.login;

import android.content.Context;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;
import com.alibaba.android.arouter.launcher.ARouter;
import com.allure.common.ARouterPathConfig;
import com.allure.common.bean.LoginInfoBean;
import com.allure.provider.ILoginProvider;
import com.blankj.utilcode.util.LogUtils;

/**
 * <p>描述：(IOC思想进行服务判断)</p>
 * Created by Cherish on 2018/8/17.<br>
 */
@Route(path = ARouterPathConfig.SERVICE_LOGIN)
public class LoginProviderImpl implements ILoginProvider {
    private static final String TAG = "LoginProviderImpl";
    private Context mContext;

    @Override
    public void init(Context context) {
        this.mContext = context;
    }


    /**
     * 其他快莫获取此模块组件的信息
     *
     * @return
     */
    @Override
    public LoginInfoBean getLoginInfo() {
        LoginInfoBean loginInfoBean = new LoginInfoBean();
        loginInfoBean.setAge("18");
        loginInfoBean.setName("inChat");
        loginInfoBean.setLogin(true);
        return loginInfoBean;
    }

    @Override
    public boolean isLogin() {
        return true;
    }

    @Override
    public void start2Login() {
        ARouter.getInstance().build(ARouterPathConfig.LOGIN_START)
                .navigation(mContext, new NavigationCallback() {
                    @Override
                    public void onFound(Postcard postcard) {
                        LogUtils.d("onFound");
                    }

                    @Override
                    public void onLost(Postcard postcard) {
                        LogUtils.d("onLost");
                    }

                    @Override
                    public void onArrival(Postcard postcard) {
                        LogUtils.d("onArrival");
                    }

                    @Override
                    public void onInterrupt(Postcard postcard) {
                        LogUtils.d("onInterrupt");

                    }
                });
    }


}
