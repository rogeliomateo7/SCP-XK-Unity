package gus.scpua.init;

import java.util.ArrayList;
import java.util.List;

import gus.scpua.objects.armour.COMSuit;
import gus.scpua.objects.items.*;
import gus.scpua.objects.items.tools.Medical;
import gus.scpua.objects.items.tools.ToolSword;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;

public class ItemInit {
    public static final List<Item> ITEMS = new ArrayList<Item>();

    //Material
    public static final ItemArmor.ArmorMaterial ARMOR_MATERIAL_COMS = EnumHelper.addArmorMaterial("armor_material_coms", "scpua:coms", 7,
            new int[]{2, 4, 6, 2}, 10, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);

    public static final Item.ToolMaterial TOOL_BLUNT = EnumHelper.addToolMaterial("tool_blunt", 1, 180, 5.0F, 1.0F, 0);
    public static final Item.ToolMaterial TOOL_SHARP = EnumHelper.addToolMaterial("tool_sharp", 1, 180, 7.0F, 4.0F, 0);

    //Logo
    public static final Item LOGO_YELLOW = new ItemHidden("logoy");
    public static final Item LOGO_ORANGE = new ItemHidden("logoo");
    public static final Item LOGO_GREEN = new ItemHidden("logog");
    public static final Item LOGO_RED = new ItemHidden("logor");
    public static final Item LOGO_BLUE = new ItemHidden("logob");

    public static final Item CROWBAR = new ToolSword("ucrowbar", TOOL_BLUNT);
    public static final Item COMBATKNIFE = new ToolSword("ucombatknife", TOOL_SHARP);
    public static final Item FIREAXE = new ToolSword("ufireaxe", TOOL_SHARP);
    public static final Item BROKENPIPE = new ToolSword("ubrokenpipe", TOOL_BLUNT);
    public static final Item ABLESWORD = new ToolSword("uablesword", TOOL_SHARP);

    public static final Item MEDKIT = new Medical("umedkit");
    public static final Item PK_CONTAINER = new Medical("painkiller");
    public static final Item PK_PILL = new Medical("painkillerpill");
    public static final Item ADRENALINE = new Medical("uadrenaline");
    public static final Item BANDAGE = new Medical("ubandage");


    //COM Suit
    public static final Item COMS_HELMET = new COMSuit("coms_helmet", ARMOR_MATERIAL_COMS, EntityEquipmentSlot.HEAD);
    public static final Item COMS_CHESTPLATE = new COMSuit("coms_chestplate", ARMOR_MATERIAL_COMS, EntityEquipmentSlot.CHEST);
    public static final Item COMS_LEGGINGS = new COMSuit("coms_leggings", ARMOR_MATERIAL_COMS, EntityEquipmentSlot.LEGS);
    public static final Item COMS_BOOTS = new COMSuit("coms_boots", ARMOR_MATERIAL_COMS, EntityEquipmentSlot.FEET);
}
