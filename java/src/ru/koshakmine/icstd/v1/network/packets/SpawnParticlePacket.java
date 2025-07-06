package ru.koshakmine.icstd.v1.network.packets;

import com.zhekasmirnov.innercore.api.particles.ParticleRegistry;
import ru.koshakmine.icstd.v1.level.particle.Particle;
import ru.koshakmine.icstd.v1.network.NetworkClient;
import ru.koshakmine.icstd.v1.runtime.PostLevelLoaded;
import ru.koshakmine.icstd.v1.utils.type.common.Position;

public class SpawnParticlePacket extends NetworkPacket {
    private String type;
    private Position position, vector;
    private int data;

    public SpawnParticlePacket(String type, Position position, Position vector){
        this.type = type;
        this.position = position;
        this.vector = vector;
    }

    public SpawnParticlePacket(){}

    @Override
    public String getName() {
        return "icstd.spawn_particle";
    }

    @Override
    public void decode(NetworkClient client) {
        if(PostLevelLoaded.LOCAL.isLevelLoaded()) {
            position = getPosition();
            vector = getPosition();

            ParticleRegistry.addParticle(
                    Particle.getParticleIdByName(getString()),
                    position.x, position.y, position.z,
                    vector.x, vector.y, vector.z,
                    getInt()
            );
        }
    }

    @Override
    public void encode() {
        putPosition(position);
        putPosition(vector);
        putString(type);
        putInt(data);
    }
}
