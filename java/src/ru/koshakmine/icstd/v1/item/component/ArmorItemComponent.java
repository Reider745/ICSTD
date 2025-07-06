package ru.koshakmine.icstd.v1.item.component;

import ru.koshakmine.icstd.v1.utils.type.item.ArmorSlot;

public interface ArmorItemComponent {
    String getArmorPlayerTexture();
    ArmorSlot getSlot();
    int getDefense();
    int getDuration();
    double getKnockbackResist();
}
