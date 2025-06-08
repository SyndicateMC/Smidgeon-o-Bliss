package com.syndicatemc.sob.item;

import com.soytutta.mynethersdelight.common.registry.MNDEffects;
import com.syndicatemc.sob.init.SOBMobEffects;
import com.teamabnormals.autumnity.core.registry.AutumnityMobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import umpaz.brewinandchewin.common.registry.BnCEffects;
import vectorwing.farmersdelight.common.registry.ModEffects;

public class FoodConstants {
    /* bowl-less food items */
    public static final FoodProperties GILDED_POTATO = (new FoodProperties.Builder())
            .nutrition(2)
            .saturationMod(0.75F)
            .effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 200, 2), 1.0F)
            .build();
    public static final FoodProperties DRIPLEAVES = (new FoodProperties.Builder())
            .nutrition(1)
            .saturationMod(0.75F)
            .fast()
            .effect(() -> new MobEffectInstance(SOBMobEffects.BITTERNESS.get(), 200, 0), 1.0F)
            .build();
    public static final FoodProperties NOPAL = (new FoodProperties.Builder())
            .nutrition(2)
            .saturationMod(0.65F)
            .build();
    public static final FoodProperties PRICKLY_PEAR = (new FoodProperties.Builder())
            .nutrition(4)
            .saturationMod(0.5F)
            .build();
    public static final FoodProperties SCULK_TENDRIL = (new FoodProperties.Builder())
            .nutrition(2)
            .saturationMod(0.5F)
            .fast()
            .effect(() -> new MobEffectInstance(SOBMobEffects.RESONANCE.get(), 100, 0), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 100, 0), 1.0F)
            .build();
    public static final FoodProperties SCULK_ROLL = (new FoodProperties.Builder())
            .nutrition(6)
            .saturationMod(0.75F)
            .effect(() -> new MobEffectInstance(SOBMobEffects.RESONANCE.get(), 600, 0), 1.0F)
            .build();
    //req: create
    public static final FoodProperties CINDER_BREAD = (new FoodProperties.Builder())
            .nutrition(4)
            .saturationMod(0.75F)
            .effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 200, 0), 1.0F)
            .build();
    //req: ENVI & UA
    public static final FoodProperties DUCK_SANDWICH = (new FoodProperties.Builder())
            .nutrition(11)
            .saturationMod(0.75F)
            .effect(() -> new MobEffectInstance(MobEffects.WATER_BREATHING, 400, 0), 1.0F)
            .build();
    //req: frycooks & autumnity
    public static final FoodProperties MAPLE_DONUT = (new FoodProperties.Builder())
            .nutrition(9)
            .saturationMod(0.3F)
            .effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), 200, 0), 1.0F)
            .build();

    /* bowl food items */
    public static final FoodProperties GRAVY = (new FoodProperties.Builder())
            .nutrition(2)
            .saturationMod(0.65F)
            .build();
    public static final FoodProperties INK_SOUP = (new FoodProperties.Builder())
            .nutrition(8)
            .saturationMod(0.55F)
            .effect(() -> new MobEffectInstance(SOBMobEffects.RESONANCE.get(), 2400, 0), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 200, 0), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.BLINDNESS, 100, 0), 1.0F)
            .build();
    //req: ENVI
    public static final FoodProperties TRUFFLE_PASTA = (new FoodProperties.Builder())
            .nutrition(16)
            .saturationMod(0.75F)
            .effect(() -> new MobEffectInstance(MobEffects.HEALTH_BOOST, 2400, 1), 1.0F)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 2400, 0), 1.0F)
            .build();
    //req: ENVI
    public static final FoodProperties EXQUISITE_MUSHROOM_SOUP = (new FoodProperties.Builder())
            .nutrition(14)
            .saturationMod(0.75F)
            .effect(() -> new MobEffectInstance(MobEffects.HEALTH_BOOST, 1200, 1), 1.0F)
            .effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), 2400, 0), 1.0F)
            .build();
    //req: autumnity
    public static final FoodProperties FOUL_SALAD = (new FoodProperties.Builder())
            .nutrition(3)
            .saturationMod(0.5F)
            .effect(() -> new MobEffectInstance(SOBMobEffects.BITTERNESS.get(), 1800, 0), 1.0F)
            .effect(() -> new MobEffectInstance(AutumnityMobEffects.FOUL_TASTE.get(), 2400, 0), 1.0F)
            .build();
    //req: ATMO
    public static final FoodProperties SUGAR_CHICKEN = (new FoodProperties.Builder())
            .nutrition(10)
            .saturationMod(0.75F)
            .effect(() -> new MobEffectInstance(SOBMobEffects.ZEST.get(), 1800, 0), 1.0F)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 1800, 0), 1.0F)
            .build();
    //req: Bac & frycooks
    public static final FoodProperties POUTINE = (new FoodProperties.Builder())
            .nutrition(13)
            .saturationMod(0.8F)
            .effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 1200, 1), 1.0F)
            .effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), 4800, 0), 1.0F)
            .build();
    //req: MND
    public static final FoodProperties HONEY_BARBECUE_STICK = (new FoodProperties.Builder())
            .nutrition(8)
            .saturationMod(0.85F)
            .effect(() -> new MobEffectInstance(MNDEffects.BPUNGENT.get(), 200, 0), 1.0F)
            .build();

    /* drink food items */
    public static final FoodProperties BIRCH_BEER = (new FoodProperties.Builder())
            .alwaysEat()
            .build();
    public static final FoodProperties GLITTERING_GLOOP = (new FoodProperties.Builder())
            .effect(() -> new MobEffectInstance(SOBMobEffects.RESONANCE.get(), 1800, 0), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.GLOWING, 1800, 0), 1.0F)
            .alwaysEat()
            .build();
    //req: FR
    public static final FoodProperties BITTER_TEA = (new FoodProperties.Builder())
            .effect(() -> new MobEffectInstance(SOBMobEffects.BITTERNESS.get(), 1200, 0), 1.0F)
            .alwaysEat()
            .build();
    //req: ATMO
    public static final FoodProperties ORANGE_JUICE = (new FoodProperties.Builder())
            .fast()
            .alwaysEat()
            .build();
    //req: ATMO
    public static final FoodProperties ALOE_TEA = (new FoodProperties.Builder())
            .fast()
            .alwaysEat()
            .build();

    /* booze food items */ //obv req: BnC
    public static final FoodProperties HARD_CIDER = (new FoodProperties.Builder())
            .effect(() -> new MobEffectInstance(BnCEffects.TIPSY.get(), 2400, 0), 1.0F)
            .effect(() -> new MobEffectInstance(BnCEffects.INTOXICATION.get(), 2400, 0), 1.0F)
            .effect(() -> new MobEffectInstance(SOBMobEffects.BITTERNESS.get(), 2400, 0), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 600, 1), 1.0F)
            .alwaysEat()
            .build();
    //req: ATMO
    public static final FoodProperties TEQUILA = (new FoodProperties.Builder())
            .effect(() -> new MobEffectInstance(BnCEffects.TIPSY.get(), 3600, 0), 1.0F)
            .effect(() -> new MobEffectInstance(BnCEffects.INTOXICATION.get(), 2400, 0), 1.0F)
            .alwaysEat()
            .build();
    //req: ATMO
    public static final FoodProperties SUNRISE_SELTZER = (new FoodProperties.Builder())
            .effect(() -> new MobEffectInstance(BnCEffects.TIPSY.get(), 1200, 0), 1.0F)
            .effect(() -> new MobEffectInstance(BnCEffects.INTOXICATION.get(), 1200, 0), 1.0F)
            .effect(() -> new MobEffectInstance(SOBMobEffects.ZEST.get(), 2400, 0), 1.0F)
            .alwaysEat()
            .build();
    //req: SaR
    public static final FoodProperties CREEPER_DRINK = (new FoodProperties.Builder())
            .effect(() -> new MobEffectInstance(BnCEffects.TIPSY.get(), 2400, 1), 1.0F)
            .effect(() -> new MobEffectInstance(BnCEffects.INTOXICATION.get(), 1800, 0), 1.0F)
            .alwaysEat()
            .build();

    /* feast food items */
    //req: MD & BB
    public static final FoodProperties SILVERFISH_TOAST = (new FoodProperties.Builder())
            .nutrition(7)
            .saturationMod(0.65F)
            .effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 100, 0), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 200, 0), 1.0F)
            .build();
    //req: autumnity & ENVI
    public static final FoodProperties ROAST_TURKEY = (new FoodProperties.Builder())
            .nutrition(15)
            .saturationMod(0.75F)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 7200, 0), 1.0F)
            .build();
}
