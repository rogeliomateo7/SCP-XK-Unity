package gus.scpua.tabs;

import gus.scpua.init.ItemInit;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class Tabs extends CreativeTabs {
	public int icon;

	public Tabs(String label, int tab) {
		super(label);
		icon = tab;
	//	this.setBackgroundImageName("main.png");
	}

	public ItemStack getTabIconItem() {
		ItemStack tabIcon = new ItemStack(ItemInit.LOGO_GREEN);

		if (icon == 1) tabIcon = new ItemStack(ItemInit.LOGO_YELLOW);
		if (icon == 2) tabIcon = new ItemStack(ItemInit.LOGO_ORANGE);
		if (icon == 3) tabIcon = new ItemStack(ItemInit.LOGO_GREEN);
		if (icon == 4) tabIcon = new ItemStack(ItemInit.LOGO_RED);
		if (icon == 5) tabIcon = new ItemStack(ItemInit.LOGO_BLUE);
		return tabIcon;
	}
}
