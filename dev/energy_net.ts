IMPORT("EnergyNet");

WRAP_JAVA("ru.koshakmine.icstd.v1.utils.js.EnergyNetLib")
    .init({
        assureEnergyType(type, value){
            return EnergyTypeRegistry.assureEnergyType(String(type), Number(value));
        }
    });