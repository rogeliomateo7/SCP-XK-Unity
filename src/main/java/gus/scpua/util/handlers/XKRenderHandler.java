package gus.scpua.util.handlers;

import gus.scpua.entity.living.scp.scp049.EntitySCP049;
import gus.scpua.entity.living.scp.scp049.Render049;
import gus.scpua.entity.living.scp.scp999.EntitySCP999;
import gus.scpua.entity.living.scp.scp999.Render999;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class XKRenderHandler {

    public static void registerEntityRenders() {
        RenderingRegistry.registerEntityRenderingHandler(EntitySCP049.class, Render049::new);

        RenderingRegistry.registerEntityRenderingHandler(EntitySCP999.class, Render999::new);
    }
}
