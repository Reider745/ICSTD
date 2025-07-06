package ru.koshakmine.icstd.v1.recipes.workbench;

import com.zhekasmirnov.innercore.api.commontypes.ItemInstance;
import com.zhekasmirnov.innercore.api.mod.recipes.workbench.WorkbenchField;
import com.zhekasmirnov.innercore.api.mod.recipes.workbench.WorkbenchRecipe;
import com.zhekasmirnov.innercore.api.mod.recipes.workbench.WorkbenchShapelessRecipe;
import ru.koshakmine.icstd.v1.utils.type.common.ItemStack;

public class ShapelessRecipe extends WorkbenchRecipeBase{
    public ShapelessRecipe(ItemCraft item) {
        super(item);
    }

    @Override
    protected WorkbenchRecipe buildRecipe(ItemStack item) {
        return new WorkbenchShapelessRecipe(item.id, item.count, item.data, item.extra){
            @Override
            public ItemInstance provideRecipeForPlayer(WorkbenchField field, long player) {
                return ShapelessRecipe.this.provideRecipeForPlayer(getResult(), field, player);
            }
        };
    }
}
