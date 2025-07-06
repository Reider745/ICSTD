package ru.koshakmine.icstd.v1.event.function;

import ru.koshakmine.icstd.v1.entity.player.Player;

public interface FoodEatenFunction {
    void call(int food, float ratio, Player player);
}
