package gus.overtime.tabs;

import gus.overtime.init.ItemInit;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

import java.util.Comparator;

public class XKCreativeTab extends CreativeTabs {

    private final int icon;

    public XKCreativeTab(String label, int tab) {
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

    public static Comparator<ItemStack> tabSorter;

    @Override
    public void displayAllRelevantItems(NonNullList<ItemStack> itemStacks) {
        super.displayAllRelevantItems(itemStacks);
        itemStacks.sort(tabSorter);
    }
}
