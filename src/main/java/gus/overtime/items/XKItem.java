package gus.overtime.items;

import gus.overtime.init.ItemInit;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import javax.annotation.Nullable;

public class XKItem extends Item {

    public XKItem(String name, @Nullable CreativeTabs tabs) {
        setUnlocalizedName(name);
        setRegistryName(name);

        if (tabs != null) setCreativeTab(tabs);

        ItemInit.ITEMS.add(this);
    }

    public XKItem(String name) {
        this(name, null);
    }
}
