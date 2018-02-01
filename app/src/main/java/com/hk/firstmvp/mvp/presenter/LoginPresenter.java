package com.hk.firstmvp.mvp.presenter;

import android.content.Context;


import com.hk.firstmvp.bean.LoginBean;
import com.hk.firstmvp.mvp.OnLoginListener;
import com.hk.firstmvp.mvp.base.BasePresenter;
import com.hk.firstmvp.mvp.contract.LoginContract;
import com.hk.firstmvp.mvp.model.LoginBiz;

/**
 * Created by Flash_Chicken on 2018/2/1.
 */

public class LoginPresenter extends BasePresenter<LoginContract.V,LoginBiz> {

    public LoginPresenter(Context context,LoginContract.V iLoginView){
        super(context,iLoginView);

        model=new LoginBiz();

    }

    public void login(){

        iView.showDialog();
        LoginBean loginBean=new LoginBean();
        loginBean.setUserName(iView.getUserName());
        loginBean.setUserPwd(iView.getUserPwd());


        model.login(loginBean, new OnLoginListener() {
            @Override
            public void loginSuccess() {
                iView.showLoginSuccess();
            }

            @Override
            public void loginFailed() {
                iView.showLoginError();
                iView.hideDialog();
            }



        });

    }

    public void clear(){

        iView.clearUserName();
        iView.clearUserPwd();

    }

}
