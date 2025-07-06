package ru.koshakmine.icstd.v1.block.component;

import ru.koshakmine.icstd.v1.level.Level;
import ru.koshakmine.icstd.v1.utils.type.common.BlockData;
import ru.koshakmine.icstd.v1.utils.type.common.EnchantData;
import ru.koshakmine.icstd.v1.utils.type.common.ItemStack;
import ru.koshakmine.icstd.v1.utils.type.common.Position;

public interface DropComponent {
    ItemStack[] getDrop(Position position, BlockData block, Level level, int diggingLevel, EnchantData enchant, ItemStack item);
}
