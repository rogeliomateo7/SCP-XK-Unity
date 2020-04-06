package gus.scpua.objects.items.tools;

import gus.scpua.init.ItemInit;
import gus.scpua.objects.items.ItemBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class Medical extends ItemBase {
    public Medical(String name) {
        super(name);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        if (playerIn.isCreative()) return super.onItemRightClick(worldIn, playerIn, handIn);
        if (this == ItemInit.MEDKIT) {
            playerIn.heal(7.0F); //3 and a half
        } else

        if (this == ItemInit.PK_CONTAINER) {
            playerIn.addItemStackToInventory(ItemInit.PK_PILL.getDefaultInstance());
            playerIn.addItemStackToInventory(ItemInit.PK_PILL.getDefaultInstance());
            playerIn.addItemStackToInventory(ItemInit.PK_PILL.getDefaultInstance());
            playerIn.addItemStackToInventory(ItemInit.PK_PILL.getDefaultInstance());
            playerIn.addItemStackToInventory(ItemInit.PK_PILL.getDefaultInstance());
        } else

        if (this == ItemInit.PK_PILL) {
            playerIn.heal(1.0F); //Half a heart
        } else

        if (this == ItemInit.ADRENALINE) {
            playerIn.addPotionEffect(new PotionEffect(MobEffects.SPEED, 2000, 1));
        } else

        if (this == ItemInit.BANDAGE) {
            playerIn.heal(4.0F); //2 Hearts
        }

        playerIn.inventory.getCurrentItem().shrink(1);
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}
