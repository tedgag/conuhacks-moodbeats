package com.example.moodbeats;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;


public class Game extends SurfaceView implements SurfaceHolder.Callback {
    private GameThread gameThread;
    private static final int MARGIN = 100;
    private int minWidth = MARGIN;
    private int minHeight= MARGIN;
    private int maxWidth;
    private int maxHeight;
    private Circle circle;

    public Game(Context context, int width, int height) {
        super(context);
        this.maxWidth=width-MARGIN;
        this.maxHeight=height-MARGIN;
        this.circle = new Circle(100, 500,500);
        getHolder().addCallback(this);
        gameThread = new GameThread(getHolder(), this);
        setFocusable(true);

    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        gameThread=new GameThread(getHolder(), this);
        gameThread.setRunning(true);
        gameThread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        boolean retry = true;
        while (retry) {
            try {
                gameThread.setRunning(false);
                gameThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            retry = false;
        }

    }

    public boolean onTouchEvent(MotionEvent event) {
        double centerX = circle.getX() + circle.getRadius();
        double centerY = circle.getY() + circle.getRadius();
        double distanceX = event.getX() - centerX;
        double distanceY = event.getY() - centerY;

        boolean inside = isInside(distanceX,distanceY,circle.getRadius());
        if (inside) {
            circle = null;
            return true;
        }
        return false;
    }
    public void update(){
        System.out.println(maxHeight + " " +maxWidth);
    }
    public void draw(Canvas canvas, int radius){
        super.draw(canvas);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLUE);
        canvas.drawCircle(100,100,radius,paint);
    }

    boolean isInside(double distanceX, double distanceY, int radius) {
        return (distanceX * distanceX) + (distanceY * distanceY) <= radius * radius;
    }
}
