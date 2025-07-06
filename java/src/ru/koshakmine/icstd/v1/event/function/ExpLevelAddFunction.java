package ru.koshakmine.icstd.v1.event.function;

import ru.koshakmine.icstd.v1.entity.player.Player;

public interface ExpLevelAddFunction {
    void call(int level, Player player);
}
