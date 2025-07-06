package ru.koshakmine.icstd.v1.event.function;

import ru.koshakmine.icstd.v1.entity.EntityProjectile;
import ru.koshakmine.icstd.v1.utils.type.common.ItemStack;
import ru.koshakmine.icstd.v1.utils.type.common.ProjectileHitTarget;

public interface ProjectileHitFunction {
    void call(EntityProjectile projectile, ItemStack item, ProjectileHitTarget target);
}
