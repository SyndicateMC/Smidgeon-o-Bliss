package com.syndicatemc.sob.mixin;

import com.syndicatemc.sob.item.BigSoupItem;
import com.syndicatemc.sob.item.EchoRockCandyItem;
import com.syndicatemc.sob.item.GildedPotatoItem;
import com.syndicatemc.sob.item.PaleDaiquiriItem;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import vectorwing.farmersdelight.common.registry.ModEffects;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {
    @Inject(method = "eat", at = @At("HEAD"))
    private void sob$eaten(Level level, ItemStack food, CallbackInfoReturnable<ItemStack> cir) {
        LivingEntity entity = (LivingEntity) (Object) this;
        if (level.isClientSide) {
            if (food.getItem() instanceof GildedPotatoItem) {
                for (int i = 0; i < 15; i++) {
                    level.addParticle(ParticleTypes.END_ROD, entity.getX() + Math.random() * 2 - 1, entity.getY() + 1 + Math.random() * 2 - 1, entity.getZ() + Math.random() * 2 - 1, 0.0, 0.0, 0.0);
                }
            }
            if (food.getItem() instanceof PaleDaiquiriItem) {
                for (int i = 0; i < 15; i++) {
                    level.addParticle(ParticleTypes.HEART, entity.getX() + Math.random() * 2 - 1, entity.getY() + 1 + Math.random() * 2 - 1, entity.getZ() + Math.random() * 2 - 1, 0.0, 0.0, 0.0);
                }
            }
            //dunno what's wrong with this
            //if (food.getItem() instanceof EchoRockCandyItem && entity instanceof ServerPlayer player) {
            //    BlockPos deathPos = player.getLastDeathLocation().get().pos();
            //    ServerLevel deathDim = player.server.getLevel(player.getLastDeathLocation().get().dimension());
            //    if (deathDim != null && deathDim.isClientSide) {
            //        level.addParticle(ParticleTypes.SONIC_BOOM, entity.getX(), entity.getY() + 1, entity.getZ(), 0.0, 0.0, 0.0);
            //        deathDim.addParticle(ParticleTypes.SONIC_BOOM, deathPos.getX(), deathPos.getY() + 1, deathPos.getZ(), 0.0, 0.0, 0.0);
            //    }
            //}
        }
        if (food.getItem() instanceof BigSoupItem) {
            if (entity.hasEffect(ModEffects.COMFORT.get())) {
                MobEffectInstance instance = entity.getEffect(ModEffects.COMFORT.get());
                if (instance != null) {
                    int duration = instance.getDuration();
                    entity.addEffect(new MobEffectInstance(ModEffects.COMFORT.get(), duration + 1200, instance.getAmplifier(), instance.isAmbient(), instance.isVisible(), instance.showIcon()));
                }
            }
        }
    }
}
