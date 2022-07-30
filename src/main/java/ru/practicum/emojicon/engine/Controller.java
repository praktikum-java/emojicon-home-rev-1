package ru.practicum.emojicon.engine;

import com.googlecode.lanterna.input.KeyStroke;

import java.util.List;
import java.util.UUID;

public interface Controller {

    void handleKey(KeyStroke key);

    void setSelection(UUID ...objectId);

    List<UUID> getSelection();


}
