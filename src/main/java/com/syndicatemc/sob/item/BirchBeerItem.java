package com.syndicatemc.sob.item;

import com.syndicatemc.sob.init.SOBSounds;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import vectorwing.farmersdelight.common.item.DrinkableItem;
import vectorwing.farmersdelight.common.registry.ModEffects;

public class BirchBeerItem extends DrinkableItem {
    public BirchBeerItem(Properties properties) {
        super(properties);
    }

    public SoundEvent getEatingSound() {
        return SOBSounds.FIZZY_DRINK.get();
    }
    public SoundEvent getDrinkingSound() {
        return SOBSounds.FIZZY_DRINK.get();
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 32;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity consumer) {
        MobEffect[] effects = {
                MobEffects.DAMAGE_RESISTANCE,
                MobEffects.REGENERATION,
                ModEffects.COMFORT.get()
        };
        if (!level.isClientSide) {
            MobEffect effect = effects[(int)Math.floor(Math.random() * 3)];
            consumer.addEffect(new MobEffectInstance(effect, 600, 0, false, true));
        }
        return super.finishUsingItem(stack, level, consumer);
    }
}