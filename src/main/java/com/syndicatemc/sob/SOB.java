package com.syndicatemc.sob;

import com.mojang.logging.LogUtils;
import com.syndicatemc.sob.init.SOBRegistry;
import net.minecraftforge.fml.common.Mod;
import org.slf4j.Logger;

@Mod(SOB.MOD_ID)
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class SOB {
    public static final String MOD_ID = "sob";
    public static final Logger LOGGER = LogUtils.getLogger();

    public SOB() {
        SOBRegistry.init();
    }
}
