package com.syndicatemc.sob;

import com.syndicatemc.sob.init.SOBMobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SOB.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class SOBEvents {
    @SubscribeEvent
    public static void onPlayerAttack(LivingDamageEvent event) {
        Entity entity = event.getSource().getEntity();
        if (entity instanceof Player player && player.hasEffect(SOBMobEffects.BITTERNESS.get())) {
            float hunger = player.getFoodData().getFoodLevel();
            float amp = player.getEffect(SOBMobEffects.BITTERNESS.get()).getAmplifier();
            float bonus = (Math.abs(hunger - 20) / 20) * ((amp + 1) / 2);
            event.setAmount(event.getAmount() * (1 + bonus));
        }
    }
}
