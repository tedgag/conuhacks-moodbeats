package com.example.moodbeats;

import android.graphics.Canvas;
import android.view.SurfaceHolder;
import java.util.Random;

public class GameThread extends Thread {

    Random randX = new Random();
    Random randY = new Random();
    int xCoordinate = randX.nextInt(20);
    int yCoordinate = randY.nextInt(20);
    private int FPS = 30;
    private double avgFPS;
    private SurfaceHolder surfaceHolder;
    private Game game;
    private boolean running;
    private static Canvas canvas;

    public GameThread(SurfaceHolder surfaceHolder, Game game){
        super();
        this.surfaceHolder = surfaceHolder;
        this.game=game;
    }

    @Override
    public void run() {
        long startTime;
        long timeMillis;
        long waitTime;
        long totalTime = 0;
        int frameCount = 0;
        long targetTime = 1000/FPS;
        while (running){
            startTime = System.nanoTime();
            canvas = null;
            try {
                canvas = this.surfaceHolder.lockCanvas();
                synchronized (surfaceHolder) {
                    this.game.update();
                    this.game.draw(canvas);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (canvas != null) {
                    try {
                        surfaceHolder.unlockCanvasAndPost(canvas);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            timeMillis = (System.nanoTime() - startTime)/1000000;
            waitTime = targetTime - timeMillis;
            try {
                this.sleep(waitTime);
            } catch (Exception e) {
                e.printStackTrace();
            }
            totalTime += System.nanoTime() - startTime;
            frameCount++;
            if (frameCount == FPS) {
                avgFPS = 1000/((totalTime/frameCount)/1000000);
                frameCount = 0;
                totalTime = 0;
                System.out.println(avgFPS);
            }

        }
    }
    public void setRunning(boolean isRunning) {
        running = isRunning;

    }
}
