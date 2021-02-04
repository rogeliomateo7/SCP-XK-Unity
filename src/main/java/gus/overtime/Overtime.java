package gus.overtime;

import connortron.soundmoverslib.sound.packets.SyncSounds;
import gus.overtime.proxy.CommonProxy;
import gus.overtime.tabs.XKCreativeTab;
import gus.overtime.util.handlers.XKRegistryHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

@Mod(modid = Overtime.MODID, name = Overtime.NAME, version = Overtime.VERSION, acceptedMinecraftVersions = "[1.12.2]", dependencies = "after:albedo@[0.1,)")
public class Overtime {
    public static final String MODID = "overtime";
    public static final String NAME = "SCP:Overtime";
    public static final String VERSION = "@VERSION@";

    //Libs GECKO Unused for now
    public static boolean ALBEDO, GECKO;

    public static File config;

    public static final Logger LOG = LogManager.getLogger(NAME);

    @Mod.Instance
    public static Overtime instance;

    public static SimpleNetworkWrapper SimpleNetworkWrapper = new SimpleNetworkWrapper(MODID);

    //Creative Tabs
    public static final CreativeTabs TAB_OVERTIME = new XKCreativeTab("overtime", 1); //Main Tab
    public static final CreativeTabs TAB_TOOLS = new XKCreativeTab("tools", 2); //Tools Tab
    public static final CreativeTabs TAB_COSMETICS = new XKCreativeTab("cosmetics", 3); //Cosmetics
    public static final CreativeTabs TAB_SITE93 = new XKCreativeTab("site93", 4); //Site-93
    public static final CreativeTabs TAB_SITE78 = new XKCreativeTab("site78", 5); //Site-78

    //Proxy
    @SidedProxy(clientSide = "gus.overtime.proxy.ClientProxy", serverSide = "gus.overtime.proxy.CommonProxy")
    public static CommonProxy proxy;

    //PreInit
    @Mod.EventHandler
    public static void preInit(FMLPreInitializationEvent event) {
        ALBEDO = Loader.isModLoaded("albedo");
        //GECKO = Loader.isModLoaded("geckolib");
        XKRegistryHandler.preInitRegistries(event);
        proxy.preInit();

        //TODO Remove this to make separate mod
        SimpleNetworkWrapper.registerMessage(SyncSounds.Handler.class, SyncSounds.class, 0, Side.CLIENT);
    }

    //Init
    @Mod.EventHandler
    public static void init(FMLInitializationEvent event) {
        XKRegistryHandler.initRegistries(event);
        proxy.init();
    }

    //PostInit
    @Mod.EventHandler
    public static void postInit(FMLPostInitializationEvent event) {
        XKRegistryHandler.postInitRegistries(event);
        proxy.postInit();
    }
}