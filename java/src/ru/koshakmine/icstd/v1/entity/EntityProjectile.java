package ru.koshakmine.icstd.v1.entity;

import com.zhekasmirnov.innercore.api.NativeAPI;
import ru.koshakmine.icstd.v1.utils.type.common.ItemStack;

public class EntityProjectile extends Entity {
    public EntityProjectile(long uid) {
        super(uid);
    }

    public ItemStack getDroppedItem(){
        return ItemStack.fromPointer(NativeAPI.getItemFromProjectile(uid));
    }
}
