package ru.koshakmine.icstd.v1.item.tools;


import ru.koshakmine.icstd.v1.utils.js.ToolAPI;

public abstract class ItemSword extends ItemTool {
    @Override
    public void onInit() {
        ToolAPI.registerSword(getNumId(), this);
    }
}
