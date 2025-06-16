package com.syndicatemc.sob.init;

import net.minecraftforge.eventbus.api.IEventBus;

public class SOBRegistries {
    public static void init(IEventBus bus) {
        SOBItems.init(bus);
        SOBBlocks.init(bus);
        SOBFluids.init(bus);
        SOBMobEffects.init(bus);
        SOBSounds.init(bus);
        SOBCreativeTabs.init(bus);
    }
}
