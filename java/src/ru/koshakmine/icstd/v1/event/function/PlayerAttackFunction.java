package ru.koshakmine.icstd.v1.event.function;

import ru.koshakmine.icstd.v1.entity.Entity;
import ru.koshakmine.icstd.v1.entity.player.Player;

public interface PlayerAttackFunction {
    void call(Entity entity, Player attacker);
}
