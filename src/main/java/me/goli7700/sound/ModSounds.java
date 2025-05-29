package me.goli7700.sound;

import me.goli7700.LeafModAlpha;
import net.minecraft.block.jukebox.JukeboxSong;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {
    public static final SoundEvent NULL = registerSoundEvent("null");
    public static final RegistryKey<JukeboxSong> NULL_KEY =
            RegistryKey.of(RegistryKeys.JUKEBOX_SONG, Identifier.of(LeafModAlpha.MOD_ID, "null"));
    public static final SoundEvent SINKING_DUNES = registerSoundEvent("sinking_dunes");
    public static final RegistryKey<JukeboxSong> SINKING_DUNES_KEY =
            RegistryKey.of(RegistryKeys.JUKEBOX_SONG, Identifier.of(LeafModAlpha.MOD_ID, "sinking_dunes"));

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = Identifier.of(LeafModAlpha.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

}
