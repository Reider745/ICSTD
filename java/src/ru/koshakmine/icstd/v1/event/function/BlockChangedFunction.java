package ru.koshakmine.icstd.v1.event.function;

import ru.koshakmine.icstd.v1.level.Level;
import ru.koshakmine.icstd.v1.utils.type.common.BlockData;
import ru.koshakmine.icstd.v1.utils.type.common.Position;

public interface BlockChangedFunction {
    void call(Position coords, BlockData oldState, BlockData newState, Level source);
}
