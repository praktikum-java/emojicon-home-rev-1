package ru.practicum.emojicon.engine;

import com.googlecode.lanterna.screen.Screen;

public class Camera {

    private int left;

    private int top;

    private int right;

    private int bottom;

    public Camera(int left, int top, int right, int bottom) {
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
    }

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public int getRight() {
        return right;
    }

    public void setRight(int right) {
        this.right = right;
    }

    public int getBottom() {
        return bottom;
    }

    public void setBottom(int bottom) {
        this.bottom = bottom;
    }

    public void setLeftTop(Point point){
        this.left = point.getX();
        this.top = point.getY();
    }

    public void setRightBottom(Point point){
        this.right = point.getX();
        this.bottom = point.getY();
    }

    public Frame getFrame(Screen screen) {
        return new Frame(screen, left, top, right, bottom);
    }
}
