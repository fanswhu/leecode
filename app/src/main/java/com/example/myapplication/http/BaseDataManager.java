package com.example.myapplication.http;

import com.example.myapplication.bean.BaseRequestParams;
import com.example.myapplication.bean.BaseResponseParams;
import com.google.gson.Gson;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public abstract class BaseDataManager<V extends BaseRequestParams,T extends BaseResponseParams> {
    protected String mUrl;
    protected BaseObserver.HttpCallBack<T> mCallBack;

    public BaseDataManager(String url, BaseObserver.HttpCallBack<T> callBack) {
        this.mCallBack = callBack;
        this.mUrl = url;
    }


    protected abstract void setRequestParams(Object... params);

    private void setBaseParams(V request) {
        request.setKey("6645f67c9764e4b4dcd88b826ec43379");
    }


    protected void doRequest(V request) {
        setBaseParams(request);
        String s = new Gson().toJson(request);
        Map<String,Object> map = new Gson().<Map<String,Object>>fromJson(s, Map.class);
        getResponse(map).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver<>(mCallBack));
    }

    protected abstract Observable<T> getResponse(Map<String,Object> requestParams);

}
