package gus.scpua.entity.living.scp;

import gus.scpua.util.Reference;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntitySCP999 extends EntityCreature {

    public EntitySCP999(World worldIn) {
        super(worldIn);
        this.setSize(1F, 1F);
    }

    @Override
    protected void initEntityAI() {
        this.tasks.addTask(2, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAIWander(this, 1D));
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(15D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.2001D);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(10.0D);
    }

    /*
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
     */

    @SideOnly(Side.CLIENT)
    public static class Model999 extends ModelBase {
        public ModelRenderer Head;
        public ModelRenderer Reye;
        public ModelRenderer Leye;
        public ModelRenderer Goop1;
        public ModelRenderer Goop2;
        public ModelRenderer Goop3;
        public ModelRenderer LJoint;
        public ModelRenderer Pseudopod;
        public ModelRenderer RJoint;
        public ModelRenderer Pseudopod_1;
        public ModelRenderer Core;

        public Model999() {
            textureWidth = 64;
            textureHeight = 64;

            Head = new ModelRenderer(this);
            Head.setRotationPoint(0.0F, 14.3F, 0.0F);
            Head.cubeList.add(new ModelBox(Head, 0, 0, -4.0F, -1.0F, -4.0F, 8, 8, 8, 0.0F, false));

            Reye = new ModelRenderer(this);
            Reye.setRotationPoint(2.9F, -3.9F, -3.0F);
            setRotationAngle(Reye, 0.0F, 0.0F, 0.1367F);
            Head.addChild(Reye);
            Reye.cubeList.add(new ModelBox(Reye, 44, 25, -1.0913F, 1.472F, -1.5F, 3, 3, 3, 0.0F, false));

            Leye = new ModelRenderer(this);
            Leye.setRotationPoint(-2.9F, -3.9F, -3.0F);
            setRotationAngle(Leye, 0.0F, 0.0F, -0.1367F);
            Head.addChild(Leye);
            Leye.cubeList.add(new ModelBox(Leye, 44, 16, -1.9087F, 1.472F, -1.5F, 3, 3, 3, 0.0F, false));

            Goop1 = new ModelRenderer(this);
            Goop1.setRotationPoint(0.0F, 3.4F, 0.0F);
            Head.addChild(Goop1);
            Goop1.cubeList.add(new ModelBox(Goop1, 0, 16, -4.5F, 3.0F, -4.5F, 9, 1, 9, 0.0F, false));

            Goop2 = new ModelRenderer(this);
            Goop2.setRotationPoint(0.0F, -14.0F, 0.0F);
            Goop1.addChild(Goop2);
            Goop2.cubeList.add(new ModelBox(Goop2, 0, 26, -5.5F, 18.0F, -5.0F, 11, 1, 10, 0.0F, false));

            Goop3 = new ModelRenderer(this);
            Goop3.setRotationPoint(0.0F, -3.1F, 0.4F);
            Goop2.addChild(Goop3);
            Goop3.cubeList.add(new ModelBox(Goop3, 0, 37, -6.5F, 22.0F, -6.0F, 13, 1, 12, 0.0F, false));

            LJoint = new ModelRenderer(this);
            LJoint.setRotationPoint(-3.4F, 14.5F, 0.0F);
            LJoint.cubeList.add(new ModelBox(LJoint, 0, 0, -0.5F, 2.5F, -0.5F, 1, 1, 1, 0.0F, false));

            Pseudopod = new ModelRenderer(this);
            Pseudopod.setRotationPoint(0.0F, 0.0F, 0.0F);
            setRotationAngle(Pseudopod, 0.0F, 0.0F, 0.8196F);
            LJoint.addChild(Pseudopod);
            Pseudopod.cubeList.add(new ModelBox(Pseudopod, 0, 52, 1.1926F, 2.0475F, -1.0F, 2, 3, 2, 0.0F, false));

            RJoint = new ModelRenderer(this);
            RJoint.setRotationPoint(3.4F, 14.5F, 0.0F);
            RJoint.cubeList.add(new ModelBox(RJoint, 0, 0, -0.5F, 2.5F, -0.5F, 1, 1, 1, 0.0F, false));

            Pseudopod_1 = new ModelRenderer(this);
            Pseudopod_1.setRotationPoint(0.0F, 0.0F, 0.0F);
            setRotationAngle(Pseudopod_1, 0.0F, 0.0F, -0.8196F);
            RJoint.addChild(Pseudopod_1);
            Pseudopod_1.cubeList.add(new ModelBox(Pseudopod_1, 11, 52, -3.1926F, 2.0475F, -1.0F, 2, 3, 2, 0.0F, false));

            Core = new ModelRenderer(this);
            Core.setRotationPoint(0.0F, 14.3F, 0.0F);
            Core.cubeList.add(new ModelBox(Core, 34, 1, -3.5F, -0.5F, -3.5F, 7, 7, 7, 0.0F, false));
        }

        @Override
        public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
            Head.render(f5);
            LJoint.render(f5);
            RJoint.render(f5);
            Core.render(f5);
        }
        public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
            modelRenderer.rotateAngleX = x;
            modelRenderer.rotateAngleY = y;
            modelRenderer.rotateAngleZ = z;
        }
    }

    @SideOnly(Side.CLIENT)
    public static class Render999 extends RenderLiving<EntitySCP999> {
        public static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MODID + ":textures/999.png");

        public Render999(RenderManager manager) {
            super(manager, new Model999(), 0.5f);
        }

        @Override
        protected ResourceLocation getEntityTexture(EntitySCP999 entity) {
            return TEXTURE;
        }
    }
}
