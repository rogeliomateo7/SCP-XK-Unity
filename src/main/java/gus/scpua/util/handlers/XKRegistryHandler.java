package gus.scpua.util.handlers;

import gus.scpua.init.EntityInit;
import gus.scpua.init.ItemInit;
import gus.scpua.init.blocks.Cosmetics;
import gus.scpua.init.blocks.Site78;
import gus.scpua.init.blocks.Site93;
import gus.scpua.init.blocks.XKUnity;
import gus.scpua.scpua;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@EventBusSubscriber
public class XKRegistryHandler {
    //Item Register
    @SubscribeEvent
    public static void onItemRegister(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(ItemInit.ITEMS.toArray(new Item[0]));
    }

    //Block Register
    @SubscribeEvent
    public static void onBlockRegister(RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(Cosmetics.COSMETICBLOCKS.toArray(new Block[0]));
        event.getRegistry().registerAll(Site78.S78BLOCKS.toArray(new Block[0]));
        event.getRegistry().registerAll(Site93.S93BLOCKS.toArray(new Block[0]));
        event.getRegistry().registerAll(XKUnity.XKUNITYBLOCKS.toArray(new Block[0]));
    }

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public static void onModelRegister(ModelRegistryEvent event) {
        XKRenderHandler.registerEntityRenders();
        for (Item item : ItemInit.ITEMS) {
            scpua.proxy.registerItemRenderer(item, 0 ,"inventory");
        }

        for (Block block : Cosmetics.COSMETICBLOCKS) { scpua.proxy.registerItemRenderer(Item.getItemFromBlock(block), 0, "inventory"); }
        for (Block block : Site78.S78BLOCKS) { scpua.proxy.registerItemRenderer(Item.getItemFromBlock(block), 0, "inventory"); }
        for (Block block : Site93.S93BLOCKS) { scpua.proxy.registerItemRenderer(Item.getItemFromBlock(block), 0, "inventory"); }
        for (Block block : XKUnity.XKUNITYBLOCKS) { scpua.proxy.registerItemRenderer(Item.getItemFromBlock(block), 0, "inventory"); }
    }

    //preInit Registries
    public static void preInitRegistries(FMLPreInitializationEvent event) {
        XKConfigHandler.registerConfig(event);
        EntityInit.registerEntities();
    }

    //Init Registries
    public static void initRegistries(FMLInitializationEvent event) {
        new XKSoundHandler();
    }

    //PostInit Registries
    public static void postInitRegistries(FMLPostInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new XKEventHandler());
    }
}