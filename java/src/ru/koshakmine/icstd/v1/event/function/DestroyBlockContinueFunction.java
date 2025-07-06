package ru.koshakmine.icstd.v1.event.function;

import com.zhekasmirnov.apparatus.adapter.innercore.game.block.BlockState;
import ru.koshakmine.icstd.v1.utils.type.common.Position;

public interface DestroyBlockContinueFunction {
    void call(Position position, BlockState state, float progress);
}
