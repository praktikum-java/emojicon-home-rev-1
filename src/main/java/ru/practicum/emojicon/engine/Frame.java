package ru.practicum.emojicon.engine;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.screen.Screen;
import com.vdurmont.emoji.Emoji;

public class Frame {
    private final int left;
    private final int top;
    private final int right;
    private final int bottom;

    private int posX;
    private int posY;
    private TextColor fillColor;
    private TextColor color;
    Screen screen;

    public Frame(Screen screen, int left, int top, int right, int bottom) {
        this.screen = screen;
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
        this.posX = 0;
        this.posY = 0;
        this.fillColor = this.color = TextColor.ANSI.BLACK;
    }

    public int getLeft() {
        return left;
    }

    public int getTop() {
        return top;
    }

    public int getRight() {
        return right;
    }

    public int getBottom() {
        return bottom;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public TextColor getFillColor() {
        return fillColor;
    }

    public TextColor getColor() {
        return color;
    }

    //set position for painting
    public void setPosition(int x, int y){
        if(x < left || x > right || y < top || y > bottom)
            throw new IllegalArgumentException("position out of bounds");

        posX = x - left;
        posY = y - top;
    }

    //set background color
    public void fill(TextColor fillColor){
        this.fillColor = fillColor;
    }

    //set paint color
    public void color(TextColor color){
        this.color = color;
    }

    //paint it with background color
    public Point paint(){
        screen.setCharacter(posX, posY, TextCharacter.DEFAULT_CHARACTER.withCharacter(' ').withBackgroundColor(fillColor));
        return new Point(1, 1);
    }

    //draw single character or
    public Point draw(Character character){
        screen.setCharacter(posX, posY, TextCharacter.DEFAULT_CHARACTER.withCharacter(character).withForegroundColor(color).withBackgroundColor(fillColor));
        return new Point(1, 1);
    }

    //draw emoji
    //some emoji take more than one symbol
    public Point draw(Emoji emoji){
        TextCharacter[] chars = TextCharacter.fromString(emoji.getUnicode());
        for(int c = 0; c < chars.length; c++){
            screen.setCharacter(posX, posY, chars[c].withForegroundColor(color).withBackgroundColor(fillColor));
        }
        return new Point(chars.length, 1);
    }
}
