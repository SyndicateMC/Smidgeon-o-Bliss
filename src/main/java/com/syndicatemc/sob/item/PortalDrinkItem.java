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

public class PortalDrinkItem extends BoozeItem {
    public PortalDrinkItem(Fluid fluid, Properties properties) {
        super(fluid, properties);
    }

    public boolean isFoil(ItemStack stack) {
        return true;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity consumer) {
        if (!level.isClientSide && consumer instanceof ServerPlayer player) {
            BlockPos spawnPos = player.getRespawnPosition();
            ServerLevel spawnDim = player.server.getLevel(player.getRespawnDimension());

            if (spawnPos != null && spawnDim != null) {
                level.playSeededSound(null, player.getX(), player.getY() + 1, player.getZ(), SoundEvents.ENDERMAN_TELEPORT, SoundSource.PLAYERS, 1.0F, 1.0F, 1);
                for (ServerPlayer playersWithin : player.level().getEntitiesOfClass(ServerPlayer.class, player.getBoundingBox().inflate(5.0D, 5.0D, 5.0D))) {
                    if (playersWithin != player) playersWithin.teleportTo(spawnDim, spawnPos.getX(), spawnPos.getY(), spawnPos.getZ(), playersWithin.getYRot(), playersWithin.getXRot());
                }
                player.teleportTo(spawnDim, spawnPos.getX(), spawnPos.getY(), spawnPos.getZ(), player.getYRot(), player.getXRot());
                spawnDim.playSeededSound(null, spawnPos.getX(), spawnPos.getY() + 1, spawnPos.getZ(), SoundEvents.ENDERMAN_TELEPORT, SoundSource.PLAYERS, 1.0F, 1.0F, 1);
            }
        }
        return super.finishUsingItem(stack, level, consumer);
    }

    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag isAdvanced) {
        if ((Boolean) Configuration.FOOD_EFFECT_TOOLTIP.get()) {
            tooltip.add(Component.translatable("effect.brewinandchewin.tipsy").withStyle(ChatFormatting.RED)
                    .append(Component.literal(" ").withStyle(ChatFormatting.RED)
                            .append(Component.translatable("potion.potency.1").withStyle(ChatFormatting.RED)
                                    .append(Component.literal(" (03:00)").withStyle(ChatFormatting.RED)
                                    ))));
            tooltip.add(Component.translatable("effect.brewinandchewin.intoxication").withStyle(ChatFormatting.RED).append(Component.literal(" (03:00)").withStyle(ChatFormatting.RED)));
            tooltip.add(SOBTranslationKey.getTranslation("tp_all_to_spawn", "tooltip").withStyle(ChatFormatting.BLUE));
        }
    }
}