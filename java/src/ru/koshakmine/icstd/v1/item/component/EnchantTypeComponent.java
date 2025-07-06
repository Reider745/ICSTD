package ru.koshakmine.icstd.v1.item.component;

public interface EnchantTypeComponent {
    int getEnchantType();
    default int getEnchantability() {
        return 14;
    }
}
