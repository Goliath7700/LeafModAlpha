package me.goli7700.item;

import me.goli7700.LeafModAlpha;
import me.goli7700.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    public static final ItemGroup LEAFMODALPHA_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(LeafModAlpha.MOD_ID, "leafmodalpha_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.RUBY))
                    .displayName(Text.translatable("itemgroup.leafmodalpha.leafmodalpha_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.CORRUPT_CROWN);
                        entries.add(ModItems.LONGBOW);
                        entries.add(ModItems.RUBY);
                        entries.add(ModItems.RUBY_SWORD);
                        entries.add(ModBlocks.VOID_ORE);
                        entries.add(ModItems.VOID);
                        entries.add(ModItems.VOID_CATALYST);
                        entries.add(ModItems.SHATTERED_VOID_CATALYST);
                        entries.add(ModItems.CHARGED_VOID_CATALYST);
                        entries.add(ModItems.NULL_MUSIC_DISC);
                        entries.add(ModItems.SINKING_DUNES_MUSIC_DISC);
                        entries.add(ModItems.GAME_OVER_MUSIC_DISC);
                    }).build());

    public static void registerItemGroups() {
        LeafModAlpha.LOGGER.info("Registering Mod Item Groups from " + LeafModAlpha.MOD_ID);
    }
}
