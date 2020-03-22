package gus.scpua.objects.items;

import gus.scpua.scpua;
import gus.scpua.init.ItemInit;
import gus.scpua.util.IHasModel;
import net.minecraft.item.Item;

public class ItemHidden extends Item implements IHasModel {

    public ItemHidden(String name) {
        setUnlocalizedName(name);
        setRegistryName(name);

        ItemInit.ITEMS.add(this);
    }

    @Override
    public void registerModels() {
        scpua.proxy.registerItemRenderer(this, 0, "inventory");
    }

}
