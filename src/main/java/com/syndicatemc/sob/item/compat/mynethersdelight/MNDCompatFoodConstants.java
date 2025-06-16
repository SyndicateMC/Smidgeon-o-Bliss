package com.syndicatemc.sob.item.compat.mynethersdelight;


import com.soytutta.mynethersdelight.common.registry.MNDEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.food.FoodProperties;

public class MNDCompatFoodConstants {
    public static final FoodProperties HONEY_BARBECUE_STICK = (new FoodProperties.Builder())
            .nutrition(8)
            .saturationMod(0.85F)
            .effect(() -> new MobEffectInstance(MNDEffects.BPUNGENT.get(), 200, 0), 1.0F)
            .build();
}
