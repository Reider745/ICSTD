package ru.koshakmine.icstd.v1.block.component;

import com.zhekasmirnov.apparatus.multiplayer.util.entity.NetworkEntity;
import org.json.JSONException;
import org.json.JSONObject;
import ru.koshakmine.icstd.v1.block.blockentity.BlockEntityLocal;
import ru.koshakmine.icstd.v1.utils.type.common.Position;

public interface BlockEntityLocalHolderComponent {


    BlockEntityLocal createLocalBlockEntity(Position position, NetworkEntity entity, JSONObject data) throws JSONException;
}
