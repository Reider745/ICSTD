package ru.koshakmine.icstd.v1.block;

import com.zhekasmirnov.innercore.api.NativeBlockRenderer;
import com.zhekasmirnov.innercore.api.NativeICRender;
import com.zhekasmirnov.innercore.api.NativeRenderMesh;
import ru.koshakmine.icstd.v1.block.component.DropComponent;
import ru.koshakmine.icstd.v1.block.component.NeighbourChangeComponent;
import ru.koshakmine.icstd.v1.item.PlantBaseItem;
import ru.koshakmine.icstd.v1.level.Level;
import ru.koshakmine.icstd.v1.utils.type.block.BlockID;
import ru.koshakmine.icstd.v1.utils.type.block.SoundType;
import ru.koshakmine.icstd.v1.utils.type.common.BlockData;
import ru.koshakmine.icstd.v1.utils.type.common.EnchantData;
import ru.koshakmine.icstd.v1.utils.type.common.ItemStack;
import ru.koshakmine.icstd.v1.utils.type.common.Position;
import ru.koshakmine.icstd.v1.utils.type.tools.BlockMaterials;
import ru.koshakmine.icstd.v1.utils.type.tools.ToolLevel;

public abstract class BlockPlantBase extends Block implements NeighbourChangeComponent, DropComponent {
    protected PlantBaseItem plantItem = null;

    public abstract String getTexture();

    @Override
    public final String[] getTextures() {
        return new String[]{getTexture()};
    }

    @Override
    public float getDestroyTime() {
        return 1/20f;
    }

    @Override
    public String getSoundType() {
        return SoundType.GRASS;
    }

    @Override
    public int getMaterialBase() {
        return BlockID.LEAVES;
    }

    @Override
    public int getToolLevel() {
        return ToolLevel.ARM;
    }

    @Override
    public String getBlockMaterial() {
        return BlockMaterials.PLANT;
    }

    @Override
    public ItemStack[] getDrop(Position position, BlockData block, Level level, int diggingLevel, EnchantData enchant, ItemStack item) {
        if(plantItem != null)
            return new ItemStack[]{plantItem.getStack()};
        return new ItemStack[]{new ItemStack(block.id, block.data)};
    }

    public boolean canPlantStand(int id){
        return id == BlockID.DIRT || id == BlockID.GRASS;
    }

    @Override
    public void onNeighbourChanged(Position position, Position changePosition, BlockData block, Level level) {
        if (position.y - 1 == changePosition.y && !canPlantStand(level.getBlockId(position.add(0, -1, 0)))){
            level.destroyBlock(position);
            if(plantItem != null) level.spawnItem(position.add(.5, .5, .5), plantItem.getStack());
        }
    }

    private static final float[][] PLANT_VERTEX = new float[][]{
            new float[]{0.15f, 0, 0.15f, 1, 1},
            new float[]{0.85f, 0, 0.85f, 0, 1},
            new float[]{0.85f, 1, 0.85f, 0, 0},
            new float[]{0.15f, 0, 0.15f, 1, 1},
            new float[]{0.15f, 1, 0.15f, 1, 0},
            new float[]{0.85f, 1, 0.85f, 0, 0},
            new float[]{0.15f, 0, 0.85f, 1, 1},
            new float[]{0.85f, 0, 0.15f, 0, 1},
            new float[]{0.85f, 1, 0.15f, 0, 0},
            new float[]{0.15f, 0, 0.85f, 1, 1},
            new float[]{0.15f, 1, 0.85f, 1, 0},
            new float[]{0.85f, 1, 0.15f, 0, 0}
    };

    public static NativeICRender.Model getModel(String texture, float x_offset, float z_offset) {
        final NativeRenderMesh mesh = new NativeRenderMesh();
        mesh.setBlockTexture(texture, 0);

        for(int i = 0; i < 12; i++){
            final float[] poly = PLANT_VERTEX[i];
            mesh.addVertex(poly[0] - x_offset, poly[1], poly[2] - z_offset, poly[3], poly[4]);
        }
        for(int i = 11; i >= 0; i--){
            final float[] poly = PLANT_VERTEX[i];
            mesh.addVertex(poly[0] - x_offset, poly[1], poly[2] - z_offset, poly[3], poly[4]);
        }

        final NativeICRender.Model render = new NativeICRender.Model();
        render.addEntry(mesh);
        return render;
    }

    @Override
    public void onInit() {
        final NativeICRender.CollisionShape shape = new NativeICRender.CollisionShape();
        shape.addEntry().addBox(7 / 8f, 1, 7 / 8f, 1 / 8f, 0, 1 / 8f);

        NativeBlockRenderer.setCustomCollisionShape(getNumId(), -1, shape);
        NativeBlockRenderer.setStaticICRender(getNumId(), -1, getModel(getTexture(), 0, 0));
    }

    public BlockPlantBase setPlantItem(PlantBaseItem plantItem) {
        this.plantItem = plantItem;
        return this;
    }
}
