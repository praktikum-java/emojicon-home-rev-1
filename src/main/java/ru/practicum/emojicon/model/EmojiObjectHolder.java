package ru.practicum.emojicon.model;

import ru.practicum.emojicon.engine.Point;

import java.util.UUID;

public interface EmojiObjectHolder {

    UUID addObject(EmojiObject obj, Point position);

    boolean isFreeArea(int left, int top, int right, int bottom);

}
