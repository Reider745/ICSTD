package ru.koshakmine.icstd.v1.item.tools;

import ru.koshakmine.icstd.v1.utils.type.tools.BlockMaterials;

public abstract class ItemPickaxe extends ItemTool {
    @Override
    public String[] getBlockMaterials() {
        return new String[] {BlockMaterials.STONE};
    }
}
