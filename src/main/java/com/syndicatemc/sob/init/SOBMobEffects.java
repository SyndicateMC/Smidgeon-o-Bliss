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
    public static final RegistryObject<MobEffect> ZEST = MOB_EFFECTS.register("zest", () -> new SOBMobEffectHelp(MobEffectCategory.BENEFICIAL, 0xFFBE28));
    public static final RegistryObject<MobEffect> ZEST_BOOST = MOB_EFFECTS.register("zest_boost", () -> new SOBMobEffectHelp(MobEffectCategory.BENEFICIAL, 0xFFBE28)
            .addAttributeModifier(Attributes.MOVEMENT_SPEED, "6b1e4ea9-7ab6-42a6-aa02-da00e2082bc0", 0.30, AttributeModifier.Operation.MULTIPLY_BASE));
    public static final RegistryObject<MobEffect> SPITE = MOB_EFFECTS.register("spite", () -> new SOBMobEffectHelp(MobEffectCategory.BENEFICIAL, 0xA8379E));
    public static final RegistryObject<MobEffect> SPITE_BOOST = MOB_EFFECTS.register("spite_boost", () -> new SOBMobEffectHelp(MobEffectCategory.BENEFICIAL, 0xA8379E)
            .addAttributeModifier(Attributes.ATTACK_DAMAGE, "301f64d2-7bcf-4603-aac1-4c50b4e5fb58", 1, AttributeModifier.Operation.ADDITION));

    public static void init(IEventBus bus) {
        MOB_EFFECTS.register(bus);
    }
}
