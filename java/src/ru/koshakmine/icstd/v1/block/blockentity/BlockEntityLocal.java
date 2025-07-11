package ru.koshakmine.icstd.v1.block.blockentity;


import com.zhekasmirnov.apparatus.multiplayer.util.entity.NetworkEntity;
import com.zhekasmirnov.apparatus.multiplayer.util.entity.NetworkEntityType;
import com.zhekasmirnov.apparatus.multiplayer.util.entity.SyncedNetworkData;
import org.json.JSONException;
import org.json.JSONObject;
import ru.koshakmine.icstd.v1.block.component.BlockEntityLocalHolderComponent;
import ru.koshakmine.icstd.v1.level.Level;
import ru.koshakmine.icstd.v1.network.NetworkSide;
import ru.koshakmine.icstd.v1.utils.type.common.Position;
import ru.koshakmine.icstd.v1.ui.type.IWindow;

public class BlockEntityLocal extends BlockEntityBase {
    protected final NetworkEntity network;
    protected final SyncedNetworkData networkData;

    public BlockEntityLocal(String type, int id, Position position, NetworkEntity network, JSONObject data) throws JSONException {
        super(position, Level.getLocalLevel(), type, id);

        this.network = network;
        this.networkData = SyncedNetworkData.getClientSyncedData(data.getString("sd"));
        networkData.fromJSON(data.getString("sj"));
    }

    @Override
    public NetworkSide getSide() {
        return NetworkSide.LOCAL;
    }

    @Override
    public boolean canDestroyBlockEntity() {
        return canRemove();
    }

    public IWindow getScreenByName(String name){
        return null;
    }

    private static final BlockEntityManager LOCAL_MANAGER = new BlockEntityManager(entity -> {}, NetworkSide.LOCAL);
    private static final BlockEntityRegistry<BlockEntityLocalHolderComponent> LOCAL_REGISTRY = new BlockEntityRegistry<>();
    public static final NetworkEntityType TYPE;

    public static BlockEntityManager getLocalManager() {
        return LOCAL_MANAGER;
    }

    public static BlockEntityRegistry<BlockEntityLocalHolderComponent> getRegistry() {
        return LOCAL_REGISTRY;
    }

    static {
        TYPE = new NetworkEntityType("icstd.block_entity");

        // SERVER SIDE
        TYPE.setClientAddPacketFactory((o, networkEntity, connectedClient) -> {
            final BlockEntity entity = (BlockEntity) o;
            final JSONObject send = new JSONObject();
            try {

                send.put("p", entity.getPosition().toJson());
                send.put("d", entity.buildPacketLocal());
                send.put("t", entity.getType());
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }

            return send;
        });
        TYPE.setClientListSetupListener((list, o, networkEntity) -> {
            final BlockEntity entityLocal = (BlockEntity) o;
            list.setupDistancePolicy(entityLocal.x, entityLocal.y, entityLocal.z, entityLocal.dimension, entityLocal.getHideDistance());
        });

        // CLIENT SIDE
        TYPE.setClientEntityAddedListener((networkEntity, o) -> {
            final JSONObject data = (JSONObject) o;

            try {
                final BlockEntityLocalHolderComponent holder = LOCAL_REGISTRY.get(data.getString("t"));
                if(holder != null){
                    final BlockEntityLocal local = holder.createLocalBlockEntity(new Position(data.getJSONObject("p")), networkEntity, data.getJSONObject("d"));
                    LOCAL_MANAGER.addBlockEntity(local);
                    return local;
                }
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
            return null;
        });
        TYPE.setClientEntityRemovedListener((o, networkEntity, o1) -> {
            ((BlockEntityLocal) o).removeBlockEntity();
        });
    }
}
