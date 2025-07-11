package ru.koshakmine.icstd.v1.network.packets;

import ru.koshakmine.icstd.v1.network.NetworkClient;
import ru.koshakmine.icstd.v1.utils.type.common.Position;

import java.nio.ByteBuffer;
import java.util.ArrayList;

public abstract class NetworkPacket {
    private ByteBuffer buffer;

    private final ArrayList<Object> list = new ArrayList<>();
    private int length = 0;
    private boolean cacheBuildPacket = true;
    private byte[] cahce = null;

    public void setBuffer(ByteBuffer buffer){
        this.buffer = buffer;
    }

    // Primitives

    public boolean getBoolean(){
        return getByte() == 1;
    }

    public NetworkPacket putBoolean(boolean value){
        putByte(value ? (byte) 1 : (byte) 0);

        return this;
    }

    public byte getByte(){
        return buffer.get();
    }

    public NetworkPacket putByte(byte x){
        list.add(x);
        length += 1;

        return this;
    }

    public short getShort(){
        return buffer.getShort();
    }

    public NetworkPacket putShort(short x){
        list.add(x);
        length += 2;

        return this;
    }

    public int getInt(){
        return buffer.getInt();
    }

    public NetworkPacket putInt(int x){
        list.add(x);
        length += 4;

        return this;
    }

    public long getLong(){
        return buffer.getLong();
    }

    public NetworkPacket putLong(long x){
        list.add(x);
        length += 8;

        return this;
    }

    public float getFloat(){
        return buffer.getFloat();
    }

    public NetworkPacket putFloat(float x){
        list.add(x);
        length += 4;

        return this;
    }

    public double getDouble(){
        return buffer.getDouble();
    }

    public NetworkPacket putDouble(double x){
        list.add(x);
        length += 8;

        return this;
    }

    public byte[] get(){
        final byte[] bytes = new byte[buffer.getInt()];
        for (int i = 0;i < bytes.length;i++)
            bytes[i] = buffer.get();
        return bytes;
    }

    public NetworkPacket put(byte[] bytes){
        list.add(bytes.length);
        list.add(bytes);
        length += bytes.length + 4;

        return this;
    }


    // Non-primitives

    public Position getPosition(){
        return new Position(getFloat(), getFloat(), getFloat());
    }

    public NetworkPacket putPosition(Position position){
        putFloat(position.x);
        putFloat(position.y);
        putFloat(position.z);
        return this;
    }

    public String getString(){
        return new String(get());
    }

    public NetworkPacket putString(String str){
        put(str.getBytes());
        return this;
    }

    private ByteBuffer build(){
        list.clear();

        encode();

        final ByteBuffer buffer = ByteBuffer.wrap(new byte[length]);

        for (Object value : list) {
            if(value instanceof Number) {
                final Number value_ = (Number) value;

                if (value instanceof Byte) buffer.put(value_.byteValue());
                if (value instanceof Short) buffer.putShort(value_.shortValue());
                if (value instanceof Integer) buffer.putInt(value_.intValue());
                if (value instanceof Float) buffer.putFloat(value_.floatValue());
                if (value instanceof Long) buffer.putLong(value_.longValue());
                if (value instanceof Double) buffer.putDouble(value_.doubleValue());
            }

            if(value instanceof byte[]) buffer.put((byte[]) value);
        }

        return buffer;
    }

    public void setCacheBuildPacket(boolean cacheBuildPacket) {
        this.cacheBuildPacket = cacheBuildPacket;
    }

    public byte[] buildPacket(){
        if(cacheBuildPacket && cahce != null)
            return cahce;
        cahce = build().array();
        return cahce;
    }

    public abstract String getName();
    public abstract void decode(NetworkClient client);
    public abstract void encode();
}
