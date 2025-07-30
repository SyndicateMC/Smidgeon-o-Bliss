package com.syndicatemc.sob.init;

import com.syndicatemc.sob.SOB;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SOBPaintings {
    public static final DeferredRegister<PaintingVariant> PAINTING_VARIANTS = DeferredRegister.create(ForgeRegistries.PAINTING_VARIANTS, SOB.MOD_ID);

    public static final RegistryObject<PaintingVariant> BLISS = PAINTING_VARIANTS.register("bliss", () -> new PaintingVariant(32, 32));

    public static void init(IEventBus bus) {
        PAINTING_VARIANTS.register(bus);
    }
}
