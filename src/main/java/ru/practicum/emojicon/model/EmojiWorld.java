package ru.practicum.emojicon.model;

import com.googlecode.lanterna.TextColor;
import ru.practicum.emojicon.engine.Frame;
import ru.practicum.emojicon.engine.Point;
import ru.practicum.emojicon.engine.TranslatedFrame;

import java.util.ArrayList;
import java.util.List;

public class EmojiWorld extends EmojiObject implements EmojiObjectHolder {

    private List<EmojiWorldObject> objects = new ArrayList<>();

    public EmojiWorld(){
        this.setWidth(2048);
        this.setHeight(2048);
    }

    @Override
    public void drawFrame(Frame frame) {
        drawEarth(frame);
        drawObjects(frame);
    }

    private void drawObjects(Frame frame) {
        objects.stream()
                .filter(obj -> frame.getLeft() <= obj.getX() && frame.getRight() >= obj.getX() && frame.getTop() <= obj.getY() && frame.getBottom() >= obj.getY())
                .forEach(obj -> {
                    TranslatedFrame objFrame = new TranslatedFrame(frame, new Point(obj.getX(), obj.getY()));
                    objFrame.transparent(TextColor.ANSI.BLACK_BRIGHT);
                    obj.drawFrame(objFrame);
                });
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

    @Override
    public void addObject(EmojiObject obj, Point position) {
        EmojiWorldObject wobj = new EmojiWorldObject(obj, position);
        addWorldObject(wobj);
    }

    private void addWorldObject(EmojiWorldObject obj) {
        objects.add(obj);
    }
}
