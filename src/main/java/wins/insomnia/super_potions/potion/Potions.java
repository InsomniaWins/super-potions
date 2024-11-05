package wins.insomnia.super_potions.potion;

import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class Potions {

    public static final Potion SUPER_LEAPING = register("super_leaping", new Potion("leaping", new StatusEffectInstance(StatusEffects.JUMP_BOOST, 3600, 1)));
    public static final Potion SUPER_SWIFTNESS = register("super_swiftness", new Potion("swiftness", new StatusEffectInstance(StatusEffects.SPEED, 3600, 1)));
    public static final Potion SUPER_SLOWNESS = register("super_slowness", new Potion("slowness", new StatusEffectInstance(StatusEffects.SLOWNESS, 1800, 3)));
    public static final Potion SUPER_TURTLE_MASTER = register("super_turtle_master", new Potion("turtle_master", new StatusEffectInstance(StatusEffects.SLOWNESS, 800, 5), new StatusEffectInstance(StatusEffects.RESISTANCE, 800, 3)));
    public static final Potion SUPER_POISON = register("super_poison", new Potion("poison", new StatusEffectInstance(StatusEffects.POISON, 900, 1)));
    public static final Potion SUPER_REGENERATION = register("super_regeneration", new Potion("regeneration", new StatusEffectInstance(StatusEffects.REGENERATION, 900, 1)));
    public static final Potion SUPER_STRENGTH = register("super_strength", new Potion("strength", new StatusEffectInstance(StatusEffects.STRENGTH, 3600, 1)));

    private static Potion register(String potionId, Potion potion) {

        return Registry.register(Registries.POTION, Identifier.of("super_potions", potionId), potion);

    }

    public static void registerRecipes() {

        SuperPotionRecipe[] superPotionRecipes = new SuperPotionRecipe[] {
                new SuperPotionRecipe(
                        net.minecraft.potion.Potions.LONG_LEAPING,
                        net.minecraft.potion.Potions.STRONG_LEAPING,
                        SUPER_LEAPING
                ),
                new SuperPotionRecipe(
                        net.minecraft.potion.Potions.LONG_SWIFTNESS,
                        net.minecraft.potion.Potions.STRONG_SWIFTNESS,
                        SUPER_SWIFTNESS
                ),
                new SuperPotionRecipe(
                        net.minecraft.potion.Potions.LONG_SLOWNESS,
                        net.minecraft.potion.Potions.STRONG_SLOWNESS,
                        SUPER_SLOWNESS
                ),
                new SuperPotionRecipe(
                        net.minecraft.potion.Potions.LONG_TURTLE_MASTER,
                        net.minecraft.potion.Potions.STRONG_TURTLE_MASTER,
                        SUPER_TURTLE_MASTER
                ),
                new SuperPotionRecipe(
                        net.minecraft.potion.Potions.LONG_POISON,
                        net.minecraft.potion.Potions.STRONG_POISON,
                        SUPER_POISON
                ),
                new SuperPotionRecipe(
                        net.minecraft.potion.Potions.LONG_REGENERATION,
                        net.minecraft.potion.Potions.STRONG_REGENERATION,
                        SUPER_REGENERATION
                ),
                new SuperPotionRecipe(
                        net.minecraft.potion.Potions.LONG_STRENGTH,
                        net.minecraft.potion.Potions.STRONG_STRENGTH,
                        SUPER_STRENGTH
                ),
        };

        FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {

            for (SuperPotionRecipe superPotionRecipe : superPotionRecipes) {
                builder.registerPotionRecipe(superPotionRecipe.longPotion, Items.GLOWSTONE_DUST, Registries.POTION.getEntry(superPotionRecipe.superPotion));
                builder.registerPotionRecipe(superPotionRecipe.strongPotion, Items.REDSTONE, Registries.POTION.getEntry(superPotionRecipe.superPotion));
            }

        });

    }

    public record SuperPotionRecipe(RegistryEntry<Potion> longPotion, RegistryEntry<Potion> strongPotion, Potion superPotion) {};

}
