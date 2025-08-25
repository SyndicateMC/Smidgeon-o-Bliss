package com.syndicatemc.sob.item.compat.neapolitan;


import com.syndicatemc.sob.init.SOBMobEffects;
import com.teamabnormals.neapolitan.core.registry.NeapolitanMobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.food.FoodProperties;
import vectorwing.farmersdelight.common.registry.ModEffects;

public class NeapolitanCompatFoodConstants {
    public static final FoodProperties PB_CHOCOLATE = (new FoodProperties.Builder())
            .nutrition(6)
            .saturationMod(0.6F)
            .effect(() -> new MobEffectInstance(SOBMobEffects.TOUGHNESS.get(), 1200, 0), 1.0F)
            .effect(() -> new MobEffectInstance(NeapolitanMobEffects.SUGAR_RUSH.get(), 200, 0), 1.0F)
            .build();
    public static final FoodProperties MINT_JELLY = (new FoodProperties.Builder())
            .nutrition(5)
            .saturationMod(0.7F)
            .effect(() -> new MobEffectInstance(NeapolitanMobEffects.BERSERKING.get(), 1000, 0), 1.0F)
            .build();
    public static final FoodProperties BANANA_SUNDAE = (new FoodProperties.Builder())
            .nutrition(9)
            .saturationMod(0.5F)
            .effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), 2400, 0), 1.0F)
            .effect(() -> new MobEffectInstance(SOBMobEffects.TOUGHNESS.get(), 1800, 0), 1.0F)
            .effect(() -> new MobEffectInstance(NeapolitanMobEffects.SUGAR_RUSH.get(), 400, 1), 1.0F)
            .effect(() -> new MobEffectInstance(NeapolitanMobEffects.AGILITY.get(), 400, 0), 1.0F)
            .effect(() -> new MobEffectInstance(NeapolitanMobEffects.VANILLA_SCENT.get(), 200, 0), 1.0F)
            .build();
}
