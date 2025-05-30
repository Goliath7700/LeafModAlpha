package me.goli7700;

import me.goli7700.particle.GlitchParticle;
import me.goli7700.particle.ModParticles;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;

public class LeafModAlphaClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ParticleFactoryRegistry.getInstance().register(ModParticles.GLITCH_PARTICLE, GlitchParticle.Factory::new);
    }
}
