package com.syndicatemc.sob.init;

import com.syndicatemc.sob.SOB;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;

public class SOBTags {
    public static final TagKey<EntityType<?>> CAMEL_FEED_USERS = modEntityTag("camel_feed_users");
    public static final TagKey<EntityType<?>> PEANUT_BUTTER_USERS = modEntityTag("peanut_butter_users");

    private static TagKey<EntityType<?>> modEntityTag(String path) {
        return TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation(SOB.MOD_ID, path));
    }
}
