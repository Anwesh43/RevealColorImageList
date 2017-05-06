package com.anwesome.ui.revealcoloredimagelist;

import android.app.Activity;
import android.graphics.Bitmap;
import android.widget.ScrollView;

/**
 * Created by anweshmishra on 06/05/17.
 */
public class RevealImageList {
    private Activity activity;
    private ScrollView scrollView;
    private boolean isShown = false;
    public RevealImageList(Activity activity) {
        this.activity = activity;
    }
    public void addImageAndColor(Bitmap bitmap,int color) {
        if(!isShown) {

        }
    }
    public void show() {
        if(!isShown) {
            isShown = true;
        }
    }
}
