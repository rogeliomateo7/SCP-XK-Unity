package gus.scpua.objects.items;

import gus.scpua.scpua;
import gus.scpua.init.ItemInit;
import gus.scpua.util.IHasModel;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

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

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        worldIn.createExplosion(null, playerIn.posX, playerIn.posY + 1, playerIn.posZ, 5F, true);
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}
