package ru.practicum.emojicon.model;

import com.googlecode.lanterna.TextColor;
import com.vdurmont.emoji.Emoji;
import com.vdurmont.emoji.EmojiManager;
import ru.practicum.emojicon.engine.Frame;

public class EmojiCat extends EmojiObject {

    Emoji emoji;
    String name;
    TextColor color = TextColor.ANSI.GREEN;

    public EmojiCat(String name){
        this.name = name;
        this.emoji = EmojiManager.getForAlias("cat");
        this.setWidth(2);
        this.setHeight(1);
    }

    @Override
    public void drawFrame(Frame frame) {
        frame.setPosition(0, 0);
        frame.setFillColor(null);
        frame.setColor(color);
        frame.draw(emoji);
    }
}
