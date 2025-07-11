package ru.koshakmine.icstd.v1.block.liquid;

import com.zhekasmirnov.innercore.api.NativeAPI;
import com.zhekasmirnov.innercore.api.NativeBlock;
import com.zhekasmirnov.innercore.api.unlimited.IDRegistry;
import ru.koshakmine.icstd.v1.block.Block;
import ru.koshakmine.icstd.v1.block.liquid.item.FullBucketItem;
import ru.koshakmine.icstd.v1.entity.player.Player;
import ru.koshakmine.icstd.v1.item.event.ClickableComponent;
import ru.koshakmine.icstd.v1.utils.js.LiquidRegistry;
import ru.koshakmine.icstd.v1.level.Level;
import ru.koshakmine.icstd.v1.utils.type.item.ItemID;
import ru.koshakmine.icstd.v1.utils.type.common.BlockData;
import ru.koshakmine.icstd.v1.utils.type.common.BlockPosition;
import ru.koshakmine.icstd.v1.utils.type.common.ItemStack;
import ru.koshakmine.icstd.v1.utils.type.common.Texture;

public abstract class BlockLiquid extends Block implements ClickableComponent {
    private NativeBlock still;
    private BlockFlowingLiquid flowing;
    private FullBucketItem bucket;

    public abstract String getFlowingTexture();
    public abstract String getStillTexture();

    @Override
    public final String[] getTextures() {
        return new String[]{};
    }

    public Texture getFullBucketItem() {
        return new Texture("missing");
    }

    @Override
    public int getMaterial() {
        return 5;
    }

    @Override
    public int getRenderType() {
        return 4;
    }

    @Override
    public int getRenderLayer() {
        return 2;
    }

    public abstract String[] getTextureUi();

    public int getTickDelay(){
        return 20;
    }

    public boolean isRenewable(){
        return false;
    }

    @Override
    public NativeBlock createBlock() {
        final String stillIdName = getId() + "_still";
        final int stillId = IDRegistry.genBlockID(stillIdName);

        final NativeBlock[] blocks = NativeBlock.createLiquidBlock(
                stillId, stillIdName,
                IDRegistry.genBlockID(getId()), getId(),
                getName(),
                0, getTickDelay(), isRenewable()
        );

        this.still = blocks[0];
        this.flowing = new BlockFlowingLiquid(this, blocks[1]);
        block = blocks[0];

        addVariant(getName(), new String[]{getStillTexture()});

        LiquidRegistry.registerLiquid(getId(), getName(), getTextureUi());
        LiquidRegistry.registerBlock(getId(), stillId, false);
        LiquidRegistry.registerBlock(getId(), flowing.getNumId(), true);

        this.bucket = new FullBucketItem(this);
        LiquidRegistry.registerItem(getId(), ItemID.BUCKET, 0, bucket.getNumId(), 0);

        return blocks[0];
    }

    public BlockFlowingLiquid getFlowing() {
        return flowing;
    }

    @Override
    public void onClick(BlockPosition position, ItemStack item, BlockData block, Player player) {
        if (block.data == 0 && item.id == ItemID.BUCKET && item.data == 0) {
            Level level = player.getLevel();

            NativeAPI.preventDefault();
            level.setBlock(position, 0, 0);
            if (player.isItemSpendingAllowed()) {
                if (item.count == 1) {
                    player.setCarriedItem(new ItemStack(bucket.getNumId(), 1, 0));
                } else {
                    player.addItemToInventory(new ItemStack(bucket.getNumId(), 1, 0), true);
                    player.setCarriedItem(new ItemStack(ItemID.BUCKET, item.count - 1, 0));
                }
            }

            level.playSoundAtEntity(player, "bucket.empty_water", 1, 1);
        }
    }
}
