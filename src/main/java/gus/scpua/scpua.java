package gus.scpua;

import gus.scpua.proxy.CommonProxy;
import gus.scpua.tabs.Tabs;
import gus.scpua.util.Reference;
import gus.scpua.util.handlers.RegtistryHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION, acceptedMinecraftVersions = "[1.12.2]")
public class scpua {
    //Creative Tabs
    public static final CreativeTabs tablockdownunitytab = new Tabs("tablockdownunitytab", 1); //Main Tab
    public static final CreativeTabs tabweaponsscp = new Tabs("tabweaponsscp", 2); //Tools Tab
    public static final CreativeTabs tablockdownunitycosmetics = new Tabs("tablockdownunitycosmetics", 3); //Cosmetics
    public static final CreativeTabs tabsite93blocks = new Tabs("tabsite93blocks", 4); //Site-93

    //Proxy
    @SidedProxy(clientSide = "gus.scpua.proxy.ClientProxy", serverSide = "gus.scpua.proxy.CommonProxy")
    public static CommonProxy proxy;

    //PreInit
    @Mod.EventHandler
    public static void preInit(FMLPreInitializationEvent event) {
        RegtistryHandler.preInitRegistries();}
    //Init
    @Mod.EventHandler
    public static void init(FMLInitializationEvent event) {
        RegtistryHandler.initRegistries();
        proxy.clientInit();
    }
    //PostInit
    @Mod.EventHandler
    public static void postInit(FMLPostInitializationEvent event) {RegtistryHandler.postInitRegistries();}
}