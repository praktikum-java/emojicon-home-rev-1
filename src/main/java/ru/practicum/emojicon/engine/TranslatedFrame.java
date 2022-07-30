package ru.practicum.emojicon.engine;

import com.googlecode.lanterna.TextColor;
import com.vdurmont.emoji.Emoji;

//фрейм для изолированного рисования объектов, пока наследуем от Frame.
public class TranslatedFrame extends AbstractFrame {

    private final Frame rootFrame;
    private int dx;
    private int dy;

    public TranslatedFrame(Frame rootFrame, Point dp){
        super(0, 0, Integer.MAX_VALUE, Integer.MAX_VALUE);
        this.rootFrame = rootFrame;
        this.dx = dp.getX();
        this.dy = dp.getY();
    }

    protected TranslatedFrame(Frame rootFrame, int left, int top, int right, int bottom) {
        super(left, top, right, bottom);
        this.rootFrame = rootFrame;
        this.dx = 0;
        this.dy = 0;
    }

    @Override
    public void setPosition(int x, int y) {
        rootFrame.setPosition(x + dx, y + dy);
    }

    @Override
    public Point paint() {
        return rootFrame.paint();
    }

    @Override
    public Point draw(Character character) {
        return rootFrame.draw(character);
    }

    @Override
    public Point draw(Emoji emoji) {
        return rootFrame.draw(emoji);
    }

    @Override
    public Frame getRoot() {
        return rootFrame.getRoot();
    }

    public int getDx() {
        return dx;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public int getDy() {
        return dy;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }

    @Override
    public void setFillColor(TextColor fillColor) {
        super.setFillColor(fillColor);
        rootFrame.setFillColor(fillColor);
    }

    @Override
    public void setColor(TextColor color) {
        super.setColor(color);
        rootFrame.setColor(color);
    }

    @Override
    public void setTransparentColor(TextColor color) {
        super.setTransparentColor(color);
        rootFrame.setTransparentColor(color);
    }
}
