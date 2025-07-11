package ru.koshakmine.icstd.v1.runtime.saver;

import com.zhekasmirnov.horizon.runtime.logger.Logger;
import com.zhekasmirnov.innercore.api.log.DialogHelper;
import com.zhekasmirnov.innercore.api.log.ICLog;
import com.zhekasmirnov.innercore.api.runtime.saver.world.WorldDataScopeRegistry;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import ru.koshakmine.icstd.v1.event.Event;
import ru.koshakmine.icstd.v1.event.Events;

import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;

public class Saver {
    private static final HashMap<String, IRead> runtimeTypesSaveObject = new HashMap<>();
    private static final HashMap<UUID, IRuntimeSaveObject> runtimeSaveObject = new HashMap<>();

    static {
        Event.onCall(Events.LevelLeft, (args -> runtimeSaveObject.clear()));

        register(new ISaveObject() {
            @Override
            public String getName() {
                return "runtime_object";
            }

            @Override
            public void read(JSONObject map) {
                final Iterator<String> it = map.keys();
                while (it.hasNext()){
                    try{
                        final JSONArray json = (JSONArray) map.get(it.next());
                        final IRead read = runtimeTypesSaveObject.get(json.getString(0));

                        if(read != null) read.read(json.getJSONObject(1));
                    }catch (Exception e){
                        final String errorText = ICLog.getStackTrace(e);
                        DialogHelper.openFormattedDialog(errorText, "Saver");
                        Logger.error(errorText);
                    }
                }
            }

            @Override
            public JSONObject save(){
                final JSONObject map = new JSONObject();
                runtimeSaveObject.forEach((uuid, saveObject) -> {
                    try {
                        final JSONArray json = new JSONArray();

                        json.put(saveObject.getName());
                        final JSONObject saveObj = saveObject.save();
                        if(saveObj != null){
                            json.put(saveObj);
                            map.put(uuid.toString(), json);
                        }
                    } catch (JSONException e) {
                        final String errorText = ICLog.getStackTrace(e);
                        DialogHelper.openFormattedDialog(errorText, "Saver");
                        Logger.error(errorText);
                    }
                });
                return map;
            }
        });
    }

    public static void register(ISaveObject saveObject){
        WorldDataScopeRegistry.getInstance().addScope("icstd." + saveObject.getName(), new WorldDataScopeRegistry.SaverScope() {
            @Override
            public void readJson(Object o) throws Exception {
                if(o instanceof JSONObject) {
                    try {
                        saveObject.read((JSONObject) o);
                    } catch (JSONException e) {
                        Logger.error(ICLog.getStackTrace(e));
                    }
                }
            }

            @Override
            public Object saveAsJson() throws Exception {
                try {
                    return saveObject.save();
                } catch (JSONException e) {
                    Logger.error(ICLog.getStackTrace(e));
                }
                return new JSONObject();
            }
        });
    }

    public static void registerRuntimeSaveObject(String type, IRead readObject){
        runtimeTypesSaveObject.put(type, readObject);
    }

    public static void addSaver(IRuntimeSaveObject saveObject){
        runtimeSaveObject.put(saveObject.getSaveId(), saveObject);
    }

    public static void removeSaver(IRuntimeSaveObject saveObject){
        runtimeSaveObject.remove(saveObject.getSaveId());
    }
}