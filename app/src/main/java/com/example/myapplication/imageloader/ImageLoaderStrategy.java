package com.example.myapplication.imageloader;

import android.view.View;

public interface ImageLoaderStrategy {
    void showImage(View v,  String url);
    void showImage(View v, int drawable);
}
