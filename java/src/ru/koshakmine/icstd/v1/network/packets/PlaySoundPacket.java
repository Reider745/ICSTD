package ru.koshakmine.icstd.v1.network.packets;

import com.zhekasmirnov.innercore.api.NativeAPI;
import ru.koshakmine.icstd.v1.network.NetworkClient;

public class PlaySoundPacket extends NetworkPacket {
    private float x, y, z, volume, pitch;
    private String name;

    public PlaySoundPacket(){
    }

    public PlaySoundPacket(float x, float y, float z, String name, float volume, float pitch){
        this.x = x;
        this.y = y;
        this.z = z;
        this.name = name;
        this.volume = volume;
        this.pitch = pitch;
    }

    @Override
    public String getName() {
        return "icstd.play_sound";
    }

    @Override
    public void decode(NetworkClient client) {
        NativeAPI.playSound(getString(), getFloat(), getFloat(), getFloat(), getFloat(), getFloat());
    }

    @Override
    public void encode() {
        putString(name);
        putFloat(x);
        putFloat(y);
        putFloat(z);
        putFloat(volume);
        putFloat(pitch);
    }
}
