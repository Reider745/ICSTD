package ru.koshakmine.icstd.v1.block.component;

import ru.koshakmine.icstd.v1.block.blockentity.BlockEntity;
import ru.koshakmine.icstd.v1.level.Level;
import ru.koshakmine.icstd.v1.utils.type.common.Position;

public interface BlockEntityHolderComponent {
    BlockEntity createBlockEntity(Position position, Level region);
}
