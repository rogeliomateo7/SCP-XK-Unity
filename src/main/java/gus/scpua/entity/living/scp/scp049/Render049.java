package gus.scpua.entity.living.scp.scp049;

import gus.scpua.util.Reference;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class Render049 extends RenderLiving<EntitySCP049> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MODID + ":textures/entity/049.png");

    public Render049(RenderManager manager) {
        super(manager, new Model049(), 0.5f);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntitySCP049 entity) {
        return TEXTURE;
    }
}
