package ru.koshakmine.icstd.v1.entity;

import com.zhekasmirnov.apparatus.adapter.innercore.game.entity.StaticEntity;
import com.zhekasmirnov.innercore.api.mod.adaptedscript.AdaptedScriptAPI;
import ru.koshakmine.icstd.v1.utils.type.common.ItemStack;

public class EntityItem extends Entity {
    public EntityItem(long uid) {
        super(uid);
    }

    public ItemStack getDroppedItem(){
        return new ItemStack(StaticEntity.getDroppedItem(uid));
    }

    public void setDroppedItem(ItemStack item){
        AdaptedScriptAPI.Entity.setDroppedItem(uid, item.id, item.count, item.data, item.extra);
    }
}
