package com.allure.login;

import android.content.Context;
import android.util.Log;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;
import com.alibaba.android.arouter.launcher.ARouter;
import com.allure.base.application.BaseApplication;
import com.allure.common.ARouterPathConfig;
import com.allure.provider.ILoginProvider;

/**
 * <p>描述：(拦截器AOP切面拦截登录)</p>
 * Created by Cherish on 2018/8/20.<br>
 */
@Interceptor(priority = 1)
public class LoginInterceptor implements IInterceptor {

    private static final String TAG = "LoginInterceptor";

    private Context mContext;

    @Override
    public void process(Postcard postcard, InterceptorCallback callback) {

        Log.i(TAG, "LoginInterceptor 开始执行");

        if (postcard.getExtra() == 1) {//extras=1,目标页面标记，代表需要拦截处理

            boolean isLogin = BaseApplication.getInstance().isLogin();
            Log.i(TAG, "是否已登录: " + isLogin);
            //判断用户的登录情况，可以把值保存在sp中
            if (isLogin) {
                callback.onContinue(postcard);
            } else {
                callback.onInterrupt(null);
                ILoginProvider iLoginProvider = (ILoginProvider) ARouter.getInstance().build(ARouterPathConfig.SERVICE_LOGIN).navigation();
                iLoginProvider.start2Login();
            }
        } else {
            callback.onContinue(postcard);
        }

    }

    @Override
    public void init(Context context) {

        mContext = context;
        Log.i(TAG, "LoginInterceptor 初始化");

    }
}


