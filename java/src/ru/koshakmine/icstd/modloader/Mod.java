package ru.koshakmine.icstd.modloader;

import com.zhekasmirnov.apparatus.modloader.ApparatusMod;
import com.zhekasmirnov.apparatus.modloader.ApparatusModLoader;
import com.zhekasmirnov.apparatus.modloader.LegacyInnerCoreMod;
import com.zhekasmirnov.innercore.utils.FileTools;
import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

public abstract class Mod {
    private final String dir;

    public Mod(String dir){
        this.dir = dir;
    }

    public final String getDir() {
        return dir;
    }

    public abstract void runMod();

    private static final ArrayList<Mod> mods = new ArrayList<>();

    public static void runMods(){
        final List<ApparatusMod> mods = ApparatusModLoader.getSingleton().getAllMods();
        for(final ApparatusMod mod : mods) {
            if (!(mod instanceof LegacyInnerCoreMod)) continue;

            final String path = mod.getInfo().getProperty("directory_root", String.class, null);

            try{
                final JSONArray json = FileTools.readJSONArray(path+"icstd.json");

                for(int i = 0;i < json.length();i++){
                    try{
                        final String classPath = json.getString(i);
                        Class<? extends Mod> clazz = (Class<? extends Mod>) Class.forName(classPath);
                        Mod.mods.add(clazz.getConstructor(String.class).newInstance(path));
                    }catch (Exception ignore){}
                }
            }catch (Exception ignore){}
        }

        for(Mod mod : Mod.mods)
            mod.runMod();
    }
}
