package ru.koshakmine.icstd.v1.block.blockentity;

import ru.koshakmine.icstd.v1.utils.js.EnergyNetLib;

public interface EnergyTileComponent {
    void energyTick(String type, EnergyNetLib.EnergyTileNode node);
    float energyReceive(String type, float amount, int voltage);
    boolean isConductor(String type);
    boolean canReceiveEnergy(int side, String type);
    boolean canExtractEnergy(int side, String type);
}
