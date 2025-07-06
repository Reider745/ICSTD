package ru.koshakmine.icstd.v1.block.component;

import ru.koshakmine.icstd.v1.level.Level;
import ru.koshakmine.icstd.v1.utils.type.common.BlockData;
import ru.koshakmine.icstd.v1.utils.type.common.Position;

public interface RandomTickingComponent {
    void onRandomTick(Position position, BlockData block, Level level);
}
