package ru.practicum.emojicon.engine;

import com.googlecode.lanterna.screen.Screen;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.UUID;

public class Camera {

    private Logger log = LoggerFactory.getLogger(getClass());

    private final Engine engine;

    private int left;

    private int top;

    private int right;

    private int bottom;

    private int dx;

    private int dy;

    public Camera(Engine engine, int left, int top, int right, int bottom) {
        this.engine = engine;
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
        this.dx = 0;
        this.dy = 0;
    }

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public int getRight() {
        return right;
    }

    public void setRight(int right) {
        this.right = right;
    }

    public int getBottom() {
        return bottom;
    }

    public void setBottom(int bottom) {
        this.bottom = bottom;
    }

    public void setLeftTop(Point point){
        this.left = point.getX();
        this.top = point.getY();
    }

    public void setRightBottom(Point point){
        this.right = point.getX();
        this.bottom = point.getY();
    }

    public Frame getFrame(Screen screen) {
        Frame realFrame = new RootFrame(screen, right, bottom);
        TranslatedFrame fakeFrame = new TranslatedFrame(realFrame, left + dx, top + dy, right + dx, bottom + dy);
        fakeFrame.setDx(-dx);
        fakeFrame.setDy(-dy);
        return fakeFrame;
    }

    public void handleSelection(Controller controller) {
        List<UUID> selectedIds = controller.getSelection();
        if(selectedIds.size() == 1) {
            engine.findEntity(selectedIds.get(0)).filter(e -> e instanceof Boxed).map(e -> (Boxed) e).ifPresent(box -> {
                int hotLeft = this.left + dx;
                int hotTop = this.top + dy;
                int hotRight = this.right + dx;
                int hotBottom = this.bottom + dy;
                //двигаем по одному пикселю, тогда камера будет сдвигаться медленее, покадрово
                if(box.getRight() > 0 && box.getRight() <= hotLeft){
                    dx--;
                } else if (box.getLeft() >= hotRight){
                    dx++;
                }
                if(box.getBottom() > 0 && box.getBottom() <= hotTop) {
                    dy--;
                } else if (box.getTop() >= hotBottom) {
                    dy++;
                }
            });
        } else {
            throw new IllegalArgumentException();
            //TODO разобраться с множественными выбранными объектами если такие будут
        }
    }
}
