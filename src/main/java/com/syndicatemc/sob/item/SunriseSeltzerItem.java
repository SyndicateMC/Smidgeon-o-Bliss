package com.syndicatemc.sob.item;

import com.syndicatemc.sob.utillity.SOBTranslationKey;
import com.teamabnormals.atmospheric.common.entity.OrangeVaporCloud;
import com.teamabnormals.atmospheric.core.registry.AtmosphericEntityTypes;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import umpaz.brewinandchewin.common.item.BoozeItem;

import javax.annotation.Nullable;
import java.util.List;

public class SunriseSeltzerItem extends BoozeItem {
    public SunriseSeltzerItem(Fluid fluid, Properties properties) {
        super(fluid, properties);
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

    @Override
    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
        for (int i = 0; i < tooltip.size(); ++i) {
            Component tt = tooltip.get(i);
            tooltip.set(i, SOBTranslationKey.getTranslation("tooltip", "makes_orange_vapor").withStyle(ChatFormatting.BLUE));
        }
    }
}