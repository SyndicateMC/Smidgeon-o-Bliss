package com.syndicatemc.sob.mob_effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

public class SOBMobEffectHelp extends MobEffect {
    public SOBMobEffectHelp(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
    }

    @Override
    public boolean isBeneficial() {
        return true;
    }
}
