package gus.overtime.blocks.custom;

import gus.overtime.blocks.XKBlockDirectional;
import gus.overtime.init.BlockInit;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Random;

public class BlockFlatLamp extends XKBlockDirectional {

    private final boolean isPowered;

    public BlockFlatLamp(String name, @Nullable CreativeTabs tabs, boolean isPowered) {
        super(name, tabs, Material.REDSTONE_LIGHT);
        this.isPowered = isPowered;
        setLightLevel(isPowered ? 1 : 0);
    }

    @Override
    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
        EnumFacing facing = state.getValue(FACING);
        System.out.println(facing);

        if (!worldIn.isRemote) {
            if (this.isPowered && !worldIn.isBlockPowered(pos)) {
                worldIn.setBlockState(pos, BlockInit.FLAT_LIGHT_OFF.getDefaultState().withProperty(FACING, facing));
            }
            else if (!this.isPowered && worldIn.isBlockPowered(pos)) {
                worldIn.setBlockState(pos, BlockInit.FLAT_LIGHT_ON.getDefaultState().withProperty(FACING, facing));
            }
        }
    }

    @Override
    public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {
        EnumFacing facing = state.getValue(FACING);

        if (!worldIn.isRemote) {
            if (isPowered && !worldIn.isBlockPowered(pos)) {
                worldIn.scheduleUpdate(pos, this, 4);
            }
            else if (!isPowered && worldIn.isBlockPowered(pos)) {
                worldIn.setBlockState(pos, BlockInit.FLAT_LIGHT_ON.getDefaultState().withProperty(FACING, facing));
            }
        }
    }

    @Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
        EnumFacing facing = state.getValue(FACING);

        if (!worldIn.isRemote) {
            if (this.isPowered && !worldIn.isBlockPowered(pos)) {
                worldIn.setBlockState(pos, BlockInit.FLAT_LIGHT_OFF.getDefaultState().withProperty(FACING, facing));
            }
        }
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return Item.getItemFromBlock(BlockInit.FLAT_LIGHT_OFF);
    }

    private final AxisAlignedBB
            UP_FLATLAMP_AABB = new AxisAlignedBB(1/16F, 0, 1/16F, 15/16F, 2/16F, 15/16F),
            DOWN_FLATLAMP_AABB = new AxisAlignedBB(0.0625, 0.0625 * 14, 0.0625, 0.0625 * 15, 0.0625 * 16, 0.0625 * 15),
            NORTH_FLATLAMP_AABB = new AxisAlignedBB(0.0625, 0.0625, 0.0625 * 14, 0.0625 * 15, 0.0625 * 15, 0.0625 * 16),
            SOUTH_FLATLAMP_AABB = new AxisAlignedBB(0.0625, 0.0625, 0, 0.0625 * 15, 0.0625 * 15, 0.0625 * 2),
            EAST_FLATLAMP_AABB = new AxisAlignedBB(0.0625 * 2, 0.0625, 0.0625, 0, 0.0625 * 15, 0.0625 * 15),
            WEST_FLATLAMP_AABB = new AxisAlignedBB(0.0625 * 16, 0.0625, 0.0625, 0.0625 * 14, 0.0625 * 15, 0.0625 * 15);

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        switch (state.getValue(FACING)) {
            case UP: default: return UP_FLATLAMP_AABB;
            case DOWN: return DOWN_FLATLAMP_AABB;
            case NORTH: return NORTH_FLATLAMP_AABB;
            case SOUTH: return SOUTH_FLATLAMP_AABB;
            case EAST: return EAST_FLATLAMP_AABB;
            case WEST: return WEST_FLATLAMP_AABB;
        }
    }
}
