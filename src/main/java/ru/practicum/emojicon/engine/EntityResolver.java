package ru.practicum.emojicon.engine;

import java.util.Optional;
import java.util.UUID;

public interface EntityResolver {

    Optional<? extends Entity> findEntity(UUID uuid);
}
