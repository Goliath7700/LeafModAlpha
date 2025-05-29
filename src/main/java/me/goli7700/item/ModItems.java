package me.goli7700.item;

import me.goli7700.LeafModAlpha;
import me.goli7700.sound.ModSounds;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class ModItems {

    public static final Item NULL_MUSIC_DISC = registerItem("null_music_disc", new Item(new Item.Settings().jukeboxPlayable(ModSounds.NULL_KEY).rarity(Rarity.EPIC).maxCount(1)));
    public static final Item SINKING_DUNES_MUSIC_DISC = registerItem("sinking_dunes_music_disc", new Item(new Item.Settings().jukeboxPlayable(ModSounds.SINKING_DUNES_KEY).rarity(Rarity.EPIC).maxCount(1)));
    public static final Item RUBY_SWORD = registerItem("ruby_sword",
            new SwordItem(ModToolMaterials.RUBY, new Item.Settings()
            .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.RUBY,8, -2.4f))));

    public static final Item RUBY = registerItem("ruby", new Item(new Item.Settings()));
    public static final Item VOID = registerItem("void", new Item(new Item.Settings()));
    public static final Item VOID_CATALYST = registerItem("void_catalyst", new Item(new Item.Settings()));
    public static final Item SHATTERED_VOID_CATALYST = registerItem("shattered_void_catalyst", new Item(new Item.Settings()));
    public static final Item CHARGED_VOID_CATALYST = registerItem("charged_void_catalyst", new Item(new Item.Settings()));



    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(LeafModAlpha.MOD_ID, name), item);
    }

    public static void registerModItems() {
        LeafModAlpha.LOGGER.info("Registering modded items from " + LeafModAlpha.MOD_ID);
    }
}
