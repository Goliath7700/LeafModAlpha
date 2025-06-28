package me.goli7700.misc;

import me.goli7700.item.ModItems;
import me.goli7700.particle.ModParticles;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerEntityEvents;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LightningEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.Box;

public class ModLightningTransformationHandler {

    // Register transformation pairs (original item -> transformed item)
    private static final TransformationMap TRANSFORMATIONS = new TransformationMap();

    static {
        // Example: Apple turns to Golden Apple when struck by lightning
        TRANSFORMATIONS.addTransformation(ModItems.SHATTERED_VOID_CATALYST, ModItems.CHARGED_VOID_CATALYST);
        // Add more transformations here
    }

    public static void register() {
        ServerEntityEvents.ENTITY_LOAD.register((entity, world) -> {
            if (entity.getType() == EntityType.LIGHTNING_BOLT) {
                handleLightningStrike((LightningEntity) entity, world);
            }
        });
    }

    private static void handleLightningStrike(LightningEntity lightning, ServerWorld world) {
        // Create a bounding box around lightning strike (5 block radius)
        Box area = new Box(lightning.getBlockPos()).expand(5.0);

        // Get all item entities in the area
        world.getEntitiesByClass(ItemEntity.class, area, e -> true).forEach(itemEntity -> {
            ItemStack stack = itemEntity.getStack();
            Item transformedItem = TRANSFORMATIONS.getTransformedItem(stack.getItem());

            if (transformedItem != null) {
                // Replace item and preserve stack count
                ItemStack newStack = new ItemStack(transformedItem, stack.getCount());
                ItemEntity newEntity = new ItemEntity(
                        world,
                        itemEntity.getX(),
                        itemEntity.getY(),
                        itemEntity.getZ(),
                        newStack
                );

                // Copy velocity and pickup delay
                newEntity.setInvulnerable(true);
                newEntity.setVelocity(itemEntity.getVelocity());
                newEntity.setPickupDelay(40);

                // Remove old entity and spawn new one
                itemEntity.discard();
                world.spawnEntity(newEntity);

                // Optional: Play transformation effect
                world.playSound(null, itemEntity.getBlockPos(),
                        SoundEvents.PARTICLE_SOUL_ESCAPE.value(),
                        net.minecraft.sound.SoundCategory.WEATHER,
                        0.5F, 1.0F);

                world.spawnParticles(ModParticles.GLITCH_PARTICLE, itemEntity.getX(), itemEntity.getY(), itemEntity.getZ(), 5, 0.125, 0.125, 0.125, 1);
            }
        });
    }

    // Transformation mapping class
    private static class TransformationMap {
        private final java.util.Map<Item, Item> map = new java.util.HashMap<>();

        public void addTransformation(Item original, Item transformed) {
            map.put(original, transformed);
        }

        public Item getTransformedItem(Item original) {
            return map.get(original);
        }
    }
}