package ru.koshakmine.icstd.v1.event.function;

import ru.koshakmine.icstd.v1.entity.player.Player;

public interface PlayerTickFunction {
    void call(Player player, boolean isDead);
}
