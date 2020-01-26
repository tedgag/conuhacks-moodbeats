package com.example.moodbeats;

import android.content.Context;
import android.graphics.Canvas;
import android.view.SurfaceHolder;


public class GameThread extends Thread {
    public static final int MAX_FPS=30;
    private double avgFPS;
    private SurfaceHolder surfaceHolder;
    private Game game;
    private boolean running;
    public static Canvas canvas;

    public GameThread(SurfaceHolder surfaceHolder, Game game){
        super();
        this.surfaceHolder = surfaceHolder;
        this.game=game;
    }

    @Override
    public void run(){
        long startTime;
        long timeMillis = 1000/MAX_FPS;
        long waitTime;
        int framecount=0;
        int radius=100;
        long totalTime=0;
        long targetTime=1000/MAX_FPS;
        while (running){
            startTime =System.nanoTime();
            canvas = null;
            try{
                canvas=this.surfaceHolder.lockCanvas();
                synchronized(surfaceHolder) {
                    this.game.update();
                    this.game.draw(canvas, radius);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (canvas!=null) {
                    try {
                        surfaceHolder.unlockCanvasAndPost(canvas);
                    } catch (Exception e ) {
                        e.printStackTrace();
                    }
                }
            }
            timeMillis= (System.nanoTime() -startTime)/1000000;
            waitTime = targetTime - timeMillis;
            try {
                if(waitTime>0) {
                    this.sleep(waitTime);
                }
            } catch (Exception e ) {
                e.printStackTrace();
            }
            totalTime += System.nanoTime() - startTime;
            framecount++;
            if (framecount == 60) {
                radius =75;
            } if (framecount == 120) {
                radius= 100;
                framecount=0;
            }
        }
    }
    public void setRunning(boolean running){
        this.running= running;
    }

}
