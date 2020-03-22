package gus.scpua.init;

import java.util.ArrayList;
import java.util.List;

import gus.scpua.objects.armour.COMSuit;
import gus.scpua.objects.items.ItemHidden;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;

public class ItemInit {
	public static final List<Item> ITEMS = new ArrayList<Item>();

	//Material
	public static final ItemArmor.ArmorMaterial ARMOR_MATERIAL_COMS = EnumHelper.addArmorMaterial("armor_material_coms", "scpua:coms", 7,
			new int[] {2, 4, 6, 2}, 10, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);

	//Logo
	public static final Item LOGO_YELLOW = new ItemHidden("logoy");
	public static final Item LOGO_ORANGE = new ItemHidden("logoo");
	public static final Item LOGO_GREEN = new ItemHidden("logog");
	public static final Item LOGO_RED = new ItemHidden("logor");
	public static final Item LOGO_BLUE = new ItemHidden("logob");

	//COM Suit
	public static final Item COMS_HELMET = new COMSuit("coms_helmet", ARMOR_MATERIAL_COMS, EntityEquipmentSlot.HEAD);
	public static final Item COMS_CHESTPLATE = new COMSuit("coms_chestplate", ARMOR_MATERIAL_COMS, EntityEquipmentSlot.CHEST);
	public static final Item COMS_LEGGINGS = new COMSuit("coms_leggings", ARMOR_MATERIAL_COMS, EntityEquipmentSlot.LEGS);
	public static final Item COMS_BOOTS = new COMSuit("coms_boots", ARMOR_MATERIAL_COMS, EntityEquipmentSlot.FEET);
}
