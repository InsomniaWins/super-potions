package org.example.super_potions;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.brewing.RegisterBrewingRecipesEvent;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

public class ModPotions {


    public static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(BuiltInRegistries.POTION, SuperPotions.MODID);


    public static final Holder<Potion> SUPER_LEAPING = POTIONS.register("super_leaping", registryName -> new Potion(
            registryName.getPath(),
            new MobEffectInstance(MobEffects.JUMP_BOOST, 3600, 1)
    ));

    public static final Holder<Potion> SUPER_SWIFTNESS = POTIONS.register("super_swiftness", registryName -> new Potion(
            registryName.getPath(),
            new MobEffectInstance(MobEffects.SPEED, 3600, 1)
    ));

    public static final Holder<Potion> SUPER_SLOWNESS = POTIONS.register("super_slowness", registryName -> new Potion(
            registryName.getPath(),
            new MobEffectInstance(MobEffects.SLOWNESS, 1800, 1)
    ));

    public static final Holder<Potion> SUPER_TURTLE_MASTER = POTIONS.register("super_turtle_master", registryName -> new Potion(
            registryName.getPath(),
            new MobEffectInstance(MobEffects.SLOWNESS, 700, 4),
            new MobEffectInstance(MobEffects.RESISTANCE, 700, 3)
    ));

    public static final Holder<Potion> SUPER_POISON = POTIONS.register("super_poison", registryName -> new Potion(
            registryName.getPath(),
            new MobEffectInstance(MobEffects.POISON, 900, 1)
    ));

    public static final Holder<Potion> SUPER_REGENERATION = POTIONS.register("super_regeneration", registryName -> new Potion(
            registryName.getPath(),
            new MobEffectInstance(MobEffects.REGENERATION, 900, 1)
    ));

    public static final Holder<Potion> SUPER_STRENGTH = POTIONS.register("super_strength", registryName -> new Potion(
            registryName.getPath(),
            new MobEffectInstance(MobEffects.STRENGTH, 3600, 1)
    ));









    @SubscribeEvent
    public static void registerBrewingRecipes(RegisterBrewingRecipesEvent event) {
        PotionBrewing.Builder builder = event.getBuilder();

        builder.addMix(
                Potions.LONG_LEAPING,
                Blocks.GLOWSTONE.asItem(),
                SUPER_LEAPING
        );

        builder.addMix(
                Potions.STRONG_LEAPING,
                Blocks.REDSTONE_BLOCK.asItem(),
                SUPER_LEAPING
        );




        builder.addMix(
                Potions.LONG_SWIFTNESS,
                Blocks.GLOWSTONE.asItem(),
                SUPER_SWIFTNESS
        );

        builder.addMix(
                Potions.STRONG_SWIFTNESS,
                Blocks.REDSTONE_BLOCK.asItem(),
                SUPER_SWIFTNESS
        );



        builder.addMix(
                Potions.LONG_SLOWNESS,
                Blocks.GLOWSTONE.asItem(),
                SUPER_SLOWNESS
        );

        builder.addMix(
                Potions.STRONG_SLOWNESS,
                Blocks.REDSTONE_BLOCK.asItem(),
                SUPER_SLOWNESS
        );




        builder.addMix(
                Potions.LONG_TURTLE_MASTER,
                Blocks.GLOWSTONE.asItem(),
                SUPER_TURTLE_MASTER
        );

        builder.addMix(
                Potions.STRONG_TURTLE_MASTER,
                Blocks.REDSTONE_BLOCK.asItem(),
                SUPER_TURTLE_MASTER
        );



        builder.addMix(
                Potions.LONG_POISON,
                Blocks.GLOWSTONE.asItem(),
                SUPER_POISON
        );

        builder.addMix(
                Potions.STRONG_POISON,
                Blocks.REDSTONE_BLOCK.asItem(),
                SUPER_POISON
        );




        builder.addMix(
                Potions.LONG_REGENERATION,
                Blocks.GLOWSTONE.asItem(),
                SUPER_REGENERATION
        );

        builder.addMix(
                Potions.STRONG_REGENERATION,
                Blocks.REDSTONE_BLOCK.asItem(),
                SUPER_REGENERATION
        );




        builder.addMix(
                Potions.LONG_STRENGTH,
                Blocks.GLOWSTONE.asItem(),
                SUPER_STRENGTH
        );

        builder.addMix(
                Potions.STRONG_STRENGTH,
                Blocks.REDSTONE_BLOCK.asItem(),
                SUPER_STRENGTH
        );
    }

    public static void register(IEventBus bus) {


        Set<Map.Entry<ResourceKey<Potion>, Potion>> potions = BuiltInRegistries.POTION.entrySet();
        for (Map.Entry<ResourceKey<Potion>, Potion> potionEntry : potions) {

            Potion potion = potionEntry.getValue();




        }

        POTIONS.register(bus);
    }

}
