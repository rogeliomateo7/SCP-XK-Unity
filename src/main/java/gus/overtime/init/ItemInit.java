package gus.overtime.init;

import java.util.ArrayList;
import java.util.List;

import gus.overtime.items.armour.COMSuit;
import gus.overtime.items.*;
import gus.overtime.items.scp.SelfReplicatingCake;
import gus.overtime.items.scp.WeedScp;
import gus.overtime.items.tools.Medical;
import gus.overtime.items.tools.ToolSword;
import gus.overtime.Overtime;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.RegistryEvent;

import static gus.overtime.Overtime.MODID;

public class ItemInit {
    public static final List<Item> ITEMS = new ArrayList<>();

    /* Material */
    public static final ItemArmor.ArmorMaterial ARMOR_MATERIAL_COMS = EnumHelper.addArmorMaterial("armor_material_coms", MODID+":coms", 7,
            new int[]{2, 4, 6, 2}, 10, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);

    /* Logos */
    public static XKItem LOGO_YELLOW, LOGO_ORANGE, LOGO_GREEN, LOGO_RED, LOGO_BLUE;

    /* Combat */
    public static Item CROWBAR, COMBATKNIFE, FIREAXE, BROKENPIPE, ABLESWORD;

    /* Medical */
    public static XKItem MEDKIT, PK_CONTAINER, PK_PILL, ADRENALINE, BANDAGE;

    /* SCP Items */
    public static Item SELF_REPLECATING_CAKE, DRUGS_SCP;

    // Misc Items \\
    public static XKItem WRENCH;

    /* COM Suit */
    //TODO Merge into main init to look cool
    public static final Item COMS_HELMET = new COMSuit("coms_helmet", ARMOR_MATERIAL_COMS, EntityEquipmentSlot.HEAD);
    public static final Item COMS_CHESTPLATE = new COMSuit("coms_chestplate", ARMOR_MATERIAL_COMS, EntityEquipmentSlot.CHEST);
    public static final Item COMS_LEGGINGS = new COMSuit("coms_leggings", ARMOR_MATERIAL_COMS, EntityEquipmentSlot.LEGS);
    public static final Item COMS_BOOTS = new COMSuit("coms_boots", ARMOR_MATERIAL_COMS, EntityEquipmentSlot.FEET);

    public static void init(RegistryEvent.Register<Item> event) {
        LOGO_YELLOW = new XKItem("logoy");
        LOGO_ORANGE = new XKItem("logoo");
        LOGO_GREEN = new XKItem("logog");
        LOGO_RED = new XKItem("logor");
        LOGO_BLUE = new XKItem("logob");

        CROWBAR = new ToolSword("ucrowbar", EnumHelper.addToolMaterial("tool_crowbar", 0, 180, 5.0F, 1.0F, 0));
        COMBATKNIFE = new ToolSword("ucombatknife", EnumHelper.addToolMaterial("tool_combatknife", 0, 300, 13.0F, 3.0F, 0));
        FIREAXE = new ToolSword("ufireaxe", EnumHelper.addToolMaterial("tool_fireaxe", 0, 270, 2.0F, 4.0F, 0));
        BROKENPIPE = new ToolSword("ubrokenpipe", EnumHelper.addToolMaterial("tool_brokenpipe", 0, 120, 3.0F, 1.5F, 0));
        ABLESWORD = new ToolSword("uablesword", EnumHelper.addToolMaterial("tool_ablesword", 0, 1000, 2.0F, 10.0F, 0));

        MEDKIT = new Medical("umedkit", 1, Medical.MedicalTool.MEDKIT);
        PK_CONTAINER = new Medical("painkiller", 1, Medical.MedicalTool.PK_CONTAINER);
        PK_PILL = new Medical("painkillerpill", 5, Medical.MedicalTool.PK_PILL);
        ADRENALINE = new Medical("uadrenaline", 1, Medical.MedicalTool.ADREN);
        BANDAGE = new Medical("ubandage", 5, Medical.MedicalTool.BANDAGE);

        SELF_REPLECATING_CAKE = new SelfReplicatingCake("uselfreplicatingcake", 2, false);
        DRUGS_SCP = new WeedScp("420-j", 1, false);

        WRENCH = new XKItem("wrench", Overtime.TAB_TOOLS);


        event.getRegistry().registerAll(ItemInit.ITEMS.toArray(new Item[0]));
    }
}
