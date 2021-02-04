package connortron.soundmoverslib.sound;

import connortron.soundmoverslib.sound.client.SoundManager;
import net.minecraft.entity.Entity;

import java.util.HashMap;
import java.util.Map;

public class SoundCollection {
    public static Map<Integer, SoundManager> collection = new HashMap<>();

    /**
     * Puts Sound manager into collection for getting
     */
    public static void addSoundManager(Entity entity, SoundManager manager) {
        try {
            collection.put(entity.getEntityId(), manager);
        } catch (NullPointerException ignored) {}
    }

    /**
     * Used to get sound manager from Entity ID
     * @return Entity's SoundManager
     */
    public static SoundManager getSoundManager(Entity entity) {
        try {
            return collection.get(entity.getEntityId());
        } catch (NullPointerException ignored) {}
        return null;
    }

    /**
     * Removes sound manager from collection list
     */
    public static void removeSoundManager(Entity entity) {
        try {
            collection.remove(entity.getEntityId());
        } catch (Exception ignored) {}
    }
}
