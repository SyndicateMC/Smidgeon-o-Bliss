package com.syndicatemc.sob.init;

import com.syndicatemc.sob.SOB;
import com.syndicatemc.sob.fluid.BustlingBrewFluidType;
import com.syndicatemc.sob.fluid.EumozzCheeseFluidType;
import com.syndicatemc.sob.fluid.LiquidExperienceFluidType;
import com.syndicatemc.sob.fluid.SOBGenericFluidType;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SOBFluids {
    public static final DeferredRegister<FluidType> FLUID_TYPES = DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, SOB.MOD_ID);
    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, SOB.MOD_ID);

    public static final RegistryObject<FluidType> HARD_CIDER_FLUID_TYPE = FLUID_TYPES.register("hard_cider_type", () -> new SOBGenericFluidType(0xFFB86633));
    public static final RegistryObject<FlowingFluid> HARD_CIDER = FLUIDS.register("hard_cider", () -> new ForgeFlowingFluid.Source(SOBFluids.HARD_CIDER_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_HARD_CIDER = FLUIDS.register("flowing_hard_cider", () -> new ForgeFlowingFluid.Flowing(SOBFluids.HARD_CIDER_FLUID_PROPERTIES));
    public static final ForgeFlowingFluid.Properties HARD_CIDER_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(HARD_CIDER_FLUID_TYPE, HARD_CIDER, FLOWING_HARD_CIDER);

    public static final RegistryObject<FluidType> DEATH_DRINK_FLUID_TYPE = FLUID_TYPES.register("death_drink_type", () -> new SOBGenericFluidType(0xFF5C2636));
    public static final RegistryObject<FlowingFluid> DEATH_DRINK = FLUIDS.register("death_drink", () -> new ForgeFlowingFluid.Source(SOBFluids.DEATH_DRINK_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_DEATH_DRINK = FLUIDS.register("flowing_death_drink", () -> new ForgeFlowingFluid.Flowing(SOBFluids.DEATH_DRINK_FLUID_PROPERTIES));
    public static final ForgeFlowingFluid.Properties DEATH_DRINK_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(DEATH_DRINK_FLUID_TYPE, DEATH_DRINK, FLOWING_DEATH_DRINK);

    public static final RegistryObject<FluidType> PRICKLY_MELOMEL_FLUID_TYPE = FLUID_TYPES.register("prickly_melomel_type", () -> new SOBGenericFluidType(0xFFCA5792));
    public static final RegistryObject<FlowingFluid> PRICKLY_MELOMEL = FLUIDS.register("prickly_melomel", () -> new ForgeFlowingFluid.Source(SOBFluids.PRICKLY_MELOMEL_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_PRICKLY_MELOMEL = FLUIDS.register("flowing_prickly_melomel", () -> new ForgeFlowingFluid.Flowing(SOBFluids.PRICKLY_MELOMEL_FLUID_PROPERTIES));
    public static final ForgeFlowingFluid.Properties PRICKLY_MELOMEL_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(PRICKLY_MELOMEL_FLUID_TYPE, PRICKLY_MELOMEL, FLOWING_PRICKLY_MELOMEL);

    public static final RegistryObject<FluidType> LIQUID_EXPERIENCE_FLUID_TYPE = FLUID_TYPES.register("liquid_experience_type", LiquidExperienceFluidType::new);
    public static final RegistryObject<FlowingFluid> LIQUID_EXPERIENCE = FLUIDS.register("liquid_experience", () -> new ForgeFlowingFluid.Source(SOBFluids.LIQUID_EXPERIENCE_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_LIQUID_EXPERIENCE = FLUIDS.register("flowing_liquid_experience", () -> new ForgeFlowingFluid.Flowing(SOBFluids.LIQUID_EXPERIENCE_FLUID_PROPERTIES));
    public static final ForgeFlowingFluid.Properties LIQUID_EXPERIENCE_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(LIQUID_EXPERIENCE_FLUID_TYPE, LIQUID_EXPERIENCE, FLOWING_LIQUID_EXPERIENCE);

    public static final RegistryObject<FluidType> BUSTLING_BREW_FLUID_TYPE = FLUID_TYPES.register("bustling_brew_type", BustlingBrewFluidType::new);
    public static final RegistryObject<FlowingFluid> BUSTLING_BREW = FLUIDS.register("bustling_brew", () -> new ForgeFlowingFluid.Source(SOBFluids.BUSTLING_BREW_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_BUSTLING_BREW = FLUIDS.register("flowing_bustling_brew", () -> new ForgeFlowingFluid.Flowing(SOBFluids.BUSTLING_BREW_FLUID_PROPERTIES));
    public static final ForgeFlowingFluid.Properties BUSTLING_BREW_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(BUSTLING_BREW_FLUID_TYPE, BUSTLING_BREW, FLOWING_BUSTLING_BREW);

    //req: ATMO
    public static final RegistryObject<FluidType> TEQUILA_FLUID_TYPE = FLUID_TYPES.register("tequila_type", () -> new SOBGenericFluidType(0xFF8ADAB9));
    public static final RegistryObject<FlowingFluid> TEQUILA = FLUIDS.register("tequila", () -> new ForgeFlowingFluid.Source(SOBFluids.TEQUILA_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_TEQUILA = FLUIDS.register("flowing_tequila", () -> new ForgeFlowingFluid.Flowing(SOBFluids.TEQUILA_FLUID_PROPERTIES));
    public static final ForgeFlowingFluid.Properties TEQUILA_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(TEQUILA_FLUID_TYPE, TEQUILA, FLOWING_TEQUILA);

    //req: ATMO
    public static final RegistryObject<FluidType> SUNRISE_SELTZER_FLUID_TYPE = FLUID_TYPES.register("sunrise_seltzer_type", () -> new SOBGenericFluidType(0xFFF9702F));
    public static final RegistryObject<FlowingFluid> SUNRISE_SELTZER = FLUIDS.register("sunrise_seltzer", () -> new ForgeFlowingFluid.Source(SOBFluids.SUNRISE_SELTZER_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_SUNRISE_SELTZER = FLUIDS.register("flowing_sunrise_seltzer", () -> new ForgeFlowingFluid.Flowing(SOBFluids.SUNRISE_SELTZER_FLUID_PROPERTIES));
    public static final ForgeFlowingFluid.Properties SUNRISE_SELTZER_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(SUNRISE_SELTZER_FLUID_TYPE, SUNRISE_SELTZER, FLOWING_SUNRISE_SELTZER);

    //req: SaR
    public static final RegistryObject<FluidType> CREEPER_DRINK_FLUID_TYPE = FLUID_TYPES.register("creeper_drink_type", () -> new SOBGenericFluidType(0xFF85C766));
    public static final RegistryObject<FlowingFluid> CREEPER_DRINK = FLUIDS.register("creeper_drink", () -> new ForgeFlowingFluid.Source(SOBFluids.CREEPER_DRINK_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_CREEPER_DRINK = FLUIDS.register("flowing_creeper_drink", () -> new ForgeFlowingFluid.Flowing(SOBFluids.CREEPER_DRINK_FLUID_PROPERTIES));
    public static final ForgeFlowingFluid.Properties CREEPER_DRINK_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(CREEPER_DRINK_FLUID_TYPE, CREEPER_DRINK, FLOWING_CREEPER_DRINK);

    //req: NEA
    public static final RegistryObject<FluidType> PALE_DAIQUIRI_FLUID_TYPE = FLUID_TYPES.register("pale_daiquiri_type", () -> new SOBGenericFluidType(0xFFFAE9E9));
    public static final RegistryObject<FlowingFluid> PALE_DAIQUIRI = FLUIDS.register("pale_daiquiri", () -> new ForgeFlowingFluid.Source(SOBFluids.PALE_DAIQUIRI_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_PALE_DAIQUIRI = FLUIDS.register("flowing_pale_daiquiri", () -> new ForgeFlowingFluid.Flowing(SOBFluids.PALE_DAIQUIRI_FLUID_PROPERTIES));
    public static final ForgeFlowingFluid.Properties PALE_DAIQUIRI_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(PALE_DAIQUIRI_FLUID_TYPE, PALE_DAIQUIRI, FLOWING_PALE_DAIQUIRI);

    //req: FR
    public static final RegistryObject<FluidType> BITTER_TEA_FLUID_TYPE = FLUID_TYPES.register("bitter_tea_type", () -> new SOBGenericFluidType(0xFF98B238));
    public static final RegistryObject<FlowingFluid> BITTER_TEA = FLUIDS.register("bitter_tea", () -> new ForgeFlowingFluid.Source(SOBFluids.BITTER_TEA_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_BITTER_TEA = FLUIDS.register("flowing_bitter_tea", () -> new ForgeFlowingFluid.Flowing(SOBFluids.BITTER_TEA_FLUID_PROPERTIES));
    public static final ForgeFlowingFluid.Properties BITTER_TEA_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(BITTER_TEA_FLUID_TYPE, BITTER_TEA, FLOWING_BITTER_TEA);
    
    //req: FR & ATMO
    public static final RegistryObject<FluidType> ALOE_TEA_FLUID_TYPE = FLUID_TYPES.register("aloe_tea_type", () -> new SOBGenericFluidType(0xFF59D132));
    public static final RegistryObject<FlowingFluid> ALOE_TEA = FLUIDS.register("aloe_tea", () -> new ForgeFlowingFluid.Source(SOBFluids.ALOE_TEA_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_ALOE_TEA = FLUIDS.register("flowing_aloe_tea", () -> new ForgeFlowingFluid.Flowing(SOBFluids.ALOE_TEA_FLUID_PROPERTIES));
    public static final ForgeFlowingFluid.Properties ALOE_TEA_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(ALOE_TEA_FLUID_TYPE, ALOE_TEA, FLOWING_ALOE_TEA);

    //req: endergetic
    public static final RegistryObject<FluidType> EUMOZZ_CHEESE_FLUID_TYPE = FLUID_TYPES.register("eumozz_cheese_type", EumozzCheeseFluidType::new);
    public static final RegistryObject<FlowingFluid> EUMOZZ_CHEESE = FLUIDS.register("eumozz_cheese", () -> new ForgeFlowingFluid.Source(SOBFluids.EUMOZZ_CHEESE_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_EUMOZZ_CHEESE = FLUIDS.register("flowing_eumozz_cheese", () -> new ForgeFlowingFluid.Flowing(SOBFluids.EUMOZZ_CHEESE_FLUID_PROPERTIES));
    public static final ForgeFlowingFluid.Properties EUMOZZ_CHEESE_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(EUMOZZ_CHEESE_FLUID_TYPE, EUMOZZ_CHEESE, FLOWING_EUMOZZ_CHEESE);

    //req: spelunkery
    public static final RegistryObject<FluidType> PORTAL_DRINK_FLUID_TYPE = FLUID_TYPES.register("portal_drink_type", () -> new SOBGenericFluidType(0xFF7519D2));
    public static final RegistryObject<FlowingFluid> PORTAL_DRINK = FLUIDS.register("portal_drink", () -> new ForgeFlowingFluid.Source(SOBFluids.PORTAL_DRINK_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_PORTAL_DRINK = FLUIDS.register("flowing_portal_drink", () -> new ForgeFlowingFluid.Flowing(SOBFluids.PORTAL_DRINK_FLUID_PROPERTIES));
    public static final ForgeFlowingFluid.Properties PORTAL_DRINK_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(PORTAL_DRINK_FLUID_TYPE, PORTAL_DRINK, FLOWING_PORTAL_DRINK);

    //req: MD
    public static final RegistryObject<FluidType> ROOT_BEER_FLUID_TYPE = FLUID_TYPES.register("root_beer_type", () -> new SOBGenericFluidType(0xFF371717));
    public static final RegistryObject<FlowingFluid> ROOT_BEER = FLUIDS.register("root_beer", () -> new ForgeFlowingFluid.Source(SOBFluids.ROOT_BEER_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_ROOT_BEER = FLUIDS.register("flowing_root_beer", () -> new ForgeFlowingFluid.Flowing(SOBFluids.ROOT_BEER_FLUID_PROPERTIES));
    public static final ForgeFlowingFluid.Properties ROOT_BEER_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(ROOT_BEER_FLUID_TYPE, ROOT_BEER, FLOWING_ROOT_BEER);

    public static void init(IEventBus bus) {
        FLUIDS.register(bus);
        FLUID_TYPES.register(bus);
    }
}
