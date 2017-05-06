package com.anwesome.ui.revealcoloredimagelist;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by anweshmishra on 06/05/17.
 */
public class RevealColoredImageView extends View {
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Bitmap bitmap;
    private int color;
    private int time = 0;
    public RevealColoredImageView(Context context, Bitmap bitmap,int color) {
        super(context);
        this.color = color;
        this.bitmap = bitmap;
    }
    public void onDraw(Canvas canvas) {
        int w = canvas.getWidth();
        if(time == 0) {
            bitmap = Bitmap.createScaledBitmap(bitmap,w,3*w/5,true);
        }
        canvas.drawColor(Color.WHITE);
        canvas.drawBitmap(bitmap,0,w/5,paint);
        time++;
    }
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN)  {

        }
        return true;
    }
}
