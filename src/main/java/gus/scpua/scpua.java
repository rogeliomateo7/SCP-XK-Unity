package gus.scpua;

import gus.scpua.proxy.CommonProxy;
import gus.scpua.tabs.Tabs;
import gus.scpua.util.handlers.XKRegistryHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.io.File;

@Mod(modid = scpua.MODID, name = scpua.NAME, version = scpua.VERSION, acceptedMinecraftVersions = "[1.12.2]")
public class scpua {
    public static final String MODID = "scpua";
    public static final String NAME = "SCP lockdown XK Unity addon";
    public static final String VERSION = "@VERSION@";

    public static File config;

    @Mod.Instance
    public static scpua instance;

    //Creative Tabs
    public static final CreativeTabs tabxkunitytab = new Tabs("tabxkunitytab", 1); //Main Tab
    public static final CreativeTabs tabweaponsscp = new Tabs("tabweaponsscp", 2); //Tools Tab
    public static final CreativeTabs tabxkunitycosmetics = new Tabs("tabxkunitycosmetics", 3); //Cosmetics
    public static final CreativeTabs tabsite93 = new Tabs("tabsite93", 4); //Site-93
    public static final CreativeTabs tabsite78 = new Tabs("tabsite78", 5); //Site-78

    //Proxy
    @SidedProxy(clientSide = "gus.scpua.proxy.ClientProxy", serverSide = "gus.scpua.proxy.CommonProxy")
    public static CommonProxy proxy;

    //PreInit
    @Mod.EventHandler
    public static void preInit(FMLPreInitializationEvent event) {
        XKRegistryHandler.preInitRegistries(event);
    }

    //Init
    @Mod.EventHandler
    public static void init(FMLInitializationEvent event) {
        XKRegistryHandler.initRegistries(event);
        proxy.clientInit();
    }

    //PostInit
    @Mod.EventHandler
    public static void postInit(FMLPostInitializationEvent event) {
        XKRegistryHandler.postInitRegistries(event);
    }
}