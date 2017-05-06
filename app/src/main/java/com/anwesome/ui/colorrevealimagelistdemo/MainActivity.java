package com.anwesome.ui.colorrevealimagelistdemo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.anwesome.ui.revealcoloredimagelist.RevealImageList;

public class MainActivity extends AppCompatActivity {
    private Bitmap bitmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(bitmap == null) {
            bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.img2);
        }
        RevealImageList revealImageList = new RevealImageList(this);
        int colors[] = {Color.parseColor("#009688"),Color.parseColor("#2196F3"),Color.parseColor("#f44336"),Color.parseColor("#FF5722")};
        for(int color:colors) {
            revealImageList.addImageAndColor(bitmap,color);
        }
        revealImageList.show();
    }
}
