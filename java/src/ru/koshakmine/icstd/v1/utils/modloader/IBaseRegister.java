package ru.koshakmine.icstd.v1.utils.modloader;

import java.util.UUID;

public interface IBaseRegister {
    int getPriority();

    void onPreInit();
    void onInit();
    void factory();

    UUID getUUID();
}
