package com.syndicatemc.sob.init;

import com.syndicatemc.sob.SOB;
import com.syndicatemc.sob.mob_effect.SOBMobEffectHelp;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class SOBMobEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS = DeferredRegister.create(Registries.MOB_EFFECT, SOB.MOD_ID);

    public static final RegistryObject<MobEffect> BITTERNESS = MOB_EFFECTS.register("bitterness", () -> new SOBMobEffectHelp(MobEffectCategory.BENEFICIAL, 0x74A417));
    public static final RegistryObject<MobEffect> RESONANCE = MOB_EFFECTS.register("resonance", () -> new SOBMobEffectHelp(MobEffectCategory.BENEFICIAL, 0x034150));
    public static final RegistryObject<MobEffect> COLLAPSE = MOB_EFFECTS.register("collapse", () -> new SOBMobEffectHelp(MobEffectCategory.HARMFUL, 0x052A32));
    public static final RegistryObject<MobEffect> ZEST = MOB_EFFECTS.register("zest", () -> new SOBMobEffectHelp(MobEffectCategory.BENEFICIAL, 0xFFBE28)
            .addAttributeModifier(Attributes.MOVEMENT_SPEED, "f08011c9-6a36-40b2-95c2-00da43ac7077", 0.10, AttributeModifier.Operation.MULTIPLY_BASE));
    public static final RegistryObject<MobEffect> ZEST_BOOST = MOB_EFFECTS.register("zest_boost", () -> new SOBMobEffectHelp(MobEffectCategory.BENEFICIAL, 0xFFBE28)
            .addAttributeModifier(Attributes.MOVEMENT_SPEED, "6b1e4ea9-7ab6-42a6-aa02-da00e2082bc0", 0.20, AttributeModifier.Operation.MULTIPLY_BASE));

    public static void init(IEventBus bus) {
        MOB_EFFECTS.register(bus);
    }
}
