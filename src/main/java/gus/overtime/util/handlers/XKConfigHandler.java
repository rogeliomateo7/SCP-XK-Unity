package gus.overtime.util.handlers;

import gus.overtime.Overtime;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.io.File;

public class XKConfigHandler {
    public static Configuration config;

    public static boolean SPREAD_610 = true;

    public static void init(File file) {
        config = new Configuration(file);

        String category;

        category = "SCP Blocks";
        config.addCustomCategoryComment(category, "Section for SCP Blocks");
        SPREAD_610 = config.getBoolean("610 Spread", category, true, "Allow 610 to Spread?");

        config.save();
    }

    public static void registerConfig(FMLPreInitializationEvent event) {
        Overtime.config = new File(event.getModConfigurationDirectory() + "/" + Overtime.MODID);
        Overtime.config.mkdirs();
        init(new File(Overtime.config.getPath(), Overtime.MODID + ".cfg"));
    }
}
