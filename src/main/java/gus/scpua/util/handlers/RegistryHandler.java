package gus.scpua.util.handlers;

import gus.scpua.init.BlockInit;
import gus.scpua.init.ItemInit;
import gus.scpua.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class RegistryHandler {
    //Item Register
    @SubscribeEvent
    public static void onItemRegtister(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(ItemInit.ITEMS.toArray(new Item[0]));
    }

    //Block Register
    @SubscribeEvent
    public static void onBlockRegtister(RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(BlockInit.BLOCKS.toArray(new Block[0]));
    }

    @SubscribeEvent
    public static void onModelRegister(ModelRegistryEvent event) {
        for (Item item : ItemInit.ITEMS) {
            if (item instanceof IHasModel) {
                ((IHasModel) item).registerModels();
            }
        }

        for (Block block : BlockInit.BLOCKS) {
            if (block instanceof IHasModel) {
                ((IHasModel) block).registerModels();
            }
        }
    }

    //preInit Registries
    public static void preInitRegistries() {
    }

    //Init Registries
    public static void initRegistries() {
        new SoundsHandler();
    }

    //PostInit Registries
    public static void postInitRegistries() {
        MinecraftForge.EVENT_BUS.register(new ScpEventHandler());
    }

}
