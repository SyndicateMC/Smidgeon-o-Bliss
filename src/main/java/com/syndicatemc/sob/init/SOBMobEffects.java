package com.syndicatemc.sob.init;

import com.syndicatemc.sob.SOB;
import com.syndicatemc.sob.mob_effect.BitternessEffect;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class SOBMobEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS = DeferredRegister.create(Registries.MOB_EFFECT, SOB.MOD_ID);

    public static final RegistryObject<MobEffect> BITTERNESS = MOB_EFFECTS.register("bitterness", () -> new BitternessEffect(MobEffectCategory.BENEFICIAL, 0x74A417));

    public static void init(IEventBus bus) {
        MOB_EFFECTS.register(bus);
    }
}
