package ru.practicum.emojicon.engine;

import com.googlecode.lanterna.screen.Screen;

import java.util.List;
import java.util.UUID;

public class Camera {

    private final Engine engine;

    private int left;

    private int top;

    private int right;

    private int bottom;

    public Camera(Engine engine, int left, int top, int right, int bottom) {
        this.engine = engine;
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
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
        return new Frame(screen, left, top, right, bottom);
    }

    public void handleSelection(Controller controller) {
        List<UUID> selectedIds = controller.getSelection();
        if(selectedIds.size() == 1) {
            engine.findEntity(selectedIds.get(0)).filter(e -> e instanceof Boxed).map(e -> (Boxed) e).ifPresent(box -> {
                int hotLeft = this.left + 5;
                int hotTop = this.top + 5;
                int hotRight = this.right - 5;
                int hotBottom = this.bottom - 5;
                //двигаем по одному пикселю, тогда камера будет сдвигаться медленее, покадрово
                /* TODO fix camera tracking
                if(box.getLeft() < hotLeft){
                    left--;
                    right--;
                } else if (box.getRight() > hotRight){
                    left++;
                    right++;
                }
                if( box.getTop() < hotTop) {
                    top--;
                    bottom--;
                } else if (box.getBottom() > hotBottom) {
                    top++;
                    bottom++;
                }*/
            });
        } else {
            throw new IllegalArgumentException();
            //TODO разобраться с множественными выбранными объектами если такие будут
        }
    }
}
