package ru.koshakmine.icstd.v1.level.particle;

import ru.koshakmine.icstd.v1.level.Level;
import ru.koshakmine.icstd.v1.network.packets.NetworkPacket;
import ru.koshakmine.icstd.v1.utils.type.common.Position;

public class ParticleGroupCache extends AbstractParticleGroup<ParticleGroupCache> {
    public Position position;

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public void encode(NetworkPacket packet) {
        packet.putShort((short) particles.size());
        for(AbstractParticleGroup.ParticleData data : particles){
            packet.putPosition(data.position.add(position));
            packet.putPosition(data.vector);
            packet.putString(data.particle.getId());
        }
    }

    public void send(Level level, Position position){
        this.position = position;
        super.spawn(level);
        this.position = null;
    }
}
