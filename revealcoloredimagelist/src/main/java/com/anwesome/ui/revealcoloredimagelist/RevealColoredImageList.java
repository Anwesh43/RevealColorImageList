package com.anwesome.ui.revealcoloredimagelist;

import android.content.Context;
import android.graphics.*;
import android.hardware.display.DisplayManager;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by anweshmishra on 06/05/17.
 */
public class RevealColoredImageList  extends ViewGroup{
    int w,h,sizeOfView;
    public RevealColoredImageList(Context context) {
        super(context);
        initDimension(context);
    }
    public void initDimension(Context context) {
        DisplayManager displayManager = (DisplayManager) context.getSystemService(Context.DISPLAY_SERVICE);
        Display display = displayManager.getDisplay(0);
        Point size = new Point();
        display.getRealSize(size);
        w = size.x;
        h = size.y;
        sizeOfView =9*w/10;
    }
    public void onMeasure(int wspec,int hspec) {
        int newH = sizeOfView/10;
        for(int i=0;i<getChildCount();i++) {
            View child = getChildAt(i);
            child.measure(wspec,hspec);
            newH += 11*(sizeOfView)/10;
        }
        setMeasuredDimension(w,Math.max(h,newH));
    }
    public void onLayout(boolean reloaded,int a,int b,int w,int h) {
        int y = sizeOfView/10,left = this.w/10,right = 19*this.w/20;
        for(int i=0;i<getChildCount();i++) {
            View child = getChildAt(i);
            child.layout(left,y,right,y+sizeOfView);
            y+=(11*sizeOfView)/10;
        }
    }
    public void addImage(Bitmap bitmap,int color) {
        RevealColoredImageView revealColoredImageView = new RevealColoredImageView(getContext(),bitmap,color);
        addView(revealColoredImageView,new LayoutParams(sizeOfView,sizeOfView));
        requestLayout();
    }
}
