package ru.practicum.emojicon.model;

import ru.practicum.emojicon.engine.Drawable;
import ru.practicum.emojicon.engine.Frame;
import ru.practicum.emojicon.engine.Point;

public class EmojiWorldObject implements Drawable {

    private EmojiObject inner;

    private int x;
    private int y;
    private int z; //order

    public EmojiWorldObject(EmojiObject obj, Point position) {
        this.inner = obj;
        this.x = position.getX();
        this.y = position.getY();
        this.z = 0;
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

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    @Override
    public void drawFrame(Frame frame) {
        inner.drawFrame(frame);
    }
}
