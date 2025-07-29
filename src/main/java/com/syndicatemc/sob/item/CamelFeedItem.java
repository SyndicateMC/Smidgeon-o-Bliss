package com.syndicatemc.sob.item;
import com.syndicatemc.sob.SOB;
import com.syndicatemc.sob.init.SOBItems;
import com.syndicatemc.sob.init.SOBTags;
import com.syndicatemc.sob.utility.SOBTranslationKey;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.camel.Camel;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import vectorwing.farmersdelight.common.Configuration;
import vectorwing.farmersdelight.common.registry.ModParticleTypes;
import vectorwing.farmersdelight.common.utility.MathUtils;
import javax.annotation.Nullable;
import java.util.List;

//this whole thing is a modified Horse Feed item class

public class CamelFeedItem extends Item {
    public CamelFeedItem(Properties properties) {
        super(properties);
    }

    @Mod.EventBusSubscriber(modid = SOB.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
    public static class CamelFeedEvent {
        @SubscribeEvent
        public static void onCamelFeedApplied(PlayerInteractEvent.EntityInteract event) {
            Player player = event.getEntity();
            Entity target = event.getTarget();
            ItemStack heldStack = event.getItemStack();

            if (target instanceof LivingEntity entity && target.getType().is(SOBTags.CAMEL_FEED_USERS)) {
                if (entity.isAlive() && (heldStack.getItem().equals(SOBItems.CAMEL_FEED.get()))) {
                    entity.level().playSound(null, target.blockPosition(), SoundEvents.CAMEL_EAT, SoundSource.PLAYERS, 0.8F, 0.8F);
                    for (int i = 0; i < 5; ++i) {
                        double d0 = MathUtils.RAND.nextGaussian() * 0.02D;
                        double d1 = MathUtils.RAND.nextGaussian() * 0.02D;
                        double d2 = MathUtils.RAND.nextGaussian() * 0.02D;
                        entity.level().addParticle(ModParticleTypes.STAR.get(), entity.getRandomX(1.0D), entity.getRandomY() + 0.5D, entity.getRandomZ(1.0D), d0, d1, d2);
                    }
                    if (!player.isCreative()) {
                        heldStack.shrink(1);
                    }

                    entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 6000, 2, false, true));
                    entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 6000, 0, false, true));

                    event.setCancellationResult(InteractionResult.SUCCESS);
                    event.setCanceled(true);
                }
            }
        }
    }
    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag isAdvanced) {
        if ((Boolean) Configuration.FOOD_EFFECT_TOOLTIP.get()) {
            tooltip.add(SOBTranslationKey.getTranslation("feed_to_camel", "tooltip").withStyle(ChatFormatting.GRAY).append(Component.literal(":")));
            tooltip.add(Component.literal(" ").append(Component.translatable("effect.minecraft.speed").withStyle(ChatFormatting.BLUE).append(Component.literal(" ")).append(Component.translatable("potion.potency.2").withStyle(ChatFormatting.BLUE).append(Component.literal(" (05:00)").withStyle(ChatFormatting.BLUE)))));
            tooltip.add(Component.literal(" ").append(Component.translatable("effect.minecraft.resistance").withStyle(ChatFormatting.BLUE)).append(Component.literal(" (05:00)").withStyle(ChatFormatting.BLUE)));
        }
    }
    @Override
    public InteractionResult interactLivingEntity(ItemStack stack, Player playerIn, LivingEntity target, InteractionHand hand) {
        if (target instanceof Camel camel) {
            if (camel.isAlive()) {
                return InteractionResult.SUCCESS;
            }
        }
        return InteractionResult.PASS;
    }
}