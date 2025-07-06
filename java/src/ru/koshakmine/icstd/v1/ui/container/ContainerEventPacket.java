package ru.koshakmine.icstd.v1.ui.container;

import ru.koshakmine.icstd.v1.network.NetworkClient;
import ru.koshakmine.icstd.v1.network.packets.NetworkPacket;

public class ContainerEventPacket extends NetworkPacket {
    @Override
    public String getName() {
        return "icstd.container_event_packet";
    }

    @Override
    public void decode(NetworkClient client) {}

    @Override
    public void encode() {}
}
