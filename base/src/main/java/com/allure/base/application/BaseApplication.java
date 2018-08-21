package com.allure.base.application;

import android.app.Application;

import com.alibaba.android.arouter.BuildConfig;
import com.alibaba.android.arouter.launcher.ARouter;

/**
 * <p>描述：(这里用一句话描述这个类的作用)</p>
 * Created by Cherish on 2018/8/16.<br>
 */
public class BaseApplication extends Application {

    public boolean isLogin=false;//只做演示，常规方案应放到sp不能在application里做
    public boolean isLogin() {
        return isLogin;
    }

    public void setLogin(boolean login) {
        isLogin = login;
    }

    public static BaseApplication instance = null;

    public static BaseApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        modulesApplicationInit();
        ARouterInit();
    }

    private void ARouterInit() {
        if (BuildConfig.DEBUG) {           // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog();     // 打印日志
            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(BaseApplication.this);
    }


    /**
     * 利用反射思想低耦合使单独组件初始化Application（同样可以利用Base层处理）
     */
    private void modulesApplicationInit() {
        for (String modulesImpl : ModulesApplicationConfig.MODULES_LIST) {
            try {
                Class<?> aClass = Class.forName(modulesImpl);
                Object object = aClass.newInstance();

                if (object instanceof ApplicationImpl) {
                    ((ApplicationImpl) object).onCreate(this);
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }
    }
}
