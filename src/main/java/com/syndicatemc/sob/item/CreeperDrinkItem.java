package com.syndicatemc.sob.item;

import com.syndicatemc.sob.utillity.SOBTranslationKey;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import umpaz.brewinandchewin.common.item.BoozeItem;

import javax.annotation.Nullable;
import java.util.List;

public class CreeperDrinkItem extends BoozeItem {
    public CreeperDrinkItem(Fluid fluid, Properties properties) {
        super(fluid, properties);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity consumer) {
        if (!level.isClientSide) {
            level.explode(consumer, consumer.getX(), consumer.getY(), consumer.getZ(), 4, Level.ExplosionInteraction.NONE);
            consumer.addDeltaMovement(new Vec3(0, 1.0, 0));
        }
        return super.finishUsingItem(stack, level, consumer);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
        for (int i = 0; i < tooltip.size(); ++i) {
            Component tt = tooltip.get(i);
            tooltip.set(i, SOBTranslationKey.getTranslation("tooltip", "makes_explosion").withStyle(ChatFormatting.BLUE));
        }
    }
}