package ru.practicum.emojicon.model;

import com.googlecode.lanterna.TextColor;
import ru.practicum.emojicon.engine.Frame;

import java.util.ArrayList;
import java.util.List;

public class EmojiWorld extends EmojiObject {

    private List<EmojiWorldObject> objects = new ArrayList<>();

    public EmojiWorld(){
        this.setWidth(2048);
        this.setHeight(2048);
    }

    @Override
    public void drawFrame(Frame frame) {
        drawEarth(frame);
    }

    private void drawEarth(Frame frame) {
        for(int x = frame.getLeft(); x <= frame.getRight(); x++){
            for (int y = frame.getTop(); y <= frame.getBottom(); y++){
                frame.setPosition(x, y);
                frame.fill(TextColor.ANSI.BLACK_BRIGHT);
                frame.paint();
            }
        }
    }
}
