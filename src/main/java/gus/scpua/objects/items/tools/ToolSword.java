package gus.scpua.objects.items.tools;

import gus.scpua.init.ItemInit;
import gus.scpua.scpua;
import gus.scpua.util.IHasModel;
import net.minecraft.item.ItemSword;

public class ToolSword extends ItemSword implements IHasModel {


    public ToolSword(String name, ToolMaterial material) {
        super(material);
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
