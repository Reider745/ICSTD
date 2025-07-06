package ru.koshakmine.icstd.v1.event.function;

public interface IChunkLoadingStateChanged {
    void call(int chunkX, int chunkZ, int dimension, int preState, int state, boolean discarded);
}
