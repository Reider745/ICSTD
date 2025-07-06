package ru.koshakmine.icstd.v1.item.tools;

import ru.koshakmine.icstd.v1.item.Item;
import ru.koshakmine.icstd.v1.utils.js.ToolAPI;

public abstract class ItemTool extends Item implements ToolMaterial{
    public abstract String[] getBlockMaterials();

    @Override
    public int getMaxStack() {
        return 1;
    }

    @Override
    public boolean isToolRender() {
        return true;
    }

    @Override
    public int getToolDamage() {
        return 2;
    }

    @Override
    public void onInit() {
        ToolAPI.registerTool(getNumId(), this, getBlockMaterials());
    }
}
