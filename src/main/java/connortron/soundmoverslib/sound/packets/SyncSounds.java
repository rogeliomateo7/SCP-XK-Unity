package connortron.soundmoverslib.sound.packets;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class SyncSounds implements IMessage {

    protected boolean donePlaying;
    protected int entityID;
    protected String uniqueID;

    protected String soundEvent;
    protected String category;
    protected float volume;
    protected float pitch;
    protected boolean repeat;
    protected int repeatDelay;


    public SyncSounds() {
    }

    /**
     * Used to sync Up a sound
     */
    public SyncSounds(Entity entity, SoundEvent event, SoundCategory category, float volume, float pitch, boolean repeat, int repeatDelay) {
        this.entityID = entity.getEntityId();
        this.uniqueID = entity.getUniqueID().toString();

        this.soundEvent = event.getSoundName().getResourcePath();
        this.category = category.getName();
        this.volume = volume;
        this.pitch = pitch;
        this.repeat = repeat;
        this.repeatDelay = repeatDelay;
        this.donePlaying = false;
    }

    /**
     * Used to stop the sound on the entity
     */
    public SyncSounds(Entity entity, boolean donePlaying) {
        this.donePlaying = donePlaying;
        this.entityID = entity.getEntityId();
        this.uniqueID = entity.getUniqueID().toString();
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        donePlaying = buf.readBoolean();
        entityID = buf.readInt();
        uniqueID = ByteBufUtils.readUTF8String(buf);
        soundEvent = ByteBufUtils.readUTF8String(buf);
        category = ByteBufUtils.readUTF8String(buf);
        volume = buf.readFloat();
        pitch = buf.readFloat();
        repeat = buf.readBoolean();
        repeatDelay = buf.readInt();
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeBoolean(donePlaying);
        buf.writeInt(entityID);
        ByteBufUtils.writeUTF8String(buf, uniqueID);
        ByteBufUtils.writeUTF8String(buf, soundEvent);
        ByteBufUtils.writeUTF8String(buf, category);
        buf.writeFloat(volume);
        buf.writeFloat(pitch);
        buf.writeBoolean(repeat);
        buf.writeInt(repeatDelay);
    }

    public static class Handler implements IMessageHandler<SyncSounds, IMessage> {

        @Override
        public IMessage onMessage(SyncSounds message, MessageContext messageContext) {
            Minecraft mc = Minecraft.getMinecraft();
            mc.addScheduledTask(() -> {

                //new SoundController(mc.world.getEntityByID(message.entityID), )

                //TODO Do things
                // Create new Sound controller instance with entity

                //Entity entity = mc.world.getEntityByID(message.entityID);
                //if (entity.)
            });

            return null;
        }
    }
}
