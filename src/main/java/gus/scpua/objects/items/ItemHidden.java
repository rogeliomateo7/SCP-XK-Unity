package gus.scpua.objects.items;

import gus.scpua.init.ItemInit;
import net.minecraft.item.Item;

public class ItemHidden extends Item {

    public ItemHidden(String name) {
        setUnlocalizedName(name);
        setRegistryName(name);

        ItemInit.ITEMS.add(this);
    }
}