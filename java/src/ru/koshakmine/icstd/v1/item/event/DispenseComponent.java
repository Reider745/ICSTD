package ru.koshakmine.icstd.v1.item.event;

import ru.koshakmine.icstd.v1.level.Level;
import ru.koshakmine.icstd.v1.utils.type.common.BlockPosition;
import ru.koshakmine.icstd.v1.utils.type.common.ItemStack;

public interface DispenseComponent {
    void onDispense(BlockPosition position, ItemStack item, Level level, int slot);
}
