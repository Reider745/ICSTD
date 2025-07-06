package ru.koshakmine.icstd.v1.network.packets;

import com.zhekasmirnov.innercore.api.particles.ParticleRegistry;
import ru.koshakmine.icstd.v1.level.particle.AbstractParticleGroup;
import ru.koshakmine.icstd.v1.level.particle.Particle;
import ru.koshakmine.icstd.v1.network.NetworkClient;
import ru.koshakmine.icstd.v1.runtime.PostLevelLoaded;
import ru.koshakmine.icstd.v1.utils.type.common.Position;

public class SpawnParticleGroupPacket extends NetworkPacket {
    private AbstractParticleGroup<?> particles;

    public SpawnParticleGroupPacket(){}

    public SpawnParticleGroupPacket(AbstractParticleGroup<?> particles){
        this.particles = particles;
    }

    @Override
    public String getName() {
        return "icstd.group_spawn_particle";
    }

    @Override
    public void decode(NetworkClient client) {
        if(PostLevelLoaded.LOCAL.isLevelLoaded()) {
            final short count = getShort();

            for (short i = 0; i < count; i++) {
                final Position position = getPosition();
                final Position vector = getPosition();

                ParticleRegistry.addParticle(
                        Particle.getParticleIdByName(getString()),
                        position.x, position.y, position.z,
                        vector.x, vector.y, vector.z,
                        0
                );
            }
        }
    }

    @Override
    public void encode() {
        particles.encode(this);
    }
}
