package com.syndicatemc.sob.utility;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import com.syndicatemc.sob.SOB;

public class SOBTranslationKey {
    public static MutableComponent getTranslation(String key, String type, Object... args) {
        return Component.translatable(type + "." + SOB.MOD_ID + "." + key, args);
    }
}
