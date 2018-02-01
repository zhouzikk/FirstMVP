package com.hk.firstmvp.mvp.model;

import com.hk.firstmvp.bean.LoginBean;
import com.hk.firstmvp.mvp.OnLoginListener;
import com.hk.firstmvp.mvp.contract.LoginContract;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Flash_Chicken on 2018/2/1.
 */

public class LoginBiz implements LoginContract.M {
    @Override
    public void login(final LoginBean loginBean,final OnLoginListener onLoginListener) {
        Observable.create(new ObservableOnSubscribe<LoginBean>() {

            @Override
            public void subscribe(@NonNull ObservableEmitter<LoginBean> emitter) throws Exception {

                Thread.sleep(3000);
                emitter.onNext(loginBean);

            }
        }).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io()).subscribe(new Consumer<LoginBean>() {
            @Override
            public void accept(LoginBean loginBean) throws Exception {

                if (loginBean.getUserName().equals("coco")&&loginBean.getUserPwd().equals("123456")){
                    onLoginListener.loginSuccess();
                }else{
                    onLoginListener.loginFailed();
                }
            }
        });
    }
}
