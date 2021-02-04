package gus.overtime.blocks.custom;

import gus.overtime.blocks.XKBlock;
import gus.overtime.init.BlockInit;
import gus.overtime.init.ItemInit;
import gus.overtime.tileentity.AlbedoCL;
import gus.overtime.tileentity.NoAlbedoCL;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Random;

import static gus.overtime.Overtime.ALBEDO;

public class CLBlock extends XKBlock {
    private final boolean isPowered;

    public CLBlock(String name, @Nullable CreativeTabs tabs, boolean isOn) {
        super(name, tabs, Material.REDSTONE_LIGHT);
        if (!ALBEDO) if (isOn) setLightLevel(2F);

        isPowered = isOn;
    }

    @Override
    public boolean hasTileEntity(IBlockState state) { return true; }

    @Nullable
    @Override
    public TileEntity createTileEntity(World world, IBlockState state) {
        if (ALBEDO && this != BlockInit.CLOFF) return new AlbedoCL();
        else return new NoAlbedoCL();
    }

    @Override
    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, @Nullable EntityLivingBase entity, ItemStack stack) {
        super.onBlockPlacedBy(world, pos, state, entity, stack);
        TileEntity tile = world.getTileEntity(pos);
        if (tile instanceof NoAlbedoCL) ((NoAlbedoCL) tile).setColor(0xefebd8);
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (!worldIn.isRemote && playerIn.isCreative() && playerIn.getHeldItem(hand).getItem().equals(ItemInit.WRENCH)) {
            TileEntity tileentity = worldIn.getTileEntity(pos);

            if (tileentity instanceof NoAlbedoCL) {
                //playerIn.displayGUIChest((NoAlbedoCL) tileentity);
                //playerIn.addStat(StatList.FURNACE_INTERACTION);
                playerIn.sendMessage(new TextComponentString("Block hit"));
            }
            return true;
        }
        return false;
    }


    @Override
    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state)
    {
        if (!worldIn.isRemote) {
            if (this.isPowered && !worldIn.isBlockPowered(pos)) {
                worldIn.setBlockState(pos, BlockInit.CLOFF.getDefaultState());
            }
            else if (!this.isPowered && worldIn.isBlockPowered(pos)) {
                worldIn.setBlockState(pos, BlockInit.CLON.getDefaultState());
            }
        }
    }

    @Override
    public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos)
    {
        if (!worldIn.isRemote) {
            if (isPowered && !worldIn.isBlockPowered(pos)) {
                worldIn.scheduleUpdate(pos, this, 4);
            }
            else if (!isPowered && worldIn.isBlockPowered(pos)) {
                worldIn.setBlockState(pos, BlockInit.CLON.getDefaultState());
            }
        }
    }

    @Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        if (!worldIn.isRemote) {
            if (this.isPowered && !worldIn.isBlockPowered(pos)) {
                worldIn.setBlockState(pos, BlockInit.CLOFF.getDefaultState());
            }
        }
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) { return Item.getItemFromBlock(BlockInit.CLOFF); }
}
