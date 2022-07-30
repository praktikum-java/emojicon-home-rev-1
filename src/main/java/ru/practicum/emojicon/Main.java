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

    public static void main(String[] args) throws IOException, InterruptedException {
        Terminal terminal = new DefaultTerminalFactory(System.out, System.in, StandardCharsets.UTF_8).createTerminal();
        TerminalScreen screen = new TerminalScreen(terminal);
        TerminalSize size = screen.getTerminalSize();
        screen.startScreen();
        log.info("screen started {}x{}", size.getColumns(), size.getRows());
        KeyStroke key;
        int charKode = 0;
        int row = 1;
        int col = 1;
        do {
            try {
                screen.setCharacter(col, row, TextCharacter.DEFAULT_CHARACTER.withCharacter((char) charKode));
            } catch (IllegalArgumentException e){
                log.error("illegal symbol {}", String.format("0x%08X", charKode));
            }
            Thread.sleep(50);
            screen.refresh();
            key = screen.pollInput();
            charKode++;
            col++;
            if(col + 1 == size.getColumns()){
                if(row + 1 < size.getRows()){
                    col = 1;
                    row++;
                } else {
                    col = 1;
                    row = 1;
                }
            }
        } while (key == null || !key.getKeyType().equals(KeyType.Escape));
        screen.stopScreen();
    }
}
