package com.syndicatemc.sob.item;

import com.syndicatemc.sob.utility.SOBTranslationKey;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.phys.Vec3;
import umpaz.brewinandchewin.common.item.BoozeItem;
import vectorwing.farmersdelight.common.Configuration;

import javax.annotation.Nullable;
import java.util.List;

public class CreeperDrinkItem extends BoozeItem {
    public CreeperDrinkItem(Fluid fluid, Properties properties) {
        super(fluid, properties);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity consumer) {
        if (!level.isClientSide) {
            level.explode(consumer, consumer.getX(), consumer.getY() + 1, consumer.getZ(), 4, Level.ExplosionInteraction.NONE);
            consumer.addDeltaMovement(new Vec3(0, 1.0, 0));
        }
        return super.finishUsingItem(stack, level, consumer);
    }

    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag isAdvanced) {
        if ((Boolean) Configuration.FOOD_EFFECT_TOOLTIP.get()) {
            tooltip.add(Component.translatable("effect.brewinandchewin.tipsy").withStyle(ChatFormatting.RED)
                            .append(Component.literal(" ").withStyle(ChatFormatting.RED)
                                    .append(Component.translatable("potion.potency.1").withStyle(ChatFormatting.RED)
                                            .append(Component.literal(" (02:00)").withStyle(ChatFormatting.RED)
                                            ))));
            tooltip.add(Component.translatable("effect.brewinandchewin.intoxication").withStyle(ChatFormatting.RED).append(Component.literal(" (01:30)").withStyle(ChatFormatting.RED)));
            tooltip.add(SOBTranslationKey.getTranslation("makes_explosion", "tooltip").withStyle(ChatFormatting.BLUE));
        }
    }
}