package me.goli7700.enchantment;

import com.mojang.serialization.MapCodec;
import me.goli7700.LeafModAlpha;
import me.goli7700.enchantment.custom.LightningStrikerEnchantmentEffect;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEnchantmentEffects {
    public static final MapCodec<? extends EnchantmentEntityEffect> LIGHTNING_STRIKER =
            registerEntityEffect("lightning_striker", LightningStrikerEnchantmentEffect.CODEC);


    private static MapCodec<? extends EnchantmentEntityEffect> registerEntityEffect(String name,
                                                                                    MapCodec<? extends EnchantmentEntityEffect> codec) {
        return Registry.register(Registries.ENCHANTMENT_ENTITY_EFFECT_TYPE, Identifier.of(LeafModAlpha.MOD_ID, name), codec);
    }

    public static void registerEnchantmentEffects() {
        LeafModAlpha.LOGGER.info("Registering Mod Enchantment Effects for " + LeafModAlpha.MOD_ID);
    }
}