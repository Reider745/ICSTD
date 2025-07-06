package ru.koshakmine.icstd.v1.item.event;

import ru.koshakmine.icstd.v1.entity.player.Player;
import ru.koshakmine.icstd.v1.utils.type.common.BlockData;
import ru.koshakmine.icstd.v1.utils.type.common.BlockPosition;
import ru.koshakmine.icstd.v1.utils.type.common.ItemStack;

public interface ClickableComponent {
    void onClick(BlockPosition position, ItemStack item, BlockData block, Player player);
}
