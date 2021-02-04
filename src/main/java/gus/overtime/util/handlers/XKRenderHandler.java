package gus.overtime.util.handlers;

import gus.overtime.client.renderer.Render076_2;
import gus.overtime.entity.scp.EntitySCP049;
import gus.overtime.client.renderer.Render049;
import gus.overtime.entity.scp.EntitySCP076_2;
import gus.overtime.entity.scp.EntitySCP999;
import gus.overtime.client.renderer.Render999;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class XKRenderHandler {

    //TODO Possible Merge with Reg handler
    public static void registerEntityRenders() {
        RenderingRegistry.registerEntityRenderingHandler(EntitySCP049.class, Render049::new);
        RenderingRegistry.registerEntityRenderingHandler(EntitySCP999.class, Render999::new);
        RenderingRegistry.registerEntityRenderingHandler(EntitySCP076_2.class, Render076_2::new);
    }
}
