package ru.practicum.emojicon.engine;

import com.googlecode.lanterna.TextColor;
import com.vdurmont.emoji.Emoji;

public interface Frame {

    int getLeft();

    int getTop();

    int getRight();

    int getBottom();

    int getPosX();

    int getPosY();

    TextColor getTransparentColor();

    TextColor getFillColor();

    TextColor getColor();

    void setPosition(int x, int y);

    void setFillColor(TextColor fillColor);

    void setColor(TextColor color);

    void setTransparentColor(TextColor color);

    Point paint();

    Point draw(Character character);

    Point draw(Emoji emoji);

    Frame getRoot();
}
