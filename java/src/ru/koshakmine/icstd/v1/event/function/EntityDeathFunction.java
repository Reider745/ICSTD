package ru.koshakmine.icstd.v1.event.function;

import ru.koshakmine.icstd.v1.entity.Entity;

public interface EntityDeathFunction {
    void call(Entity entity, Entity attacker, int damageType);
}
