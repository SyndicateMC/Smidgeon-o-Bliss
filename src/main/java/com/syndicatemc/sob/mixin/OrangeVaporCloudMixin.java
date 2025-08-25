package com.syndicatemc.sob.mixin;

import com.syndicatemc.sob.init.SOBMobEffects;
import com.teamabnormals.atmospheric.common.entity.OrangeVaporCloud;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.AABB;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(OrangeVaporCloud.class)
public class OrangeVaporCloudMixin {
    @Inject(method = "tick", at = @At("HEAD"))
    private void sob$tick(CallbackInfo ci) {
        OrangeVaporCloud entity = (OrangeVaporCloud) (Object) this;
        AABB boundingBox = entity.getBoundingBox();
        if (entity.level() == null) return;
        entity.level().getEntities(null, boundingBox).stream().filter(entity1 -> entity1 instanceof LivingEntity).forEach(entity1 -> {
            if (((LivingEntity) entity1).hasEffect(SOBMobEffects.ZEST.get())) {
                LivingEntity e = (LivingEntity) entity1;
                e.addEffect(new MobEffectInstance(SOBMobEffects.ZEST_BOOST.get(), 100, 0, false, true));
            }
        });
    }
}