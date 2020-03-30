package gus.scpua.entity.living.scp.scp049;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class Model049 extends ModelBase {
    ModelRenderer Head;
    ModelRenderer Beak1;
    ModelRenderer Beak2;
    ModelRenderer Tunic;
    ModelRenderer Neck;
    ModelRenderer Mask;
    ModelRenderer Body;
    ModelRenderer TunicBody;
    ModelRenderer RArm;
    ModelRenderer RTunicArm;
    ModelRenderer Knife;
    ModelRenderer LArm;
    ModelRenderer LTunicArm;
    ModelRenderer RLeg;
    ModelRenderer LLeg;

    public Model049() {
        textureWidth = 90;
        textureHeight = 90;

        Head = new ModelRenderer(this);
        Head.setRotationPoint(0.0F, -0.7F, 0.0F);
        Head.cubeList.add(new ModelBox(Head, 0, 0, -4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F, false));

        Beak1 = new ModelRenderer(this);
        Beak1.setRotationPoint(0.0F, -2.1F, -2.5F);
        setRotationAngle(Beak1, 0.1367F, -0.1367F, 0.7854F);
        Head.addChild(Beak1);
        Beak1.cubeList.add(new ModelBox(Beak1, 33, 0, -1.5F, -1.5F, -6.0F, 3, 3, 5, 0.0F, false));

        Beak2 = new ModelRenderer(this);
        Beak2.setRotationPoint(0.0F, 0.1F, -4.7F);
        setRotationAngle(Beak2, 0.1367F, -0.1367F, 0.0F);
        Beak1.addChild(Beak2);
        Beak2.cubeList.add(new ModelBox(Beak2, 36, 10, -1.0F, -1.0F, -4.0F, 2, 2, 3, 0.0F, false));

        Tunic = new ModelRenderer(this);
        Tunic.setRotationPoint(0.0F, -0.8F, 0.0F);
        Head.addChild(Tunic);
        Tunic.cubeList.add(new ModelBox(Tunic, 0, 16, -4.5F, -8.0F, -4.5F, 9, 10, 9, 0.0F, false));

        Neck = new ModelRenderer(this);
        Neck.setRotationPoint(0.0F, -1.1F, 0.0F);
        Head.addChild(Neck);
        Neck.cubeList.add(new ModelBox(Neck, 0, 0, -1.0F, 0.0F, -1.0F, 2, 2, 2, 0.0F, false));

        Mask = new ModelRenderer(this);
        Mask.setRotationPoint(0.0F, -4.0F, -4.6F);
        Head.addChild(Mask);
        Mask.cubeList.add(new ModelBox(Mask, 24, 66, -4.0F, -3.0F, 0.0F, 8, 6, 1, 0.0F, false));

        Body = new ModelRenderer(this);
        Body.setRotationPoint(0.0F, 6.0F, 0.0F);
        Body.cubeList.add(new ModelBox(Body, 40, 20, -4.0F, -6.0F, -2.0F, 8, 12, 4, 0.0F, false));

        TunicBody = new ModelRenderer(this);
        TunicBody.setRotationPoint(0.0F, -2.1F, 0.0F);
        Body.addChild(TunicBody);
        TunicBody.cubeList.add(new ModelBox(TunicBody, 46, 71, -4.5F, -4.0F, -2.5F, 9, 8, 5, 0.0F, false));

        RArm = new ModelRenderer(this);
        RArm.setRotationPoint(4.0F, 2.0F, 0.0F);
        RArm.cubeList.add(new ModelBox(RArm, 19, 46, 0.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F, false));

        RTunicArm = new ModelRenderer(this);
        RTunicArm.setRotationPoint(2.0F, -2.1F, 0.0F);
        RArm.addChild(RTunicArm);
        RTunicArm.cubeList.add(new ModelBox(RTunicArm, 24, 76, -2.5F, 0.0F, -2.5F, 5, 7, 5, 0.0F, false));

        Knife = new ModelRenderer(this);
        Knife.setRotationPoint(1.9F, 9.0F, -0.7F);
        setRotationAngle(Knife, 0.0F, 1.5708F, 0.0F);
        RArm.addChild(Knife);
        Knife.cubeList.add(new ModelBox(Knife, 1, 69, 0.0F, -1.0F, 0.0F, 10, 2, 0, 0.0F, false));

        LArm = new ModelRenderer(this);
        LArm.setRotationPoint(-4.0F, 2.0F, 0.0F);
        LArm.cubeList.add(new ModelBox(LArm, 0, 46, -4.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F, false));

        LTunicArm = new ModelRenderer(this);
        LTunicArm.setRotationPoint(-2.0F, -2.3F, 0.0F);
        LArm.addChild(LTunicArm);
        LTunicArm.cubeList.add(new ModelBox(LTunicArm, 2, 74, -2.5F, 0.0F, -2.5F, 5, 9, 5, 0.0F, false));

        RLeg = new ModelRenderer(this);
        RLeg.setRotationPoint(2.0F, 12.0F, 0.0F);
        RLeg.cubeList.add(new ModelBox(RLeg, 59, 46, -2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F, false));

        LLeg = new ModelRenderer(this);
        LLeg.setRotationPoint(-2.0F, 12.0F, 0.0F);
        LLeg.cubeList.add(new ModelBox(LLeg, 40, 46, -2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F, false));
    }
/*
    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        Head.render(f5);
        Body.render(f5);
        RArm.render(f5);
        LArm.render(f5);
        RLeg.render(f5);
        LLeg.render(f5);
    }

 */

    private void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.LLeg.rotateAngleX = MathHelper.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
        this.Head.rotateAngleY = ageInTicks / (180F / (float) Math.PI);
        this.Head.rotateAngleX = netHeadYaw / (180F / (float) Math.PI);
        this.RArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
        this.LArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * limbSwingAmount;
        this.RLeg.rotateAngleX = MathHelper.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;

    }
}
