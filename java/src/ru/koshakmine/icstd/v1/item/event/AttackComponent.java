package ru.koshakmine.icstd.v1.item.event;

import ru.koshakmine.icstd.v1.entity.Entity;

public interface AttackComponent {
    void onAttack(Entity player, Entity entity);
}
