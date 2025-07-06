package ru.koshakmine.icstd.v1.event.function;

import ru.koshakmine.icstd.v1.level.LevelGeneration;

import java.util.Random;

public interface GenerateChunkFunction {
    void call(int chunkX, int chunkZ, Random random, int dimensionId, long seed, long worldSeed, long dimensionSeed, LevelGeneration level);
}
