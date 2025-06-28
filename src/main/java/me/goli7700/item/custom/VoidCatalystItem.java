package me.goli7700.item.custom;

import me.goli7700.item.ModItems;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class VoidCatalystItem extends Item {
    public VoidCatalystItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ItemStack stack = player.getStackInHand(hand);


        // Replace the item in hand with an apple
        ItemStack shatteredVoidCatalyst = new ItemStack(ModItems.SHATTERED_VOID_CATALYST);
        shatteredVoidCatalyst.setCount(stack.getCount()); // Maintain stack size
        player.setStackInHand(hand, shatteredVoidCatalyst);

        // Play sound effect (optional)
        player.playSound(SoundEvents.BLOCK_HEAVY_CORE_BREAK, 0.4F, 0.1F);
        player.playSound(SoundEvents.BLOCK_GLASS_BREAK, 0.12F, 0.1F);
        player.playSound(SoundEvents.PARTICLE_SOUL_ESCAPE.value(), 0.5F, 0.4F);

        return TypedActionResult.success(player.getStackInHand(hand));
    }
}