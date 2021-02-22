package com.example.myapplication.design_pattern.facade_pattern;

import android.util.Log;

public class PicturePlayer implements AbstractPlayer {
    private final static String TAG = "PicturePlayer";
    @Override
    public void play() {
        Log.i(TAG,"play picture");
    }
}
