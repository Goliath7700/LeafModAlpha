package me.goli7700;

import me.goli7700.block.ModBlocks;
import me.goli7700.item.ModItemGroups;
import me.goli7700.item.ModItems;
import me.goli7700.particle.ModParticles;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LeafModAlpha implements ModInitializer {
	public static final String MOD_ID = "leafmodalpha";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModItemGroups.registerItemGroups();
		ModParticles.registerModParticles();
	}
}