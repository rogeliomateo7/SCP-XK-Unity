package gus.overtime.items.scp;

import gus.overtime.init.ItemInit;
import gus.overtime.Overtime;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class WeedScp extends ItemFood{
    private Object Item;

    public WeedScp(String name, int amount, boolean isWolfFood) {
        super(amount, isWolfFood);
        setCreativeTab(Overtime.TAB_OVERTIME);
        setUnlocalizedName(name);
        setRegistryName(name);

        ItemInit.ITEMS.add(this);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        if (playerIn.isCreative()) return new ActionResult<>(EnumActionResult.FAIL, playerIn.getHeldItem(handIn));

        playerIn.addPotionEffect(new PotionEffect(MobEffects.NAUSEA, 450, 1));
        playerIn.addPotionEffect(new PotionEffect(MobEffects.SPEED,450, 1));
        ItemStack itemstack = playerIn.getHeldItem(handIn);

        if (playerIn.canEat(true))
        {
            playerIn.setActiveHand(handIn);
            return new ActionResult<>(EnumActionResult.SUCCESS, itemstack);
        }
        else
        {
            return new ActionResult<>(EnumActionResult.FAIL, itemstack);
        }
    }
}
