package gus.overtime.blocks.custom;

import gus.overtime.blocks.XKBlockHorizontal;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Random;

import static gus.overtime.Overtime.TAB_OVERTIME;

public class BlockCZGlass extends XKBlockHorizontal {
    public BlockCZGlass() {
        super("czglass", TAB_OVERTIME, Material.GLASS);
    }

    @Override
    public boolean canSilkHarvest(World world, BlockPos pos, IBlockState state, EntityPlayer player) {
        return true;
    }

    @Override
    public int quantityDropped(Random random) {
        return 0;
    }

    public static AxisAlignedBB
            NS_CZGLASS_AABB = new AxisAlignedBB(0,0,0.0625 * 7,0.0625 * 16,0.0625 * 16,0.0625 * 9),
            EW_CZGLASS_AABB = new AxisAlignedBB(0.0625 * 7,0,0,0.0625 * 9,0.0625 * 16,0.0625 * 16);

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        if (state.getValue(BlockHorizontal.FACING) == EnumFacing.NORTH || state.getValue(BlockHorizontal.FACING) == EnumFacing.SOUTH) return NS_CZGLASS_AABB;
        else return EW_CZGLASS_AABB;
    }
}
