package gus.scpua.util.handlers;

import gus.scpua.util.Reference;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class SoundsHandler {
    public static SoundsHandler instance;

    public SoundsHandler() {
        instance = this;
        //SCP's
        registerSound("001-prototype-shriek");

        registerSound("035-idle1");
        registerSound("035-idle2");
        registerSound("035-idle3");
        registerSound("035-idle4");
        registerSound("035-kill");
        registerSound("035-use");

        registerSound("049-breathing");
        registerSound("049-chase");
        registerSound("049-cure1");
        registerSound("049-cure2");
        registerSound("049-idle");
        registerSound("049-resist");
        registerSound("049-spot");

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

        registerSound("999-death");
        registerSound("999-hit");
        registerSound("999-idle");
    }

    private SoundEvent registerSound(String name) {
        ResourceLocation location = new ResourceLocation(Reference.MODID, name);
        SoundEvent event = new SoundEvent(location);
        event.setRegistryName(location);
        ForgeRegistries.SOUND_EVENTS.register(event);
        return event;
    }
}