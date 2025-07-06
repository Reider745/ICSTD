package ru.koshakmine.icstd.v1.item.event;

import ru.koshakmine.icstd.v1.utils.type.common.ItemStack;

public interface OverrideNameComponent {
    String onOverrideName(ItemStack item, String name, String translate);
}
