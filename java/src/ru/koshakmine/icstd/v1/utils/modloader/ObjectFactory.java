package ru.koshakmine.icstd.v1.utils.modloader;

import com.zhekasmirnov.horizon.runtime.logger.Logger;
import com.zhekasmirnov.innercore.api.log.DialogHelper;
import com.zhekasmirnov.innercore.api.log.ICLog;
import ru.koshakmine.icstd.v1.block.Block;
import ru.koshakmine.icstd.v1.item.Item;
import ru.koshakmine.icstd.v1.item.ItemGroup;
import ru.koshakmine.icstd.v1.level.biome.CustomBiome;
import ru.koshakmine.icstd.v1.level.dimensions.CustomDimension;
import ru.koshakmine.icstd.v1.level.particle.Particle;
import ru.koshakmine.icstd.v1.recipes.workbench.WorkbenchRecipeBase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class ObjectFactory {
    public interface IFactory<T extends IBaseRegister> {
        T factory();
    }

    private final ArrayList<IBaseRegister> list = new ArrayList<>();
    private final HashMap<UUID, IBaseRegister> register = new HashMap<>();

    private boolean postFactory = false;

    public Block addBlock(IFactory<Block> factory){
        return add(factory);
    }

    public Item addItem(IFactory<Item> factory){
        return add(factory);
    }

    public Particle addParticle(IFactory<Particle> factory){
        return add(factory);
    }

    public WorkbenchRecipeBase addRecipe(IFactory<WorkbenchRecipeBase> factory){
        return add(factory);
    }

    public ItemGroup addItemGroup(IFactory<ItemGroup> factory){
        return add(factory);
    }

    public CustomBiome addBiome(IFactory<CustomBiome> factory){
        return add(factory);
    }

    public CustomDimension addDimension(IFactory<CustomDimension> factory) {
        return add(factory);
    }

    public <T extends IBaseRegister>T add(IFactory<T> factory){
        return add(factory.factory());
    }

    public <T extends IBaseRegister>T add(T base){
        if(postFactory){
            base.onPreInit();
            base.factory();
            base.onInit();
            return base;
        }

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getPriority() < base.getPriority()) {
                list.add(i, base);
                register.put(base.getUUID(), base);

                return base;
            }
        }

        list.add(base);
        register.put(base.getUUID(), base);

        return base;
    }

    public IBaseRegister get(UUID id){
        return register.get(id);
    }

    public void build(){
        postFactory = true;

        for (IBaseRegister base : list) {
            try{
                base.onPreInit();
                base.factory();
                base.onInit();
            }catch (Exception e){
                final String errorText = ICLog.getStackTrace(e);
                DialogHelper.openFormattedDialog(errorText, "ObjectFactory");
                Logger.error(errorText);
            }

        }
    }
}
