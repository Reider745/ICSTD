package ru.koshakmine.icstd.v1.block.component;

import ru.koshakmine.icstd.v1.utils.type.common.BlockData;
import ru.koshakmine.icstd.v1.utils.type.common.Position;

public interface AnimationTickingComponent {
    void onAnimationTick(Position position, BlockData block);
}
