package gus.scpua.init;

import java.util.ArrayList;
import java.util.List;

import gus.scpua.objects.items.ItemHidden;
import net.minecraft.item.Item;

public class ItemInit {
	public static final List<Item> ITEMS = new ArrayList<Item>();
/*
	//Material
	public static final ItemArmor.ArmorMaterial ARMOR_MATERIAL_COMS = EnumHelper.addArmorMaterial("armor_material_coms", "s78:coms", 7,
			new int[] {2, 4, 6, 2}, 10, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
*/
	//Logo
	public static final Item LOGO_YELLOW = new ItemHidden("logoy");
	public static final Item LOGO_ORANGE = new ItemHidden("logoo");
	public static final Item LOGO_GREEN = new ItemHidden("logog");
	public static final Item LOGO_RED = new ItemHidden("logor");
	public static final Item LOGO_BLUE = new ItemHidden("logob");
}
