package com.syndicatemc.sob.item;

import com.syndicatemc.sob.init.SOBSounds;
import com.syndicatemc.sob.utility.SOBTranslationKey;
import com.teamabnormals.atmospheric.common.entity.OrangeVaporCloud;
import com.teamabnormals.atmospheric.core.registry.AtmosphericEntityTypes;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.Fluid;
import umpaz.brewinandchewin.common.item.BoozeItem;
import vectorwing.farmersdelight.common.Configuration;

import javax.annotation.Nullable;
import java.util.List;

public class SunriseSeltzerItem extends BoozeItem {
    public SunriseSeltzerItem(Fluid fluid, Properties properties) {
        super(fluid, properties);
    }

    public SoundEvent getEatingSound() {
        return SOBSounds.FIZZY_DRINK.get();
    }
    public SoundEvent getDrinkingSound() {
        return SOBSounds.FIZZY_DRINK.get();
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity consumer) {
        if (!level.isClientSide) {
            OrangeVaporCloud cloud = AtmosphericEntityTypes.ORANGE_VAPOR_CLOUD.get().create(level);
            cloud.setPos(consumer.position());
            cloud.setRadius(1.5F);
            cloud.setDuration(600);
            cloud.setRadiusPerTick(-0.0025F);
            level.addFreshEntity(cloud);
        }
        return super.finishUsingItem(stack, level, consumer);
    }

    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag isAdvanced) {
        if ((Boolean) Configuration.FOOD_EFFECT_TOOLTIP.get()) {
            tooltip.add(Component.translatable("effect.brewinandchewin.tipsy").withStyle(ChatFormatting.RED).append(Component.literal(" (01:00)").withStyle(ChatFormatting.RED)));
            tooltip.add(Component.translatable("effect.brewinandchewin.intoxication").withStyle(ChatFormatting.RED).append(Component.literal(" (01:00)").withStyle(ChatFormatting.RED)));
            tooltip.add(Component.translatable("effect.sob.zest").withStyle(ChatFormatting.BLUE).append(Component.literal(" (02:00)").withStyle(ChatFormatting.BLUE)));
            tooltip.add(SOBTranslationKey.getTranslation("makes_orange_vapor", "tooltip").withStyle(ChatFormatting.BLUE));
        }
    }
}