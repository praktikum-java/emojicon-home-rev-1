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
    }

    @Override
    public void drawFrame(Frame frame) {
        frame.setPosition(0, 0);
        frame.fill(null);
        frame.color(color);
        frame.draw(emoji);
    }
}
