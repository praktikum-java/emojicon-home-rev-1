package ru.practicum.emojicon.engine;

import com.googlecode.lanterna.TerminalSize;

public class Point {

    private int x;
    private int y;

    public Point() {
        this(0, 0);
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(TerminalSize terminalSize) {
        this.x = terminalSize.getColumns();
        this.y = terminalSize.getRows();
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

    public Point dec(int dx, int dy) {
        return inc(-dx, -dy);
    }

    public Point inc(int dx, int dy) {
        return new Point(this.x + dx, this.y + dy);
    }
}
