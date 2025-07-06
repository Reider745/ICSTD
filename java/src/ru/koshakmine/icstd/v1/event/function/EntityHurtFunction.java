package ru.koshakmine.icstd.v1.event.function;

import ru.koshakmine.icstd.v1.entity.Entity;

public interface EntityHurtFunction {
    void call(Entity entity, Entity attacker, int damageType, int damageValue, boolean someBool1, boolean someBool2);
}
