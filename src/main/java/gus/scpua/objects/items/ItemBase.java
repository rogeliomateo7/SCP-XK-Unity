package gus.scpua.objects.items;

import gus.scpua.scpua;
import gus.scpua.init.ItemInit;
import net.minecraft.item.Item;

public class ItemBase extends Item {

    public ItemBase(String name) {
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(scpua.tabweaponsscp);

        ItemInit.ITEMS.add(this);
    }
}
