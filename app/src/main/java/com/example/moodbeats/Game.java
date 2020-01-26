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


    public Game(Context context) {
        super(context);

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
        return super.onTouchEvent(event);
    }
    public void update(){

    }
    public void draw(Canvas canvas){
        super.draw(canvas);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLUE);
        canvas.drawCircle(100,100,100,paint);
    }
}
