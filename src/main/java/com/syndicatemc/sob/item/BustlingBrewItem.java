package com.syndicatemc.sob.item;

import com.syndicatemc.sob.utility.SOBTranslationKey;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.Fluid;
import umpaz.brewinandchewin.common.item.BoozeItem;
import vectorwing.farmersdelight.common.Configuration;

import javax.annotation.Nullable;
import java.util.List;

public class BustlingBrewItem extends BoozeItem {
    public BustlingBrewItem(Fluid fluid, Properties properties) {
        super(fluid, properties);
    }

    public boolean isFoil(ItemStack stack) {
        return true;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity consumer) {
        if (!level.isClientSide && consumer instanceof ServerPlayer player) {
            player.giveExperiencePoints(50);
            player.level().playSeededSound(null, player.getX(), player.getY() + 1, player.getZ(), SoundEvents.EXPERIENCE_ORB_PICKUP, SoundSource.PLAYERS, 0.5F, 1.0F + ((float)Math.random() * 0.5F), 1);
        }
        return super.finishUsingItem(stack, level, consumer);
    }

    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag isAdvanced) {
        if ((Boolean) Configuration.FOOD_EFFECT_TOOLTIP.get()) {
            tooltip.add(Component.translatable("effect.brewinandchewin.tipsy").withStyle(ChatFormatting.RED)
                    .append(Component.literal(" ").withStyle(ChatFormatting.RED)
                            .append(Component.translatable("potion.potency.1").withStyle(ChatFormatting.RED)
                                    .append(Component.literal(" (03:30)").withStyle(ChatFormatting.RED)
                                    ))));
            tooltip.add(Component.translatable("effect.brewinandchewin.intoxication").withStyle(ChatFormatting.RED).append(Component.literal(" (02:30)").withStyle(ChatFormatting.RED)));
            tooltip.add(Component.translatable("effect.sob.brain_blast").withStyle(ChatFormatting.BLUE).append(Component.literal(" (05:00)").withStyle(ChatFormatting.BLUE)));
            tooltip.add(SOBTranslationKey.getTranslation("gives_exp", "tooltip").withStyle(ChatFormatting.BLUE));
        }
    }
}