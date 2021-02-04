package gus.overtime.util.handlers;

import com.google.common.collect.Ordering;
import gus.overtime.init.BlockInit;
import gus.overtime.init.EntityInit;
import gus.overtime.init.ItemInit;
import gus.overtime.Overtime;
import gus.overtime.init.SCPs;
import gus.overtime.tileentity.AlbedoCL;
import gus.overtime.tileentity.NoAlbedoCL;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static gus.overtime.tabs.XKCreativeTab.tabSorter;

@EventBusSubscriber
public class XKRegistryHandler {

    @SubscribeEvent
    public static void onBlockRegister(RegistryEvent.Register<Block> event) {
        BlockInit.init(event);
    }

    @SubscribeEvent
    public static void onItemRegister(RegistryEvent.Register<Item> event) {
        ItemInit.init(event);
        tabSorter = Ordering.explicit(ItemInit.ITEMS).onResultOf(ItemStack::getItem);
    }

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public static void onModelRegister(ModelRegistryEvent event) {
        XKRenderHandler.registerEntityRenders();

        for (Item item : ItemInit.ITEMS) ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
        for (Block block : BlockInit.BLOCKS) ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(Item.getItemFromBlock(block).getRegistryName(), "inventory"));
    }

    public static void preInitRegistries(FMLPreInitializationEvent event) {
        XKConfigHandler.registerConfig(event);
        EntityInit.registerEntities();
        //new SCPs();
        //TODO Possible init with main blocks
        GameRegistry.registerTileEntity(AlbedoCL.class, new ResourceLocation(Overtime.MODID, "tilealbedo"));
        GameRegistry.registerTileEntity(NoAlbedoCL.class, new ResourceLocation(Overtime.MODID, "tilenoalbedo"));

        //Things like event listner classes should go here after these
        //MinecraftForge.EVENT_BUS.register(new XKEventHandler());
    }

    public static void initRegistries(FMLInitializationEvent event) {
        new XKSoundHandler();
    }

    public static void postInitRegistries(FMLPostInitializationEvent event) {
    }
}