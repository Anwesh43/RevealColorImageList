package com.anwesome.ui.revealcoloredimagelist;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
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
    private ScreenExpander screenExpander;
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
            screenExpander = new ScreenExpander();
        }
        canvas.drawColor(Color.WHITE);
        canvas.drawBitmap(bitmap,w/20,w/5,paint);
        canvas.save();
        canvas.translate(0,screen.y);
        screenExpander.draw(canvas,paint);
        int color = Color.argb(150,Color.red(this.color),Color.green(this.color),Color.blue(this.color));
        paint.setColor(color);
        canvas.drawRect(new RectF(w/20,w/5,w-w/20,4*w/5),paint);
        canvas.restore();
        time++;
    }
    public void update(float factor) {
        if(screen != null && screenExpander != null) {
            screen.updateY(factor);
            screenExpander.update(factor);
            postInvalidate();
        }
    }
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX(),y = event.getY();
        if(event.getAction() == MotionEvent.ACTION_DOWN && screenExpander != null)  {
            screenExpander.handleTap(x,y);
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
    private class ScreenExpander {
        private float deg = 0,size,x,y,dir = 1;
        public ScreenExpander() {
            this.size = h/20;
            this.x = 17*w/20;
            this.y = h/20;
        }
        public void draw(Canvas canvas,Paint paint) {
            paint.setColor(Color.BLACK);
            canvas.save();
            canvas.translate(x,y);
            canvas.rotate(deg);
            paint.setStrokeWidth(size/10);
            for(int i=0;i<2;i++) {
                canvas.save();
                canvas.rotate(i*deg);
                canvas.drawLine(-size/2,0,size/2,0,paint);
                canvas.restore();
            }
            canvas.restore();
        }
        public void update(float factor) {
            deg = 45*factor;
        }
        public boolean handleTap(float x,float y) {
            y-=screen.y;
            boolean condition = x>=this.x - this.size && x<=this.x+this.size && y>=this.y-this.size && y<=this.y+this.size;
            if(condition) {
                dir *= -1;
            }
            return condition;
        }
    }
}
