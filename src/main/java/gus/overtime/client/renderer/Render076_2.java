package gus.overtime.client.renderer;

import gus.overtime.Overtime;
import gus.overtime.client.models.Model049;
import gus.overtime.entity.scp.EntitySCP076_2;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

@SideOnly(Side.CLIENT)
public class Render076_2 extends RenderBiped<EntitySCP076_2> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(Overtime.MODID + ":textures/entity/076-2.png");

    public Render076_2(RenderManager manager) {
        super(manager, new ModelBiped(), 0.5f);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntitySCP076_2 entity) {
        return TEXTURE;
    }
}
