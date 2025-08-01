package com.syndicatemc.sob.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.level.Level;
import com.syndicatemc.sob.SOB;

public class SOBDamageTypes {
    public static final ResourceKey<DamageType> COLLAPSING = ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation(SOB.MOD_ID, "collapsing"));
    public static final ResourceKey<DamageType> NOPAL_PRICK = ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation(SOB.MOD_ID, "nopal_prick"));
    public static final ResourceKey<DamageType> CEASING = ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation(SOB.MOD_ID, "ceasing"));

    public static DamageSource getSimpleDamageSource(Level level, ResourceKey<DamageType> type) {
        return new DamageSource(level.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(type));
    }
}
