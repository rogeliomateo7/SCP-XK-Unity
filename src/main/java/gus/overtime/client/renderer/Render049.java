package gus.overtime.client.renderer;

import gus.overtime.client.models.Model049;
import gus.overtime.Overtime;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

@SideOnly(Side.CLIENT)
public class Render049 extends RenderLivingBase {
    public static final ResourceLocation TEXTURE = new ResourceLocation(Overtime.MODID + ":textures/entity/049.png");

    public Render049(RenderManager manager) {
        super(manager, new Model049(), 0.5f);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(Entity entity) {
        return TEXTURE;
    }
}
