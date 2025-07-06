package ru.koshakmine.icstd.v1.event.function;

import ru.koshakmine.icstd.v1.utils.type.common.BlockData;
import ru.koshakmine.icstd.v1.utils.type.common.BlockPosition;
import ru.koshakmine.icstd.v1.utils.type.common.ItemStack;
import ru.koshakmine.icstd.v1.entity.player.Player;

public interface ItemUseFunction {
    void call(BlockPosition position, ItemStack itemStack, BlockData blockData, Player player);
}
