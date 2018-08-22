package com.allure.login;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.allure.base.application.BaseApplication;
import com.allure.common.ARouterPathConfig;
import com.blankj.utilcode.util.ToastUtils;

/**
 * <p>描述：(这里用一句话描述这个类的作用)</p>
 * Created by Cherish on 2018/8/15.<br>
 */
@Route(path = ARouterPathConfig.LOGIN_START)
public class LoginActivity extends AppCompatActivity {

    private Button mButtonLogin;

    private EditText editName;
    private EditText editPwd;


    private ProgressBar progressBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity_start);

        progressBar = findViewById(R.id.progress_bar);
        editName = findViewById(R.id.et_username);
        editPwd = findViewById(R.id.et_password);
        mButtonLogin = findViewById(R.id.btn_login);



        mButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if ("".equals(editName.getText().toString()) ||
                        "".equals(editPwd.getText().toString())) {
                    ToastUtils.showShort("请输入任意用户名和密码");

                } else {
                    ToastUtils.showShort("登录中...");
                    progressBar.setVisibility(View.VISIBLE);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            BaseApplication.getInstance().setLogin(true);

                            progressBar.setVisibility(View.GONE);
                            ToastUtils.showShort("登录成功");
                            finish();
                        }
                    }, 2000);
                }

            }
        });


        findViewById(R.id.btn_logOut).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToastUtils.showShort("登录中...");
                BaseApplication.getInstance().setLogin(false);
                finish();

            }
        });
    }
}


