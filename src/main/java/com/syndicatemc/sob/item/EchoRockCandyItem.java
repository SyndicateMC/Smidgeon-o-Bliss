package com.syndicatemc.sob.item;

import com.syndicatemc.sob.init.SOBSounds;
import com.syndicatemc.sob.utility.SOBTranslationKey;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import vectorwing.farmersdelight.common.Configuration;
import vectorwing.farmersdelight.common.item.ConsumableItem;

import javax.annotation.Nullable;
import java.util.List;

public class EchoRockCandyItem extends ConsumableItem {
    public EchoRockCandyItem(Item.Properties properties) {
        super(properties);
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 64;
    }
    public SoundEvent getEatingSound() {
        return SOBSounds.CRUNCHY_EAT.get();
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity consumer) {
        if (!level.isClientSide && consumer instanceof ServerPlayer player && player.getLastDeathLocation().isPresent()) {
            BlockPos deathPos = player.getLastDeathLocation().get().pos();
            ServerLevel deathDim = player.server.getLevel(player.getLastDeathLocation().get().dimension());

            if (deathDim != null) {
                level.playSeededSound(null, player.getX(), player.getY() + 1, player.getZ(), SOBSounds.ECHO_TELEPORT.get(), SoundSource.PLAYERS, 1.0F, 1.0F, 1);
                player.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 22, 0, false, false));
                player.teleportTo(deathDim, deathPos.getX(), deathPos.getY(), deathPos.getZ(), player.getYRot(), player.getXRot());
                deathDim.playSeededSound(null, deathPos.getX(), deathPos.getY() + 1, deathPos.getZ(), SOBSounds.ECHO_TELEPORT.get(), SoundSource.PLAYERS, 1.0F, 1.0F, 1);
            }
        }
        return super.finishUsingItem(stack, level, consumer);
    }

    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag isAdvanced) {
        if ((Boolean) Configuration.FOOD_EFFECT_TOOLTIP.get()) {
            tooltip.add(SOBTranslationKey.getTranslation("tp_to_death", "tooltip").withStyle(ChatFormatting.BLUE));
        }
    }
}
