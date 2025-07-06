package ru.koshakmine.icstd.v1.event.function;

import ru.koshakmine.icstd.v1.entity.player.Player;
import ru.koshakmine.icstd.v1.utils.type.common.ItemStack;

public interface ItemUseNoTargetFunction {
    void call(ItemStack itemStack, Player player);
}
