package gus.scpua.entity.living.scp.scp049;

import gus.scpua.util.handlers.XKSoundHandler;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class EntitySCP049 extends EntityMob {

    public EntitySCP049(World worldIn) {
        super(worldIn);
        this.setSize(width, height);
    }

    @Override
    protected void initEntityAI() {
        this.tasks.addTask(1, new EntityAINearestAttackableTarget<>(this, EntityPlayerMP.class, true, true));
        this.tasks.addTask(2, new EntityAISwimming(this));
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(15);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.2001D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(1000000000);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(10.0D);
    }

    @Override
    protected SoundEvent getDeathSound() {
        return XKSoundHandler.SCP049_BREATHING;
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return XKSoundHandler.SCP049_IDLE;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return XKSoundHandler.SCP049_RESIST;
    }
}
