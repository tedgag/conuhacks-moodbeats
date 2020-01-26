package com.example.moodbeats;

public class Circle {


    private double radius, posX, posY;


    private boolean clicked;

    public Circle(){
        this.radius = 25;
        this.posX = 0;
        this.posY = 0;

    }
    public Circle(double r, double x, double y){
        this.radius = r;
        this.posX = x;
        this.posY = y;
    }
    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getPosX() {
        return posX;
    }

    public void setPosX(double posX) {
        this.posX = posX;
    }

    public double getPosY() {
        return posY;
    }

    public void setPosY(double posY) {
        this.posY = posY;
    }
    public boolean isClicked() {
        return clicked;
    }

    public void setClicked(boolean clicked) {
        this.clicked = clicked;
    }

}

