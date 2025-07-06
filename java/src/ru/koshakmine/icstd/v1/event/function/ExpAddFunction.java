package ru.koshakmine.icstd.v1.event.function;

import ru.koshakmine.icstd.v1.entity.player.Player;

public interface ExpAddFunction {
    void call(int experience, Player player);
}
