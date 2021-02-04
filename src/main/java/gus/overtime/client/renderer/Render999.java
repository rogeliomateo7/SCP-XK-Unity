package gus.overtime.client.renderer;

import gus.overtime.client.models.Model999;
import gus.overtime.entity.scp.EntitySCP999;
import gus.overtime.Overtime;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class Render999 extends RenderLiving<EntitySCP999> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(Overtime.MODID + ":textures/entity/999.png");

    public Render999(RenderManager manager) {
        super(manager, new Model999(), 0.5f);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntitySCP999 entity) {
        return TEXTURE;
    }
}
