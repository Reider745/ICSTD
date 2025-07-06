package ru.koshakmine.icstd.v1.event.function;

import ru.koshakmine.icstd.v1.entity.player.Player;
import ru.koshakmine.icstd.v1.utils.type.common.ItemStack;

public interface ItemUsingReleasedFunction {
    void call(ItemStack itemStack, int ticks, Player player);
}
