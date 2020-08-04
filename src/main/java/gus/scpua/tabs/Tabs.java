package gus.scpua.tabs;

import gus.scpua.init.ItemInit;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Tabs extends CreativeTabs {

    private final int icon;

    public Tabs(String label, int tab) {
        super(label);
        icon = tab;
        //this.setBackgroundImageName("main.png");
    }

    public ItemStack getTabIconItem() {
        Item itemIcon = ItemInit.LOGO_BLUE;
        switch (icon) {
            case 1: itemIcon = ItemInit.LOGO_YELLOW; break;
            case 2: itemIcon = ItemInit.LOGO_ORANGE; break;
            case 3: itemIcon = ItemInit.LOGO_GREEN; break;
            case 4: itemIcon = ItemInit.LOGO_RED; break;
        }
        return new ItemStack(itemIcon);
    }
}
