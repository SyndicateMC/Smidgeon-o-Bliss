package com.syndicatemc.sob.init;

import com.syndicatemc.sob.SOB;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SOBParticles {
    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, SOB.MOD_ID);

    public static final RegistryObject<SimpleParticleType> ICHOR_EXPLODE = PARTICLE_TYPES.register("ichor_explode",
            () -> new SimpleParticleType(true));

    public static void init(IEventBus bus) {
        PARTICLE_TYPES.register(bus);
    }
}
