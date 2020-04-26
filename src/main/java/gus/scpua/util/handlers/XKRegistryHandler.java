package gus.scpua.util.handlers;

import gus.scpua.init.BlockInit;
import gus.scpua.init.EntityInit;
import gus.scpua.init.ItemInit;
import gus.scpua.scpua;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
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
        event.getRegistry().registerAll(BlockInit.BLOCKS.toArray(new Block[0]));
    }

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public static void onModelRegister(ModelRegistryEvent event) {
        XKRenderHandler.registerEntityRenders();
        for (Item item : ItemInit.ITEMS) {
            scpua.proxy.registerItemRenderer(item, 0 ,"inventory");
        }

        for (Block block : BlockInit.BLOCKS) {
            scpua.proxy.registerItemRenderer(Item.getItemFromBlock(block), 0, "inventory");
        }
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

    @SubscribeEvent
    public static void remapBlocks(RegistryEvent.MissingMappings<Block> event) {
        for (RegistryEvent.MissingMappings.Mapping<Block> miss : event.getAllMappings()) {
            String block = miss.key.toString();

            System.out.println("FUCK " + block);

            if (block.equals("scpua:testblock")) {
                miss.remap(BlockInit.BARRELA);
            }
        }
    }

}