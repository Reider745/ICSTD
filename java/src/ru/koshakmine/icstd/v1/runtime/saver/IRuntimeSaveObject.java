package ru.koshakmine.icstd.v1.runtime.saver;

import java.util.UUID;

public interface IRuntimeSaveObject extends ISave {
    String getName();
    UUID getSaveId();
}
