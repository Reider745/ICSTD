package ru.koshakmine.icstd.v1.entity.player;

import com.zhekasmirnov.innercore.api.NativeAPI;
import com.zhekasmirnov.innercore.api.runtime.other.NameTranslation;
import ru.koshakmine.icstd.v1.level.Level;

public class LocalPlayer extends Player {
    public LocalPlayer(long uid) {
        super(uid);
    }

    @Override
    public Level getLevel() {
        return Level.getLocalLevel();
    }

    @Override
    public boolean message(String message, String... formats) {
        NativeAPI.clientMessage(String.format(NameTranslation.translate(message), (Object[]) formats));
        return true;
    }
}
