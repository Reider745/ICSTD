package ru.koshakmine.icstd.v1.event.function;

import ru.koshakmine.icstd.v1.entity.Entity;
import ru.koshakmine.icstd.v1.entity.player.Player;
import ru.koshakmine.icstd.v1.utils.type.common.Position;

public interface EntityInteractFunction {
    void call(Entity entity, Player player, Position position);
}
