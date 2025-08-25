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
    public static final RegistryObject<PaintingVariant> PROPAGANDA = PAINTING_VARIANTS.register("propaganda", () -> new PaintingVariant(32, 48));
    public static final RegistryObject<PaintingVariant> ROOTS = PAINTING_VARIANTS.register("roots", () -> new PaintingVariant(16, 16));
    public static final RegistryObject<PaintingVariant> NUMBER_ONE = PAINTING_VARIANTS.register("number_one", () -> new PaintingVariant(48, 48));
    public static final RegistryObject<PaintingVariant> LIES = PAINTING_VARIANTS.register("lies", () -> new PaintingVariant(64, 48));
    public static final RegistryObject<PaintingVariant> BLUE_TILES = PAINTING_VARIANTS.register("blue_tiles", () -> new PaintingVariant(64, 64));

    public static void init(IEventBus bus) {
        PAINTING_VARIANTS.register(bus);
    }
}
