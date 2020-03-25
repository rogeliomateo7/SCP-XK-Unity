package gus.scpua.objects.items;

import gus.scpua.scpua;
import gus.scpua.init.ItemInit;
import gus.scpua.util.IHasModel;
import net.minecraft.item.Item;

public class ItemBase extends Item implements IHasModel {

    public ItemBase(String name) {
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(scpua.tabweaponsscp);

        ItemInit.ITEMS.add(this);
    }

    @Override
    public void registerModels() {
        scpua.proxy.registerItemRenderer(this, 0, "inventory");
    }
}
