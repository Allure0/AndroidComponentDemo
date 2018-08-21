package com.allure.common;

import android.content.Context;
import android.util.Log;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;
import com.alibaba.android.arouter.launcher.ARouter;

/**
 * <p>描述：(这里用一句话描述这个类的作用)</p>
 * Created by Cherish on 2018/8/16.<br>
 */
public class ARouterManager {





    public static  void start2Shop(Context mContext){
        ARouter.getInstance().build(ARouterPathConfig.SHOP_START)
                .navigation(mContext, new NavigationCallback() {
                    @Override
                    public void onFound(Postcard postcard) {

                    }

                    @Override
                    public void onLost(Postcard postcard) {

                    }

                    @Override
                    public void onArrival(Postcard postcard) {

                    }

                    @Override
                    public void onInterrupt(Postcard postcard) {
                        Log.e("","拦截成功");

                    }
                });
    }



    public static  void start2Main(){
        ARouter.getInstance().build(ARouterPathConfig.MAIN_START)
                .navigation();
    }

    public static  void start2Login(){
        ARouter.getInstance().build(ARouterPathConfig.LOGIN_START)
                .navigation();
    }

    public static  void start2MainSecond(){
        ARouter.getInstance().build(ARouterPathConfig.MAIN_SECOND)
                .navigation();
    }
}
