package com.example.moodbeats;

import android.util.DisplayMetrics;

import java.util.Random;

public class Circle {

    private int radius = 200;
    private int x;
    private int y;

    private static int screenHeight;
    private static int screenWidth;

    public static int getScreenHeight() {
        return screenHeight;
    }

    public static void setScreenHeight(int screenHeight) {
        Circle.screenHeight = screenHeight;
    }

    public static int getScreenWidth() {
        return screenWidth;
    }

    public static void setScreenWidth(int screenWidth) {
        Circle.screenWidth = screenWidth;
    }

    private Random rand = new Random();

    Circle(int radius, int x, int y) {
        this.radius = radius;
        this.x = x;
        this.y = y;

        // need to check if inputted coordinates do not overlap over a currently placed circle

    }

    Circle() {
        this.setCoords();

        // need to check if generated coordinates do not overlap over a currently placed circle

    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setCoords() {
        int newX, newY;
        //do {
        newX = rand.nextInt(screenWidth);
        newY = rand.nextInt(screenHeight);

        //} while (checkCollision(this) > radius);

        x = newX;
        y = newY;
    }

    public void draw() {

    }

    public void destroy(Circle circle) {

    }

    public float checkCollision(Circle circle) {
        float distanceX = this.x+radius - circle.getX() + radius;
        float distanceY = this.y+radius - circle.getY() + radius;

        return distanceX * distanceX + distanceY * distanceY;
    }
}