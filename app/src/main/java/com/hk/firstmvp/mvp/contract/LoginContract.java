package com.hk.firstmvp.mvp.contract;


import com.hk.firstmvp.bean.LoginBean;
import com.hk.firstmvp.mvp.OnLoginListener;
import com.hk.firstmvp.mvp.base.IBaseView;

/**
 * Created by Flash_Chicken on 2018/2/1.
 */

public interface LoginContract {

    //契约 方便管理

    interface V extends IBaseView {
        String getUserName();
        String getUserPwd();
        void clearUserName();
        void clearUserPwd();
        void showDialog();
        void hideDialog();
        void showLoginSuccess();
        void showLoginError();
    }

    interface M{
        void login(LoginBean loginBean, OnLoginListener onLoginListener);
    }

}
