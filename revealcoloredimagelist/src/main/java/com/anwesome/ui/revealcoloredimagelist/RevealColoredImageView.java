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
    private int w,h;
    private Screen screen;
    public RevealColoredImageView(Context context, Bitmap bitmap,int color) {
        super(context);
        this.color = color;
        this.bitmap = bitmap;
    }
    public void onDraw(Canvas canvas) {
        w = canvas.getWidth();
        h = canvas.getHeight();
        if(time == 0) {
            screen = new Screen();
            bitmap = Bitmap.createScaledBitmap(bitmap,9*w/10,3*w/5,true);
        }
        canvas.drawColor(Color.WHITE);
        canvas.drawBitmap(bitmap,0,w/20,paint);
        canvas.save();
        canvas.translate(0,screen.y);
        canvas.restore();
        time++;
    }
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN)  {

        }
        return true;
    }
    private class Screen {
        private float y,initY;
        public Screen() {
            this.y = 4*h/5;
            this.initY = this.y;
        }
        public void updateY(float factor) {
            y = initY*(1-factor);
        }
    }
}
