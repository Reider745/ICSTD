package ru.koshakmine.icstd.v1.event.function;

import ru.koshakmine.icstd.v1.entity.Entity;
import ru.koshakmine.icstd.v1.entity.EntityItem;
import ru.koshakmine.icstd.v1.utils.type.common.ItemStack;

public interface EntityPickUpDropFunction {
    void call(Entity entity, EntityItem item, ItemStack itemStack, int count);
}
