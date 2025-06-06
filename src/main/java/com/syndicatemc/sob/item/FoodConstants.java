package com.syndicatemc.sob.item;

import com.syndicatemc.sob.init.SOBMobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class FoodConstants {
    public static final FoodProperties GILDED_POTATO = (new FoodProperties.Builder())
            .nutrition(2)
            .saturationMod(0.75F)
            .effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 200, 2), 1.0F)
            .build();

    public static final FoodProperties DRIPLEAVES = (new FoodProperties.Builder())
            .nutrition(1)
            .saturationMod(0.75F)
            .fast()
            .effect(() -> new MobEffectInstance(SOBMobEffects.BITTERNESS.get(), 200, 0), 1.0F)
            .build();
}
