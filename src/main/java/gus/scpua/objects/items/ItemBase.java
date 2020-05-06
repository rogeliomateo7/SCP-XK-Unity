package gus.scpua.objects.items;

import gus.scpua.scpua;
import gus.scpua.init.ItemInit;
import net.minecraft.item.Item;

import javax.annotation.Nullable;

public class ItemBase extends Item {

    public ItemBase(String name, @Nullable Integer inventory) {
        setUnlocalizedName(name);
        setRegistryName(name);
        try {
            if (inventory == 0) setCreativeTab(scpua.tabweaponsscp);
            if (inventory == 1) setCreativeTab(scpua.tabxkunitytab);
        } catch (NullPointerException ignored) {}


        ItemInit.ITEMS.add(this);
    }
}
