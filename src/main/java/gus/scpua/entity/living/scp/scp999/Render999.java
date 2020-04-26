package gus.scpua.entity.living.scp.scp999;

import gus.scpua.util.Reference;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class Render999 extends RenderLiving<EntitySCP999> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MODID + ":textures/999.png");

    public Render999(RenderManager manager) {
        super(manager, new Model999(), 0.5f);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntitySCP999 entity) {
        return TEXTURE;
    }
}
