package com.syndicatemc.sob.mixin;

import com.syndicatemc.sob.item.GildedPotatoItem;
import com.syndicatemc.sob.item.PaleDaiquiriItem;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {
    @Inject(method = "eat", at = @At("HEAD"))
    private void sob$eaten(Level level, ItemStack food, CallbackInfoReturnable<ItemStack> cir) {
        if (level.isClientSide) {
            if (food.getItem() instanceof GildedPotatoItem) {
                LivingEntity entity = (LivingEntity) (Object) this;
                for (int i = 0; i < 15; i++) {
                    level.addParticle(ParticleTypes.END_ROD, entity.getX() + Math.random() * 2 - 1, entity.getY() + 1 + Math.random() * 2 - 1, entity.getZ() + Math.random() * 2 - 1, 0.0, 0.0, 0.0);
                }
            }
            if (food.getItem() instanceof PaleDaiquiriItem) {
                LivingEntity entity = (LivingEntity) (Object) this;
                for (int i = 0; i < 15; i++) {
                    level.addParticle(ParticleTypes.HEART, entity.getX() + Math.random() * 2 - 1, entity.getY() + 1 + Math.random() * 2 - 1, entity.getZ() + Math.random() * 2 - 1, 0.0, 0.0, 0.0);
                }
            }
        }
    }
}
