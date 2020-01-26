package com.example.moodbeats;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.TextView;

import java.util.ArrayList;


public class Game extends SurfaceView implements SurfaceHolder.Callback {
    private GameThread gameThread;
    private static final int MARGIN = 100;
    private int minWidth = MARGIN;
    private int minHeight= MARGIN;
    private int maxWidth;
    private int maxHeight;
    //private Circle circle;
    private ArrayList<Circle> circles;
    int count = 0;
    private static final int MAX_CIRCLES = 10;
    double touchX, touchY;
    TextView scoreTXT;
    int score = 0;


    public Game(Context context, int width, int height) {
        super(context);
        this.maxWidth=width-MARGIN;
        this.maxHeight=height-MARGIN;
        //this.circle = new Circle(100, 500,500);
        circles = new ArrayList<>();
        scoreTXT = (TextView) findViewById(R.id.txt_score);
        for(int i = 0; i < MAX_CIRCLES; i++)
            circles.add(new Circle());

        for(int i = 0; i < MAX_CIRCLES; i++) {
            Log.d("X:", String.valueOf(circles.get(i).getX()));
        }

        getHolder().addCallback(this);
        gameThread = new GameThread(getHolder(), this, circles);
        setFocusable(true);

    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        gameThread=new GameThread(getHolder(), this, circles);
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
        Circle circle;

        for(int i = 0; i < circles.size(); i++) {
            circle = circles.get(i);
            double centerX = circle.getX() + circle.getRadius();
            double centerY = circle.getY() + circle.getRadius();
            double distanceX = event.getX() - centerX;
            double distanceY = event.getY() - centerY;

            boolean inside = isInside(distanceX, distanceY, circle.getRadius());
            Log.d("INSIDE?", String.valueOf(inside));
            if (inside) {
                circles.remove(circle);
                score += 100;
                scoreTXT.setText(score);
                return true;
            }
        }
        return false;
    }
    public void update(){
        System.out.println(maxHeight + " " +maxWidth);

        for(int i = circles.size(); i < MAX_CIRCLES; i++)
            circles.add(new Circle());
        gameThread.setCircles(circles);

    }
    public void draw(Canvas canvas, int radius, ArrayList<Circle> circles){
        super.draw(canvas);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLUE);
        for(int i = 0; i < circles.size(); i++) {
            Circle circle = circles.get(i);
            circle.setRadius(radius);
            canvas.drawCircle(circle.getX(), circle.getY(), radius, paint);
        }
    }

    boolean isInside(double distanceX, double distanceY, double radius) {
        return (distanceX * distanceX) + (distanceY * distanceY) <= radius * radius;
    }
}
