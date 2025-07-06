package ru.koshakmine.icstd.v1.event.function;

import ru.koshakmine.icstd.v1.level.Level;
import ru.koshakmine.icstd.v1.utils.type.common.BlockData;
import ru.koshakmine.icstd.v1.utils.type.common.Position;

public interface BlockEventNeighbourChangeFunction {
    void call(Position position, BlockData block, Position neighbourPosition, Level blockSource);
}
