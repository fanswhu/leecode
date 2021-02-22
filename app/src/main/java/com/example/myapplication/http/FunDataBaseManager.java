package com.example.myapplication.http;
import com.example.myapplication.bean.PostInfo;
import com.example.myapplication.bean.PostRequest;

import java.util.Map;

import io.reactivex.Observable;

public class FunDataBaseManager extends BaseDataManager<PostRequest, PostInfo> {
    public FunDataBaseManager(BaseObserver.HttpCallBack<PostInfo> callBack) {
        super("getJoke", callBack);
    }

    @Override
    protected void setRequestParams(Object... params) {
        PostRequest request = new PostRequest();
        request.setPage((String) params[0]);
        request.setCount((String) params[1]);
        request.setType((String) params[2]);
        doRequest(request);
    }

    @Override
    protected Observable<PostInfo> getResponse(Map<String, Object> map) {
        return RetrofitManager.getRetrofitService().executePost(mUrl, map);
    }


    public void getData(String page,String count,String type) {
        setRequestParams(page,count,type);
    }
}
