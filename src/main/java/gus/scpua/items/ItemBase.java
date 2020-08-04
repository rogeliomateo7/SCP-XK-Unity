package gus.scpua.items;

import gus.scpua.scpua;
import gus.scpua.init.ItemInit;
import gus.scpua.util.enums.XKInventory;
import net.minecraft.item.Item;

import javax.annotation.Nullable;

public class ItemBase extends Item {

    public ItemBase(String name, @Nullable XKInventory inventory) {
        setUnlocalizedName(name);
        setRegistryName(name);

        try {
            switch (inventory) {
                case XKUnity: setCreativeTab(scpua.tabxkunitytab); break;
                case Weapon: setCreativeTab(scpua.tabweaponsscp); break;
                case Cosmetic: setCreativeTab(scpua.tabxkunitycosmetics); break;
                case Site93: setCreativeTab(scpua.tabsite93); break;
                case Site78: setCreativeTab(scpua.tabsite78);
            }
        } catch (NullPointerException ignored) {}

        ItemInit.ITEMS.add(this);
    }
}
