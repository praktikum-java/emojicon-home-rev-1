package ru.practicum.emojicon;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Main {

    private final static Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws IOException {
        Terminal terminal = new DefaultTerminalFactory(System.out, System.in, StandardCharsets.UTF_8).createTerminal();
        TerminalScreen screen = new TerminalScreen(terminal);
        TerminalSize size = screen.getTerminalSize();
        screen.startScreen();
        log.info("screen started {}x{}", size.getColumns(), size.getRows());
        KeyStroke key;
        do {
            screen.setCharacter(0, 0, TextCharacter.DEFAULT_CHARACTER.withCharacter('@'));
            screen.refresh();
            key = screen.readInput();
        } while (!key.getKeyType().equals(KeyType.Escape));
        screen.stopScreen();
    }
}
