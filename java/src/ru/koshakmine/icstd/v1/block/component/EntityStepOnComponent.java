package ru.koshakmine.icstd.v1.block.component;

import ru.koshakmine.icstd.v1.entity.Entity;
import ru.koshakmine.icstd.v1.utils.type.common.BlockData;
import ru.koshakmine.icstd.v1.utils.type.common.Position;

public interface EntityStepOnComponent {
    void onEntityStepOn(Position position, BlockData block, Entity entity);
}
