package com.syndicatemc.sob.item;

import com.syndicatemc.sob.utillity.SOBTranslationKey;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import vectorwing.farmersdelight.common.item.DrinkableItem;

import javax.annotation.Nullable;
import java.util.List;

public class AloeTeaItem extends DrinkableItem {
    public AloeTeaItem(Properties properties) {
        super(properties);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity consumer) {
        if (!level.isClientSide && consumer.isOnFire()) {
            consumer.extinguishFire();
            level.playSeededSound(null, consumer.getX(), consumer.getY(), consumer.getZ(), SoundEvents.FIRE_EXTINGUISH, SoundSource.PLAYERS, 1.0F, 1.0F, 1);
        }
        return super.finishUsingItem(stack, level, consumer);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
        for (int i = 0; i < tooltip.size(); ++i) {
            Component tt = tooltip.get(i);
            tooltip.set(i, SOBTranslationKey.getTranslation("tooltip", "extinguishes").withStyle(ChatFormatting.BLUE));
        }
    }
}