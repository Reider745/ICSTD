package ru.koshakmine.icstd.v1.block.component;

import ru.koshakmine.icstd.v1.entity.Entity;
import ru.koshakmine.icstd.v1.utils.type.common.BlockData;
import ru.koshakmine.icstd.v1.utils.type.common.Position;

public interface EntityInsideComponent {
    void onEntityInside(Position position, BlockData block, Entity entity);
}
