package ru.koshakmine.icstd.v1.item.event;

import ru.koshakmine.icstd.v1.utils.type.common.ItemStack;
import ru.koshakmine.icstd.v1.utils.type.common.Texture;

public interface OverrideIconComponent {
    Texture onOverrideIcon(ItemStack stack, boolean isMod);
}
