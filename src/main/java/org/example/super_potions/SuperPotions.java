package org.example.super_potions;

import com.mojang.logging.LogUtils;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import org.slf4j.Logger;


@Mod(SuperPotions.MODID)
public class SuperPotions {
    public static final String MODID = "super_potions";
    public static final Logger LOGGER = LogUtils.getLogger();


    public SuperPotions(IEventBus modEventBus, ModContainer modContainer) {

        modEventBus.addListener(this::commonSetup);

        NeoForge.EVENT_BUS.addListener(ModPotions::registerBrewingRecipes);

        ModPotions.register(modEventBus);

    }



    private void commonSetup(final FMLCommonSetupEvent event) {



    }

}
