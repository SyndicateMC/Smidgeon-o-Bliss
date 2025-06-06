package com.syndicatemc.sob.init;

import com.syndicatemc.sob.SOB;
import com.syndicatemc.sob.fluid.SOBFluidType;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import umpaz.brewinandchewin.common.fluid.AlcoholFluidType;
import umpaz.brewinandchewin.common.registry.BnCFluids;

public class SOBFluids {
    public static final DeferredRegister<FluidType> FLUID_TYPES = DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, SOB.MOD_ID);
    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, SOB.MOD_ID);

    //req: ATMO & BaC
    public static final RegistryObject<FluidType> TEQUILA_FLUID_TYPE = FLUID_TYPES.register("tequila_type", () -> new SOBFluidType(0x8ADAB917));
    public static final RegistryObject<FlowingFluid> TEQUILA = FLUIDS.register("tequila", () -> new ForgeFlowingFluid.Source(SOBFluids.TEQUILA_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_TEQUILA = FLUIDS.register("flowing_tequila", () -> new ForgeFlowingFluid.Flowing(SOBFluids.TEQUILA_FLUID_PROPERTIES));
    public static final ForgeFlowingFluid.Properties TEQUILA_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(TEQUILA_FLUID_TYPE, TEQUILA, FLOWING_TEQUILA);

    //req: ATMO & BaC
    public static final RegistryObject<FluidType> SUNRISE_SELTZER_FLUID_TYPE = FLUID_TYPES.register("sunrise_seltzer_type", () -> new SOBFluidType(0xF9702F17));
    public static final RegistryObject<FlowingFluid> SUNRISE_SELTZER = FLUIDS.register("sunrise_seltzer", () -> new ForgeFlowingFluid.Source(SOBFluids.SUNRISE_SELTZER_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_SUNRISE_SELTZER = FLUIDS.register("flowing_sunrise_seltzer", () -> new ForgeFlowingFluid.Flowing(SOBFluids.SUNRISE_SELTZER_FLUID_PROPERTIES));
    public static final ForgeFlowingFluid.Properties SUNRISE_SELTZER_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(SUNRISE_SELTZER_FLUID_TYPE, SUNRISE_SELTZER, FLOWING_SUNRISE_SELTZER);

    //req: BaC
    public static final RegistryObject<FluidType> HARD_CIDER_FLUID_TYPE = FLUID_TYPES.register("hard_cider_type", () -> new SOBFluidType(0xB8663317));
    public static final RegistryObject<FlowingFluid> HARD_CIDER = FLUIDS.register("hard_cider", () -> new ForgeFlowingFluid.Source(SOBFluids.HARD_CIDER_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_HARD_CIDER = FLUIDS.register("flowing_hard_cider", () -> new ForgeFlowingFluid.Flowing(SOBFluids.HARD_CIDER_FLUID_PROPERTIES));
    public static final ForgeFlowingFluid.Properties HARD_CIDER_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(HARD_CIDER_FLUID_TYPE, HARD_CIDER, FLOWING_HARD_CIDER);

    //req: BaC & SaR
    public static final RegistryObject<FluidType> CREEPER_DRINK_FLUID_TYPE = FLUID_TYPES.register("creeper_drink_type", () -> new SOBFluidType(0xB8663317));
    public static final RegistryObject<FlowingFluid> CREEPER_DRINK = FLUIDS.register("creeper_drink", () -> new ForgeFlowingFluid.Source(SOBFluids.CREEPER_DRINK_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_CREEPER_DRINK = FLUIDS.register("flowing_creeper_drink", () -> new ForgeFlowingFluid.Flowing(SOBFluids.CREEPER_DRINK_FLUID_PROPERTIES));
    public static final ForgeFlowingFluid.Properties CREEPER_DRINK_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(CREEPER_DRINK_FLUID_TYPE, CREEPER_DRINK, FLOWING_CREEPER_DRINK);


    //req: FR
    public static final RegistryObject<FluidType> BITTER_TEA_FLUID_TYPE = FLUID_TYPES.register("bitter_tea_type", () -> new SOBFluidType(0x98B23817));
    public static final RegistryObject<FlowingFluid> BITTER_TEA = FLUIDS.register("bitter_tea", () -> new ForgeFlowingFluid.Source(SOBFluids.BITTER_TEA_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_BITTER_TEA = FLUIDS.register("flowing_bitter_tea", () -> new ForgeFlowingFluid.Flowing(SOBFluids.BITTER_TEA_FLUID_PROPERTIES));
    public static final ForgeFlowingFluid.Properties BITTER_TEA_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(BITTER_TEA_FLUID_TYPE, BITTER_TEA, FLOWING_BITTER_TEA);
    
    //req: FR & ATMO
    public static final RegistryObject<FluidType> ALOE_TEA_FLUID_TYPE = FLUID_TYPES.register("aloe_tea_type", () -> new SOBFluidType(0x59D13217));
    public static final RegistryObject<FlowingFluid> ALOE_TEA = FLUIDS.register("aloe_tea", () -> new ForgeFlowingFluid.Source(SOBFluids.ALOE_TEA_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_ALOE_TEA = FLUIDS.register("flowing_aloe_tea", () -> new ForgeFlowingFluid.Flowing(SOBFluids.ALOE_TEA_FLUID_PROPERTIES));
    public static final ForgeFlowingFluid.Properties ALOE_TEA_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(ALOE_TEA_FLUID_TYPE, ALOE_TEA, FLOWING_ALOE_TEA);

    public static void init(IEventBus bus) {
        FLUIDS.register(bus);
    }
}
