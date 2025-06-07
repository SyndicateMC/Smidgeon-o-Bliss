package com.syndicatemc.sob.init;

import com.syndicatemc.sob.SOB;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SOBSounds {
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, SOB.MOD_ID);

    public static final RegistryObject<SoundEvent> COLLAPSE_BUILDING = SOUNDS.register("entity.collapse_building",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(SOB.MOD_ID, "entity.collapse_building")));
    public static final RegistryObject<SoundEvent> COLLAPSING = SOUNDS.register("entity.collapsing",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(SOB.MOD_ID, "entity.collapsing")));
    public static final RegistryObject<SoundEvent> FIZZY_DRINK = SOUNDS.register("item.fizzy_drink",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(SOB.MOD_ID, "item.fizzy_drink")));

    public static void init(IEventBus bus) {
        SOUNDS.register(bus);
    }
}
