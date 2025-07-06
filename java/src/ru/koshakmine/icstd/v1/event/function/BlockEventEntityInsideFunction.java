package ru.koshakmine.icstd.v1.event.function;

import ru.koshakmine.icstd.v1.entity.Entity;
import ru.koshakmine.icstd.v1.utils.type.common.BlockData;
import ru.koshakmine.icstd.v1.utils.type.common.Position;

public interface BlockEventEntityInsideFunction {
    void call(Position position, BlockData block, Entity entity);
}
