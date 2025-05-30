package me.goli7700.particle;

import me.goli7700.LeafModAlpha;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModParticles {

    public static final SimpleParticleType GLITCH_PARTICLE =
            registerParticle("glitch", FabricParticleTypes.simple(true));

    private static SimpleParticleType registerParticle(String name, SimpleParticleType particleType) {
        return Registry.register(Registries.PARTICLE_TYPE, Identifier.of(LeafModAlpha.MOD_ID, name), particleType);
    }

    public static void registerModParticles() {
        LeafModAlpha.LOGGER.info("Registering Modded Particles from " + LeafModAlpha.MOD_ID);
    }
}
