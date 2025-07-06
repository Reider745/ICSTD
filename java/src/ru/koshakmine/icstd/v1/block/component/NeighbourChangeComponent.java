package ru.koshakmine.icstd.v1.block.component;

import ru.koshakmine.icstd.v1.level.Level;
import ru.koshakmine.icstd.v1.utils.type.common.BlockData;
import ru.koshakmine.icstd.v1.utils.type.common.Position;

public interface NeighbourChangeComponent {
    void onNeighbourChanged(Position position, Position changePosition, BlockData block, Level level);
}
