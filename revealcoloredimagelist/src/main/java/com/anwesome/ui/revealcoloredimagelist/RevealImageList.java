package com.anwesome.ui.revealcoloredimagelist;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.ViewGroup;
import android.widget.ScrollView;

/**
 * Created by anweshmishra on 06/05/17.
 */
public class RevealImageList {
    private Activity activity;
    private ScrollView scrollView;
    private RevealColoredImageList revealColoredImageList;
    private boolean isShown = false;
    public RevealImageList(Activity activity) {
        this.activity = activity;
        revealColoredImageList = new RevealColoredImageList(activity);
        scrollView = new ScrollView(activity);
        scrollView.addView(revealColoredImageList,new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
    }
    public void addImageAndColor(Bitmap bitmap,int color) {
        if(!isShown) {
            revealColoredImageList.addImage(bitmap,color);
        }
    }
    public void show() {
        if(!isShown) {
            activity.setContentView(scrollView);
            isShown = true;
        }
    }
}
