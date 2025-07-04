package com.syndicatemc.sob.init;

import com.syndicatemc.sob.SOB;
import net.minecraft.core.Holder;
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
    public static final RegistryObject<SoundEvent> JUICY_EAT = SOUNDS.register("item.juicy_eat",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(SOB.MOD_ID, "item.juicy_eat")));
    public static final RegistryObject<SoundEvent> SPITE_PRICK = SOUNDS.register("entity.spite_prick",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(SOB.MOD_ID, "entity.spite_prick")));
    public static final RegistryObject<SoundEvent> SPITE_CONSUME = SOUNDS.register("entity.spite_consume",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(SOB.MOD_ID, "entity.spite_consume")));
    public static final RegistryObject<SoundEvent> ICHORFRUIT_EXPLODE = SOUNDS.register("entity.ichorfruit_explode",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(SOB.MOD_ID, "entity.ichorfruit_explode")));
    public static final RegistryObject<SoundEvent> SLAP_BASE = SOUNDS.register("block.slap_base",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(SOB.MOD_ID, "block.slap_base")));
    public static final RegistryObject<SoundEvent> NICE_GUITAR = SOUNDS.register("block.nice_guitar",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(SOB.MOD_ID, "block.nice_guitar")));

    public static void init(IEventBus bus) {
        SOUNDS.register(bus);
    }
}