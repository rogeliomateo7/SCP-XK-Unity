package connortron.soundmoverslib.sound.server;

import net.minecraft.entity.Entity;
import net.minecraft.util.ITickable;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;

public class ServerController implements ITickable {

    protected boolean donePlaying;
    protected Entity entity;

    protected SoundCategory category;
    protected ResourceLocation positionedSoundLocation;
    protected float volume;
    protected float pitch;
    protected boolean repeat;
    protected int repeatDelay;

    @Override
    public void update() {
        //TODO Sync Client with server and vise versa
    }
}
