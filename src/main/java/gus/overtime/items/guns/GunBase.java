package gus.overtime.items.guns;

import gus.overtime.items.XKItem;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;

//uwu whats dis?
public abstract class GunBase extends XKItem {
    private int recoil;
    private int reloadTime;
    private int fireRate;

    private int bullets;

    private boolean isLoaded;

    public GunBase(String name, @Nullable CreativeTabs tabs) {
        super(name, tabs);
    }

    //Aim down
    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        return super.onItemUse(player, worldIn, pos, hand, facing, hitX, hitY, hitZ);
    }

    //Fire
    @Override
    public boolean onEntitySwing(EntityLivingBase entityLiving, ItemStack stack) {

        //No hitting animation played
        return false;
    }

    @Override
    public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        if (worldIn.isRemote) {
            //entityIn.
        }
    }
}
