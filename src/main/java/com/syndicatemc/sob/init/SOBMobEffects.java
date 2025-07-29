package com.syndicatemc.sob.init;

import com.syndicatemc.sob.SOB;
import com.syndicatemc.sob.mob_effect.CessationEffect;
import com.syndicatemc.sob.mob_effect.SOBMobEffectHelp;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraftforge.common.ForgeMod;
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
            .addAttributeModifier(Attributes.MOVEMENT_SPEED, "6b1e4ea9-7ab6-42a6-aa02-da00e2082bc0", 0.3, AttributeModifier.Operation.MULTIPLY_BASE));
    public static final RegistryObject<MobEffect> SPITE = MOB_EFFECTS.register("spite", () -> new SOBMobEffectHelp(MobEffectCategory.BENEFICIAL, 0xA8379E));
    public static final RegistryObject<MobEffect> SPITE_BOOST = MOB_EFFECTS.register("spite_boost", () -> new SOBMobEffectHelp(MobEffectCategory.BENEFICIAL, 0xA8379E));
    public static final RegistryObject<MobEffect> REACH = MOB_EFFECTS.register("reach", () -> new SOBMobEffectHelp(MobEffectCategory.BENEFICIAL, 0x31a15e)
            .addAttributeModifier(ForgeMod.BLOCK_REACH.get(), "9e6901e5-a3cc-446c-94ed-56dd2e3cd70b", 2.0, AttributeModifier.Operation.ADDITION)
            .addAttributeModifier(ForgeMod.ENTITY_REACH.get(), "4c08845b-48ff-4964-9d5c-d94bd90a853f", 1.0, AttributeModifier.Operation.ADDITION));
    public static final RegistryObject<MobEffect> CESSATION = MOB_EFFECTS.register("cessation", CessationEffect::new);
    public static final RegistryObject<MobEffect> EXPOSED = MOB_EFFECTS.register("exposed", () -> new SOBMobEffectHelp(MobEffectCategory.HARMFUL, 0xFE6C0A)
            .addAttributeModifier(Attributes.ARMOR, "f3145073-5b49-4e46-b58f-f9c37cff9ed3", -5.0, AttributeModifier.Operation.ADDITION));
    public static final RegistryObject<MobEffect> TOUGHNESS = MOB_EFFECTS.register("toughness", () -> new SOBMobEffectHelp(MobEffectCategory.BENEFICIAL, 0xBC7841)
            .addAttributeModifier(Attributes.ARMOR, "7b4a9349-0f58-4d94-9dd1-8390a8c9b19c", 4.0, AttributeModifier.Operation.ADDITION)
            .addAttributeModifier(Attributes.ARMOR_TOUGHNESS, "5e7765d7-d87d-46ac-8fcf-bde2846127e5", 1.0, AttributeModifier.Operation.ADDITION));


    public static void init(IEventBus bus) {
        MOB_EFFECTS.register(bus);
    }
}
