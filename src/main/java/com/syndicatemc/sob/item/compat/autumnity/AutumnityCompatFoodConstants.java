package com.syndicatemc.sob.item.compat.autumnity;


import com.syndicatemc.sob.init.SOBMobEffects;
import com.teamabnormals.autumnity.core.registry.AutumnityMobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.food.FoodProperties;

public class AutumnityCompatFoodConstants { //...bitch
    public static final FoodProperties FOUL_SALAD = (new FoodProperties.Builder())
            .nutrition(3)
            .saturationMod(0.5F)
            .effect(() -> new MobEffectInstance(SOBMobEffects.BITTERNESS.get(), 1800, 0), 1.0F)
            .effect(() -> new MobEffectInstance(AutumnityMobEffects.FOUL_TASTE.get(), 2400, 0), 1.0F)
            .build();
}
