package gus.overtime.entity.scp;

import gus.overtime.util.handlers.XKSoundHandler;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import javax.annotation.Nullable;

import static net.minecraft.block.BlockCarpet.COLOR;

public class EntitySCP049 extends EntityMob {

    public EntitySCP049(World worldIn) {
        super(worldIn);
        this.setSize(0.9F, 2F);
    }

    @Override
    protected void initEntityAI() {
        this.tasks.addTask(2, new EntityAIAttackMelee(this, 1, false));
        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget<>(this, EntityPlayer.class, true, true));
        this.tasks.addTask(2, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAIWanderAvoidWater(this, 1));
        this.tasks.addTask(7, new EntityAIOpenDoor(this, false));
    }

    @Override
    public boolean canAttackClass(Class<? extends EntityLivingBase> cls) {
        if (cls == EntityPig.class) return false;
        return super.canAttackClass(cls);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.32);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(10);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(10.0);
    }

    @Override
    protected SoundEvent getDeathSound() {
        return XKSoundHandler.SCP049_BREATHING;
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return XKSoundHandler.SCP049_BREATHING;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return XKSoundHandler.SCP049_RESIST;
    }
}
