package gus.scpua.util.handlers;

import gus.scpua.util.Reference;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class SoundsHandler {
    public static SoundsHandler instance;
    private SoundEvent CHECKPOINT_OPEN, CHECKPOINT_SIREN, ELEVATOR_DING, TESLA_IDLE, TESLA_POWERUP, TESLA_SHOCK, TESLA_WINDUP;
    
    public SoundsHandler()  {
    instance = this;
        CHECKPOINT_OPEN = registerSound("checkpointopen");
        CHECKPOINT_SIREN = registerSound("checkpointsiren");
        ELEVATOR_DING = registerSound("elevatording");
        TESLA_IDLE = registerSound("teslaidle");
        TESLA_POWERUP = registerSound("teslapowerup");
        TESLA_SHOCK = registerSound("teslashock");
        TESLA_WINDUP = registerSound("teslawindup");
    }
    
    private SoundEvent registerSound(String name) {
        ResourceLocation location = new ResourceLocation(Reference.MODID, name);
        SoundEvent event = new SoundEvent(location);
        event.setRegistryName(location);
        ForgeRegistries.SOUND_EVENTS.register(event);
        return event;
     }
}