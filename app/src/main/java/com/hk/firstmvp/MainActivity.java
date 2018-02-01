package com.hk.firstmvp;

import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.hk.firstmvp.base.BaseActivity;
import com.hk.firstmvp.mvp.contract.LoginContract;
import com.hk.firstmvp.mvp.presenter.LoginPresenter;

/**
 * Created by Flash_Chicken on 2018/2/1.
 */

public class MainActivity extends BaseActivity<LoginPresenter> implements LoginContract.V {

    private EditText name,pwd;

    public void login(View view) {

        presenter.login();

    }

    public void clear(View view) {

        presenter.clear();

    }

    @Override
    public String getUserName() {
        return name.getText().toString().trim();
    }

    @Override
    public String getUserPwd() {
        return pwd.getText().toString().trim();
    }

    @Override
    public void clearUserName() {
        name.setText("");
    }

    @Override
    public void clearUserPwd() {
        pwd.setText("");
    }

    @Override
    public void showDialog() {
        Log.e("Login","登录......");
    }

    @Override
    public void hideDialog() {
        Log.e("Login","登录完毕");
    }

    @Override
    public void showLoginSuccess() {
        Log.e("Login","登陆成功");
    }

    @Override
    public void showLoginError() {
        Log.e("Login","登陆失败");
    }

    @Override
    public void initView() {
        name= (EditText) findViewById(R.id.name);
        pwd= (EditText) findViewById(R.id.pwd);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity;
    }

    @Override
    protected void initPresenter() {
        presenter = new LoginPresenter(this, this);
        presenter.attachView();
    }
}
