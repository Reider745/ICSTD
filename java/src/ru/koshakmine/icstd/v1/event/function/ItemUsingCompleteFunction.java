package ru.koshakmine.icstd.v1.event.function;

import ru.koshakmine.icstd.v1.entity.player.Player;
import ru.koshakmine.icstd.v1.utils.type.common.ItemStack;

public interface ItemUsingCompleteFunction {
    void call(ItemStack item, Player player);
}
