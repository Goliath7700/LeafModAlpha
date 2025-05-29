package me.goli7700.block;

import me.goli7700.LeafModAlpha;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {

    public static final Block VOID_ORE = registerBlock("void_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(5, 10),
                    AbstractBlock.Settings.create().requiresTool().strength(30.0F, 1200.0F).sounds(BlockSoundGroup.AMETHYST_CLUSTER)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(LeafModAlpha.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(LeafModAlpha.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        LeafModAlpha.LOGGER.info("Registering Modded Blocks from " + LeafModAlpha.MOD_ID);
    }
}
