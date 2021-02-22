package com.example.myapplication.preseter;

import com.example.myapplication.bean.PostInfo;
import com.example.myapplication.contract.IMainContract;
import com.example.myapplication.http.BaseObserver;
import com.example.myapplication.http.FunDataBaseManager;

public class MainPresenter  extends BasePresenter<IMainContract.IMainView> implements IMainContract.IMainPresenter   {

    public MainPresenter(IMainContract.IMainView view){
        attachView(view);
    }


    @Override
    public void requestData() {
        new FunDataBaseManager(new BaseObserver.HttpCallBack<PostInfo>() {
            @Override
            public void onSuccess(PostInfo t) {

            }

            @Override
            public void onError(Throwable e) {

            }
        }).getData("1","5","video");
    }
}
