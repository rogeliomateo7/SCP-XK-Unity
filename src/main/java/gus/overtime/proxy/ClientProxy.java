package gus.overtime.proxy;

import gus.overtime.client.InputHandler;
import net.minecraftforge.common.MinecraftForge;

public class ClientProxy extends CommonProxy {

    @Override
    public void preInit() {
        super.preInit();

        MinecraftForge.EVENT_BUS.register(new InputHandler());
    }

    @Override
    public void init() {
        super.init();
    }

    @Override
    public void postInit() {
        super.postInit();
    }
}
