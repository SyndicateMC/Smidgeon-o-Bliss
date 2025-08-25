package com.syndicatemc.sob.fluid;

import com.syndicatemc.sob.SOB;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraftforge.client.extensions.common.IClientFluidTypeExtensions;
import net.minecraftforge.common.SoundActions;
import net.minecraftforge.fluids.FluidType;

import java.util.function.Consumer;

public class EumozzCheeseFluidType extends FluidType {
    public EumozzCheeseFluidType() {
        super(FluidType.Properties.create()
                .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL)
                .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY)
                .sound(SoundActions.FLUID_VAPORIZE, SoundEvents.FIRE_EXTINGUISH)
        );
    }

    @Override
    public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer) {
        consumer.accept(new IClientFluidTypeExtensions() {
            @Override
            public ResourceLocation getStillTexture() {
                return new ResourceLocation(SOB.MOD_ID, "block/eumozz_cheese_still");
            }

            @Override
            public ResourceLocation getFlowingTexture() {
                return new ResourceLocation(SOB.MOD_ID, "block/eumozz_cheese_flow");
            }
        });
    }
}