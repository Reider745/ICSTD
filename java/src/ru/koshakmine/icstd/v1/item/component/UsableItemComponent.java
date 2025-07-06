package ru.koshakmine.icstd.v1.item.component;

import ru.koshakmine.icstd.v1.entity.player.Player;
import ru.koshakmine.icstd.v1.utils.type.item.AnimationType;
import ru.koshakmine.icstd.v1.utils.type.common.ItemStack;

public interface UsableItemComponent {
    AnimationType getType();
    int getUsingDuration();

    void onItemUsingComplete(ItemStack item, Player player);
}
