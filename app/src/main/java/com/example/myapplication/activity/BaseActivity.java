package com.example.myapplication.activity;

import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

import com.example.myapplication.preseter.BasePresenter;

import org.greenrobot.eventbus.EventBus;

public abstract class BaseActivity<P extends BasePresenter> extends FragmentActivity {
    protected P mPresenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        mPresenter = createPresenter();
        initViews();
        initEvents();
        initData();
    }

    protected abstract P createPresenter();

    /**
     * 获取布局文件资源
     * @return id
     */
    protected abstract int getLayout();

    /**
     * 初始化布局
     */
    protected abstract void initViews();

    /**
     * 初始化事件
     */
    protected abstract void initEvents();

    /**
     * 初始化数据
     */
    protected abstract void initData();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }
}
