package connortron.soundmoverslib.sound.client;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static connortron.soundmoverslib.sound.SoundCollection.addSoundManager;

public class SoundManager {

    //FIXME Entity not spawnable on server side due to this
    @SideOnly(Side.CLIENT)
    private SoundController controller;

    /**
     * This is used to manage sounds, this acts as the master since individual controller creations is a pain
     */
    public SoundManager(Entity entity) {
        addSoundManager(entity, this);
    }

    /**
     * Stops any sounds playing on the old controller and places a new one int its way
     * @param controller New creation of a controller.
     */
    public void add(SoundController controller) {
        try {
            Minecraft.getMinecraft().getSoundHandler().stopSound(this.controller);
        } catch (Exception ignored) {}
        this.controller = controller;
        Minecraft.getMinecraft().getSoundHandler().playSound(controller);
    }

    /**
     * Stops any current playing controllers and removes them
     */
    public void stop() {
        controller.stop();
    }
}
