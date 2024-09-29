package ru.koshakmine.icstd.event.function;

import com.zhekasmirnov.apparatus.adapter.innercore.game.block.BlockState;
import ru.koshakmine.icstd.commontypes.Position;

public interface DestroyBlockFunction {
    void call(Position position, BlockState state, long playerId);
}
