package gus.scpua.blocks.custom;

import gus.scpua.init.blocks.Cosmetics;
import gus.scpua.init.blocks.Site78;
import gus.scpua.blocks.Collision;
import gus.scpua.blocks.rotation.UDNSEWBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Random;

public class BlockLamp extends UDNSEWBlock {
    private boolean isPowered;
    private Collision collision;

    public BlockLamp(int whatClass, String name, Material material, int inv, boolean fullcube, Collision collision, boolean isOn) {
        super(whatClass, name, material, inv, fullcube, collision);

        this.collision = collision;
        isPowered = isOn;
    }


    /**
     * Called after the block is set in the Chunk data, but before the Tile Entity is set
     */
    @Override
    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state)
    {
        if (this == Cosmetics.TINY_LAMP) return; // Currently This doesnt have a off function

        EnumFacing facing = state.getValue(FACING);

        if (!worldIn.isRemote)
        {
            if (this.isPowered && !worldIn.isBlockPowered(pos))
            {
                worldIn.setBlockState(pos, Site78.FLAT_LIGHT_OFF.getDefaultState().withProperty(FACING, facing));
            }
            else if (!this.isPowered && worldIn.isBlockPowered(pos))
            {
                worldIn.setBlockState(pos, Site78.FLAT_LIGHT_ON.getDefaultState().withProperty(FACING, facing));
            }
        }
    }

    /**
     * Called when a neighboring block was changed and marks that this state should perform any checks during a neighbor
     * change. Cases may include when redstone power is updated, cactus blocks popping off due to a neighboring solid
     * block, etc.
     */
    @Override
    public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos)
    {
        if (this == Cosmetics.TINY_LAMP) return; // Currently This doesnt have a off function

        EnumFacing facing = state.getValue(FACING);

        if (!worldIn.isRemote)
        {
            if (isPowered && !worldIn.isBlockPowered(pos))
            {
                worldIn.scheduleUpdate(pos, this, 4);
            }
            else if (!isPowered && worldIn.isBlockPowered(pos))
            {
                worldIn.setBlockState(pos, Site78.FLAT_LIGHT_ON.getDefaultState().withProperty(FACING, facing));
            }
        }
    }

    @Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        if (this == Cosmetics.TINY_LAMP) return; // Currently This doesnt have a off function

        EnumFacing facing = state.getValue(FACING);

        if (!worldIn.isRemote)
        {
            if (this.isPowered && !worldIn.isBlockPowered(pos))
            {
                worldIn.setBlockState(pos, Site78.FLAT_LIGHT_OFF.getDefaultState().withProperty(FACING, facing));
            }
        }
    }

    /**
     * Get the Item that this Block should drop when harvested.
     */
    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        Item drop = Item.getItemFromBlock(Blocks.STONE); //Stone As Default cos it needs to initialize
        if (this == Site78.FLAT_LIGHT_ON || this == Site78.FLAT_LIGHT_OFF) drop = Item.getItemFromBlock(Site78.FLAT_LIGHT_OFF);
        if (this == Cosmetics.TINY_LAMP) drop = Item.getItemFromBlock(Cosmetics.TINY_LAMP);

        return drop;
    }

    //Collision
    public static AxisAlignedBB S78_LAMP_AABB;
    public static AxisAlignedBB TINY_LAMP_AABB;

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        switch ((EnumFacing) state.getValue(BlockDirectional.FACING)) {
            case UP:
                TINY_LAMP_AABB = new AxisAlignedBB(0.0625 * 5.5, 0, 0.0625 * 5.5, 0.0625 * 10.5, 0.0625, 0.0625 * 10.5);
                S78_LAMP_AABB = new AxisAlignedBB(0.0625, 0, 0.0625, 0.0625 * 15, 0.0625 * 2, 0.0625 * 15);
                break;
            case DOWN:
                TINY_LAMP_AABB = new AxisAlignedBB(0.0625 * 5.5, 0.0625 * 15, 0.0625 * 5.5, 0.0625 * 10.5, 0.0625 * 16, 0.0625 * 10.5);
                S78_LAMP_AABB = new AxisAlignedBB(0.0625, 0.0625 * 14, 0.0625, 0.0625 * 15, 0.0625 * 16, 0.0625 * 15);
                break;
            case NORTH:
                TINY_LAMP_AABB = new AxisAlignedBB(0.0625 * 5.5, 0.0625 * 5.5, 0.0625 * 15, 0.0625 * 10.5, 0.0625 * 10.5, 0.0625 * 16);
                S78_LAMP_AABB = new AxisAlignedBB(0.0625, 0.0625, 0.0625 * 14, 0.0625 * 15, 0.0625 * 15, 0.0625 * 16);
                break;
            case SOUTH:
                TINY_LAMP_AABB = new AxisAlignedBB(0.0625 * 5.5, 0.0625 * 5.5, 0.0625 * 0, 0.0625 * 10.5, 0.0625 * 10.5, 0.0625);
                S78_LAMP_AABB = new AxisAlignedBB(0.0625, 0.0625, 0, 0.0625 * 15, 0.0625 * 15, 0.0625 * 2);
                break;
            case EAST:
                TINY_LAMP_AABB = new AxisAlignedBB(0, 0.0625 * 5.5, 0.0625 * 5.5, 0.0625, 0.0625 * 10.5, 0.0625 * 10.5);
                S78_LAMP_AABB = new AxisAlignedBB(0.0625 * 2, 0.0625, 0.0625, 0, 0.0625 * 15, 0.0625 * 15);
                break;
            case WEST:
                TINY_LAMP_AABB = new AxisAlignedBB(0.0625 * 16, 0.0625 * 5.5, 0.0625 * 5.5, 0.0625 * 15, 0.0625 * 10.5, 0.0625 * 10.5);
                S78_LAMP_AABB = new AxisAlignedBB(0.0625 * 16, 0.0625, 0.0625, 0.0625 * 14, 0.0625 * 15, 0.0625 * 15);
        }

        if (collision == Collision.S78LIGHT) return S78_LAMP_AABB;
        if (collision == Collision.TINYLAMP) return TINY_LAMP_AABB;


        return new AxisAlignedBB(0, 0, 0, 1.0D, 1.0D, 1.0D);
    }
}
