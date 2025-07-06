package ru.koshakmine.icstd.v1.block.component;

import ru.koshakmine.icstd.v1.entity.player.Player;
import ru.koshakmine.icstd.v1.level.Level;
import ru.koshakmine.icstd.v1.utils.type.common.BlockData;
import ru.koshakmine.icstd.v1.utils.type.common.BlockPosition;
import ru.koshakmine.icstd.v1.utils.type.common.ItemStack;
import ru.koshakmine.icstd.v1.utils.type.common.Position;

public interface PlaceComponent {
    Position onPlace(BlockPosition position, ItemStack item, BlockData block, Player player, Level level);
}
