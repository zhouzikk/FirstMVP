package com.hk.firstmvp.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.hk.firstmvp.mvp.base.BasePresenter;


/**
 * Created by Flash_Chicken on 2018/2/1.
 * 别问我为啥写泛型。。。。刚好在看书。。。
 */

public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity {

    protected String TAG = this.getClass().getSimpleName();
    protected T presenter;



    protected abstract int getLayoutResId();

    protected abstract void initPresenter();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());
        initPresenter();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart");

    }

    @Override
    protected void onResume() {
        Log.i(TAG, "onResume");
        super.onResume();

    }

    @Override
    protected void onPause() {
        Log.i(TAG, "onPause");
        super.onPause();

    }

    @Override
    protected void onStop() {
        Log.i(TAG, "onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.i(TAG, "onDestroy");
        if(presenter!=null){
            presenter.detachView();
            presenter=null;
        }
        super.onDestroy();

    }

}
