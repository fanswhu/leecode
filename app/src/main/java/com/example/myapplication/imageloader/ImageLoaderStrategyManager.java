package com.example.myapplication.imageloader;

import android.view.View;

public class ImageLoaderStrategyManager implements ImageLoaderStrategy {

    private static final ImageLoaderStrategyManager INSTANCE = new ImageLoaderStrategyManager();
    private ImageLoaderStrategy imageLoader;
    private ImageLoaderStrategyManager(){
        //默认使用Glide
        imageLoader=new GlideImageLoaderStrategy();
    }
    public static ImageLoaderStrategyManager getInstance(){
        return INSTANCE;
    }
    @Override
    public void showImage(View v, String url) {
        imageLoader.showImage(v,url);
    }

    @Override
    public void showImage(View v, int drawable) {
        imageLoader.showImage(v,drawable);
    }
}
