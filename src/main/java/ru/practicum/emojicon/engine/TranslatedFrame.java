package ru.practicum.emojicon.engine;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.screen.Screen;
import com.vdurmont.emoji.Emoji;

public class TranslatedFrame extends Frame {

    private final Frame rootFrame;
    private final int dx;
    private final int dy;

    public TranslatedFrame(Frame rootFrame, Point dp){
        super(null, 0, 0, Integer.MAX_VALUE, Integer.MAX_VALUE);
        this.rootFrame = rootFrame;
        this.dx = dp.getX();
        this.dy = dp.getY();
    }

    private TranslatedFrame(Screen screen, int left, int top, int right, int bottom) {
        super(screen, left, top, right, bottom);
        throw new IllegalArgumentException();
    }

    @Override
    public void fill(TextColor fillColor) {
        super.fill(fillColor);
        rootFrame.fill(fillColor);
    }

    @Override
    public void color(TextColor color) {
        super.color(color);
        rootFrame.color(color);
    }

    @Override
    public void transparent(TextColor color) {
        super.transparent(color);
        rootFrame.transparent(color);
    }

    @Override
    public void setPosition(int x, int y) {
        super.setPosition(x, y);
        rootFrame.setPosition(x + dx + rootFrame.getLeft(), y + dy + rootFrame.getTop());
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
}
