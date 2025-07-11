package ru.koshakmine.icstd.v1.block.blockentity;

import com.zhekasmirnov.apparatus.mcpe.NativeBlockSource;
import com.zhekasmirnov.apparatus.multiplayer.util.entity.NetworkEntity;
import com.zhekasmirnov.apparatus.multiplayer.util.entity.SyncedNetworkData;
import com.zhekasmirnov.innercore.api.NativeAPI;
import com.zhekasmirnov.innercore.api.mod.ScriptableObjectHelper;
import org.json.JSONException;
import org.json.JSONObject;
import org.mozilla.javascript.ScriptableObject;
import ru.koshakmine.icstd.v1.block.component.BlockEntityHolderComponent;
import ru.koshakmine.icstd.v1.event.Event;
import ru.koshakmine.icstd.v1.event.Events;
import ru.koshakmine.icstd.v1.level.Level;
import ru.koshakmine.icstd.v1.network.NetworkSide;
import ru.koshakmine.icstd.v1.runtime.PostLevelLoaded;
import ru.koshakmine.icstd.v1.runtime.saver.IRuntimeSaveObject;
import ru.koshakmine.icstd.v1.runtime.saver.Saver;
import ru.koshakmine.icstd.v1.utils.type.common.ItemStack;
import ru.koshakmine.icstd.v1.utils.type.common.Position;
import ru.koshakmine.icstd.v1.entity.player.Player;

import java.util.UUID;

public class BlockEntity extends BlockEntityBase implements IRuntimeSaveObject {
    private static final BlockEntityManager SERVER_MANAGER = new BlockEntityManager(entity -> {
        final NetworkEntity networkEntity = ((BlockEntity) entity).network;
        if (networkEntity != null)
            networkEntity.refreshClients();
    }, NetworkSide.SERVER);
    private static final BlockEntityRegistry<BlockEntityHolderComponent> SERVER_REGISTRY = new BlockEntityRegistry<>();

    public static BlockEntityManager getManager() {
        return SERVER_MANAGER;
    }

    public static BlockEntityRegistry<BlockEntityHolderComponent> getRegistry() {
        return SERVER_REGISTRY;
    }

    static {
        Saver.registerRuntimeSaveObject("block_entity", jsonObject -> {
            PostLevelLoaded.SERVER.run(() -> {
                try {
                    final BlockEntityHolderComponent builder = SERVER_REGISTRY.get(jsonObject.getString("t"));

                    if (builder == null) return;
                    final Level level = Level.getForDimension(jsonObject.getInt("d"));

                    if (level != null) {
                        try {
                            final BlockEntity blockEntity = builder.createBlockEntity(new Position(jsonObject.getJSONObject("p")), level);
                            SERVER_MANAGER.addBlockEntity(blockEntity, (ent -> {
                                try {
                                    blockEntity.onLoad(jsonObject);
                                } catch (JSONException e) {
                                    throw new RuntimeException(e);
                                }
                                return null;
                            }));
                        } catch (JSONException e) {
                        }
                    }
                } catch (JSONException e) {
                }
            });
        });

        Event.onCall(Events.BreakBlock, args -> {
            if (NativeAPI.isDefaultPrevented()) {
                return;
            }

            final Position position = new Position((ScriptableObject) args[1]);

            final BlockEntity entity = (BlockEntity) SERVER_MANAGER.getBlockEntity(position, Level.getForRegion((NativeBlockSource) args[0]));
            if (entity != null) {
                SERVER_MANAGER.removeBlockEntity(entity);
            }
        });
    }

    public final UUID uuid = UUID.randomUUID();
    protected NetworkEntity network;
    protected SyncedNetworkData networkData;
    protected String localType;

    public BlockEntity(String type, String localType, int id, Position position, Level level) {
        super(position, level, type, id);

        this.localType = localType;
    }

    @Override
    public void onInit() {
        if (BlockEntityLocal.getRegistry().get(localType) != null) {
            networkData = new SyncedNetworkData();
            network = new NetworkEntity(BlockEntityLocal.TYPE, this);
            networkData.setClients(network.getClients());
        } else network = null;
    }

    public void onLoad(JSONObject json) throws JSONException {
    }

    public void onSave(JSONObject json) throws JSONException {
    }

    // Minecraft events
    public void onClick(Position position, ItemStack stack, Player player) {
    }


    public NetworkEntity getNetwork() {
        return network;
    }

    public SyncedNetworkData getNetworkData() {
        return networkData;
    }

    public String getLocalType() {
        return localType;
    }

    public JSONObject buildPacketLocal() throws JSONException {
        final JSONObject send = new JSONObject();
        if(networkData != null) {
            send.put("sd", networkData.getName());
            send.put("sj", networkData.toJSON());
        }
        return send;
    }

    public int getHideDistance() {
        return 128;
    }

    @Override
    public final NetworkSide getSide() {
        return NetworkSide.SERVER;
    }

    @Override
    public final UUID getSaveId() {
        return uuid;
    }

    @Override
    public final String getName() {
        return "block_entity";
    }

    @Override
    public final JSONObject save() throws JSONException {
        if (canRemove())
            return null;

        final JSONObject json = new JSONObject();

        json.put("t", type);
        json.put("p", position.toJson());
        json.put("d", level.getDimensionId());

        onSave(json);

        return json;
    }

    @Override
    public final boolean removeBlockEntity() {
        if (super.removeBlockEntity()) {
            if (network != null) {
                network.remove();
            }
            Saver.removeSaver(this);
            return true;
        }
        return false;
    }

    private ScriptableObject fakeTile;

    protected void onBuildFakeTileEntity(ScriptableObject tile){
        fakeTile.put("___fakeTile___", fakeTile, this);
        fakeTile.put("blockSource", fakeTile, level.getRegion());
        fakeTile.put("dimension", fakeTile, dimension);
        fakeTile.put("x", fakeTile, x);
        fakeTile.put("y", fakeTile, y);
        fakeTile.put("z", fakeTile, z);
        fakeTile.put("blockID", fakeTile, id);
    }

    public ScriptableObject getFakeTileEntity() {
        if (fakeTile != null)
            return fakeTile;

        fakeTile = ScriptableObjectHelper.createEmpty();
        onBuildFakeTileEntity(fakeTile);
        return fakeTile;
    }
}