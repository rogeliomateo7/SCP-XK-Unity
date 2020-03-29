package gus.scpua.util.handlers;

import gus.scpua.entity.living.scp.scp049.EntitySCP049;
import gus.scpua.entity.living.scp.scp049.Render049;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class XKRenderHandler {

    public static void registerEntityRenders() {
        RenderingRegistry.registerEntityRenderingHandler(EntitySCP049.class, new IRenderFactory<EntitySCP049>() {
            @Override
            public Render<? super EntitySCP049> createRenderFor(RenderManager manager) {
                return new Render049(manager);
            }
        });
    }
}
