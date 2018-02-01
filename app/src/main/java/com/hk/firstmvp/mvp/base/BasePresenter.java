package com.hk.firstmvp.mvp.base;

import android.content.Context;

/**
 * Created by Flash_Chicken on 2018/2/1.
 */

public class BasePresenter<V extends IBaseView,M> {

    protected Context context;

    protected V iView;
    protected M model;

    public BasePresenter(Context context,V iView){
        this.context = context;
        this.iView = iView;
    }

    public void attachView(){
        if(iView!=null){
            iView.initView();
        }
    }


    public void detachView() {
        if(iView!=null) {
            iView = null;
        }
    }

}
