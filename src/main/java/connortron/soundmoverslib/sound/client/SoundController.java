package connortron.soundmoverslib.sound.client;

import net.minecraft.client.audio.MovingSound;
import net.minecraft.entity.Entity;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * This class is used for playing a repeated sound at an entity Unless...
 * reset is false, the stop() function is used, or the entity dies
 */
@SideOnly(Side.CLIENT)
public class SoundController extends MovingSound {

    /**
     * Used to track the Entity
     */
    private final Entity entity;

    /**
     * Full control over the Event
     * @param entity Defines what entity to move with
     * @param event What sound should be played
     * @param category What category should the sound be played in
     * @param volume How loud it will be
     * @param shouldRepeat Should it play once
     * @param repeatDelay How long apart from the repeat
     */
    public SoundController(Entity entity, SoundEvent event, SoundCategory category, float volume, boolean shouldRepeat, int repeatDelay) {
        super(event, category);
        this.entity = entity;
        this.volume = volume;
        this.repeat = shouldRepeat;
        this.repeatDelay = repeatDelay;
    }

    /**
     * Using this method has almost all control however,
     * repeatDelay is set to 0
     * @param entity Defines what entity to move with
     * @param event What sound should be played
     * @param category What category should the sound be played in
     * @param volume How loud it will be
     * @param shouldRepeat Should it play once
     */
    public SoundController(Entity entity, SoundEvent event, SoundCategory category, float volume, boolean shouldRepeat) {
        this(entity, event, category, volume, shouldRepeat, 0);
    }

    /**
     * Using this method has no control over how loud the sound is,
     * however can define if it should repeat
     * @param entity Defines what entity to move with
     * @param event What sound should be played
     * @param category What category should the sound be played in
     * @param shouldRepeat Should it play once
     */
    public SoundController(Entity entity, SoundEvent event, SoundCategory category, boolean shouldRepeat) {
        this(entity, event, category, 1, shouldRepeat, 0);
    }

    /**
     * Using this method sets repeat to true by default
     *
     * @param entity Defines what entity to move with
     * @param event What sound should be played
     * @param category What category should the sound be played in
     * @param volume How loud it will be
     */
    public SoundController(Entity entity, SoundEvent event, SoundCategory category, float volume) {
        this(entity, event, category, volume, true, 0);
    }

    /**
     * Using this method sets repeat to true by default and volume to 1F
     *
     * @param entity Defines what entity to move with
     * @param event What sound should be played
     * @param category What category should the sound be played in
     */
    public SoundController(Entity entity, SoundEvent event, SoundCategory category) {
        this(entity, event, category, 1, true, 0);
    }

    public void stop() {
        this.donePlaying = true;
    }

    public void setVolume(float volume) {
        this.volume = volume;
    }

    @Override
    public void update() {
        if (this.entity.isDead) {
            this.donePlaying = true;
        } else {
            this.xPosF = (float)this.entity.posX;
            this.yPosF = (float)this.entity.posY;
            this.zPosF = (float)this.entity.posZ;
        }
    }
}
