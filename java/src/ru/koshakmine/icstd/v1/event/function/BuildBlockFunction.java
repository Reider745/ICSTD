package ru.koshakmine.icstd.v1.event.function;

import com.zhekasmirnov.apparatus.adapter.innercore.game.block.BlockState;
import ru.koshakmine.icstd.v1.entity.player.Player;
import ru.koshakmine.icstd.v1.utils.type.common.Position;

public interface BuildBlockFunction {
    void call(Position position, BlockState state, Player player);
}
