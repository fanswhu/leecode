package com.example.myapplication.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import com.google.android.material.appbar.AppBarLayout;

public class ImageBehavior extends CoordinatorLayout.Behavior<ImageView> {
    private final static int MAX_HEIGHT = 400;

    public ImageBehavior() {
    }

    public ImageBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull ImageView child, @NonNull View directTargetChild, @NonNull View target, int axes, int type) {
        return true;
    }

    @Override
    public void onNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull ImageView child, @NonNull View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type, @NonNull int[] consumed) {
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, type, consumed);

        if(target.getScrollY()>0){
           ViewGroup.LayoutParams params =  child.getLayoutParams();
           params.height= params.height-Math.abs(dyConsumed);
           if(params.height <0){
               params.height = 0;
           }
           child.setLayoutParams(params);

        }
        else {
            ViewGroup.LayoutParams params =  child.getLayoutParams();
            params.height= params.height+Math.abs(dyUnconsumed);
            if(params.height >MAX_HEIGHT){
                params.height = MAX_HEIGHT;
            }
            child.setLayoutParams(params);
        }


    }


}
