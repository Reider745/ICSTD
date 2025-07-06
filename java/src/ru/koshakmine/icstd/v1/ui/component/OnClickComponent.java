package ru.koshakmine.icstd.v1.ui.component;

import com.zhekasmirnov.apparatus.api.container.ItemContainer;
import ru.koshakmine.icstd.v1.utils.type.common.Position;

public interface OnClickComponent {
    void onClick(ItemContainer container, Position position);
}
