package com.example.myapplication.preseter;

public class BasePresenter<V> {
    public V mView;

    public void attachView(V view) {
        this.mView = view;
    }

    public void detachView() {
        this.mView = null;
    }

}
