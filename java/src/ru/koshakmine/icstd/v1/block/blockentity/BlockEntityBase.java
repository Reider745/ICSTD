package ru.koshakmine.icstd.v1.block.blockentity;

import ru.koshakmine.icstd.v1.level.Level;
import ru.koshakmine.icstd.v1.utils.modloader.Mod;
import ru.koshakmine.icstd.v1.utils.modloader.ObjectFactory;
import ru.koshakmine.icstd.v1.network.NetworkSide;
import ru.koshakmine.icstd.v1.utils.type.common.Position;

public abstract class BlockEntityBase {
    public static final ObjectFactory FACTORY = Mod.getFactory();

    protected final Position position;
    protected final String type;
    public int x, y, z, id, dimension;
    protected final Level level;

    // Not use!
    protected boolean removed = false, fullInit = false;

    public BlockEntityBase(Position position, Level level, String type, int id){
        this.position = position;
        this.level = level;

        this.type = type;
        this.id = id;

        this.x = (int) Math.floor(position.x);
        this.y = (int) Math.floor(position.y);
        this.z = (int) Math.floor(position.z);
        this.dimension = level.getDimensionId();
    }

    // Life events
    public void onInit(){}
    public void onRemove(){}

    // Methods
    public boolean canInitialization() {
        return fullInit;
    }

    public boolean canRemove(){
        return removed;
    }

    public Position getPosition() {
        return position;
    }

    public Level getLevel() {
        return level;
    }

    public int getDimension() {
        return dimension;
    }

    public boolean canDestroyBlockEntity() {
        return (level.isChunkLoadedAt(x, z) && level.getBlockId(x, y, z) != id) || canRemove();
    }

    public String getType() {
        return type;
    }

    public boolean removeBlockEntity(){
        if(!canRemove()) {
            if(canInitialization()) {
                onRemove();
            }

            removed = true;
            return true;
        }

        return false;
    }

    public abstract NetworkSide getSide();
}
