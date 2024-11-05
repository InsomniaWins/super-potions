package wins.insomnia.super_potions;

import net.fabricmc.api.ModInitializer;
import wins.insomnia.super_potions.potion.Potions;

public class SuperPotions implements ModInitializer {

    @Override
    public void onInitialize() {

        Potions.registerRecipes();

    }
}
