package ru.practicum.emojicon.engine;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import ru.practicum.emojicon.model.EmojiWorld;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.time.Period;

public class Engine implements Runnable {

    //время одного кадра при частоте в 60 FPS
    private static final Long FRAME_TIME = 1000L / 60;
    private Terminal terminal;
    private Screen screen;
    private Drawable root;
    private Camera camera;

    private Instant timestamp;

    public Engine(){
        try {
            this.terminal = new DefaultTerminalFactory(System.out, System.in, StandardCharsets.UTF_8).createTerminal();
            this.screen = new TerminalScreen(terminal);
            this.timestamp = Instant.now();
            TerminalSize size = getTerminalSize();
            this.camera = new Camera(0, 0, size.getColumns(), size.getRows());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private TerminalSize getTerminalSize() {
        try {
            return terminal.getTerminalSize();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        try {
            screen.startScreen();
            KeyStroke key;
            do {
                key = screen.pollInput();
                screen.clear();
                Frame rootFrame = camera.getFrame(screen);
                root.drawFrame(rootFrame);
                screen.refresh(Screen.RefreshType.DELTA);
                long dt = Instant.now().toEpochMilli() - timestamp.toEpochMilli();
                timestamp = Instant.now();
                Thread.sleep(Math.max(0, FRAME_TIME - dt)); //сколько-то времени ушло на кадр
            } while (key == null || !(key.getKeyType().equals(KeyType.Escape)));
            screen.stopScreen();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void setRoot(Drawable root) {
        this.root = root;
    }
}
