package com.example.myapplication.design_pattern.facade_pattern;

import android.util.Log;

public class VideoPlayer implements AbstractPlayer {
    private static  final String TAG = "VideoPlayer";

    @Override
    public void play() {
        Log.i(TAG,"play video");
    }

}
