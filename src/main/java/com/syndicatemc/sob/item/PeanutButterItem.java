package com.syndicatemc.sob.item;

import com.syndicatemc.sob.SOB;
import com.syndicatemc.sob.init.SOBItems;
import com.syndicatemc.sob.init.SOBMobEffects;
import com.syndicatemc.sob.init.SOBTags;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import vectorwing.farmersdelight.common.item.ConsumableItem;
import vectorwing.farmersdelight.common.registry.ModParticleTypes;
import vectorwing.farmersdelight.common.utility.MathUtils;

//this whole thing is a modified Horse Feed item class

public class PeanutButterItem extends ConsumableItem {
    public PeanutButterItem(Properties properties) {
        super(properties);
    }

    @Mod.EventBusSubscriber(modid = SOB.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
    public static class WolfFeedEvent {
        @SubscribeEvent
        public static void onWolfFeedApplied(PlayerInteractEvent.EntityInteract event) {
            Player player = event.getEntity();
            Entity target = event.getTarget();
            ItemStack heldStack = event.getItemStack();

            if (target instanceof LivingEntity entity && target.getType().is(SOBTags.PEANUT_BUTTER_USERS)) {
                if (entity.isAlive() && (heldStack.getItem().equals(SOBItems.PEANUT_BUTTER.get()))) {
                entity.level().playSound(null, target.blockPosition(), SoundEvents.GENERIC_EAT, SoundSource.PLAYERS, 0.8F, 0.8F);
                    for (int i = 0; i < 5; ++i) {
                        double d0 = MathUtils.RAND.nextGaussian() * 0.02D;
                        double d1 = MathUtils.RAND.nextGaussian() * 0.02D;
                        double d2 = MathUtils.RAND.nextGaussian() * 0.02D;
                        entity.level().addParticle(ModParticleTypes.STAR.get(), entity.getRandomX(1.0D), entity.getRandomY() + 0.5D, entity.getRandomZ(1.0D), d0, d1, d2);
                    }
                    if (!player.isCreative()) {
                        heldStack.shrink(1);
                    }

                    entity.addEffect(new MobEffectInstance(SOBMobEffects.TOUGHNESS.get(), 6000, 2, false, true));

                    event.setCancellationResult(InteractionResult.SUCCESS);
                    event.setCanceled(true);
                }
            }
        }
    }
    @Override
    public InteractionResult interactLivingEntity(ItemStack stack, Player playerIn, LivingEntity target, InteractionHand hand) {
        if (target.isAlive()) {
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.PASS;
    }
}