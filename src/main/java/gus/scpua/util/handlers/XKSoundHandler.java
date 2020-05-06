package gus.scpua.util.handlers;

import gus.scpua.scpua;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class XKSoundHandler {
    public static XKSoundHandler instance;

    public static SoundEvent MEDKIT, HLMEDKIT;

    public static SoundEvent SCP015_STEAM;
    public static SoundEvent SCP049_BREATHING, SCP049_CHASE, SCP049_CURE1, SCP049_CURE2, SCP049_IDLE, SCP049_RESIST, SCP049_SPOT;
    public static SoundEvent SCP999_DEATH, SCP999_IDLE, SCP999_HURT;

    public XKSoundHandler() {
        instance = this;
        //Items
        MEDKIT = registerSound("medkit");
        HLMEDKIT = registerSound("hlmedkit");


        //SCP's
        registerSound("001-prototype-shriek");

        SCP015_STEAM = registerSound("015-steam");

        registerSound("035-idle1");
        registerSound("035-idle2");
        registerSound("035-idle3");
        registerSound("035-idle4");
        registerSound("035-kill");
        registerSound("035-use");

        SCP049_BREATHING = registerSound("049-breathing");
        SCP049_CHASE = registerSound("049-chase");
        SCP049_CURE1 = registerSound("049-cure1");
        SCP049_CURE2 = registerSound("049-cure2");
        SCP049_IDLE = registerSound("049-idle");
        SCP049_RESIST = registerSound("049-resist");
        SCP049_SPOT = registerSound("049-spot");

        registerSound("058-heartbeat");
        registerSound("058-voice1");
        registerSound("058-voice2");
        registerSound("058-voice3");
        registerSound("058-voice4");
        registerSound("058-voice5");

        registerSound("079-intercom1");
        registerSound("079-intercom2");
        registerSound("079-intercom3");
        registerSound("079-intercom4");
        registerSound("079-intercom5");
        registerSound("079-intercom6");

        registerSound("106-breathing");
        registerSound("106-laugh");

        registerSound("173-rattle1");
        registerSound("173-rattle2");
        registerSound("173-rattle3");
        registerSound("173-snapneck1");
        registerSound("173-snapneck2");
        registerSound("173-snapneck3");

        registerSound("372-movement");

        registerSound("457-voice1");
        registerSound("457-voice2");
        registerSound("457-voice3");
        registerSound("457-voice4");

        registerSound("745-death");
        registerSound("745-hurt");
        registerSound("745-idle");

        registerSound("939-death");
        registerSound("939-found1");
        registerSound("939-found2");
        registerSound("939-found3");
        registerSound("939-hurt");
        registerSound("939-lure1");
        registerSound("939-lure2");
        registerSound("939-lure3");
        registerSound("939-lure4");
        registerSound("939-lure5");
        registerSound("939-lure6");
        registerSound("939-lure7");
        registerSound("939-lure8");
        registerSound("939-lure9");

        SCP999_DEATH = registerSound("999-death");
        SCP999_HURT = registerSound("999-hurt");
        SCP999_IDLE = registerSound("999-idle");
    }

    private SoundEvent registerSound(String name) {
        ResourceLocation location = new ResourceLocation(scpua.MODID, name);
        SoundEvent event = new SoundEvent(location);
        event.setRegistryName(location);
        ForgeRegistries.SOUND_EVENTS.register(event);
        return event;
    }
}