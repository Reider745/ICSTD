package ru.koshakmine.icstd.v1.network.packets;

import com.zhekasmirnov.innercore.api.NativeAPI;
import com.zhekasmirnov.innercore.api.runtime.other.NameTranslation;
import ru.koshakmine.icstd.v1.network.NetworkClient;

public class ClientMessagePacket extends NetworkPacket {
    private String message;
    private String[] formats;

    public ClientMessagePacket(String message, String[] formats){
        this.message = message;
        this.formats = formats;
    }

    public ClientMessagePacket(){}

    @Override
    public String getName() {
        return "icstd.client_message";
    }

    @Override
    public void decode(NetworkClient client) {
        final String[] formats = new String[getByte()];
        for(int i = 0;i < formats.length;i++)
            formats[i] = getString();
        NativeAPI.clientMessage(String.format(NameTranslation.translate(getString()), (Object[]) formats));
    }

    @Override
    public void encode() {
        putByte((byte) formats.length);
        for (String format : formats) {
            putString(format);
        }
        putString(message);
    }
}
