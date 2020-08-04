package gus.scpua.blocks.rotation;

import gus.scpua.blocks.BlockAdv;
import gus.scpua.blocks.Collision;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.*;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class NSEWBlock extends BlockAdv {
    private Collision collision;

    public NSEWBlock(int whatClass, String name, Material material, int inv, boolean fullcube, Collision collision) {
        super(whatClass, name, material, inv, fullcube, collision);
        this.collision = collision;

        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
    }

    //Allows transparency
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.TRANSLUCENT;
    }

    //Rotation
    public static final PropertyDirection FACING = BlockHorizontal.FACING;

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, FACING);
    }

    @Override
    public IBlockState withRotation(IBlockState state, Rotation rot) {
        return state.withProperty(FACING, rot.rotate(state.getValue(FACING)));
    }

    @Override
    public IBlockState withMirror(IBlockState state, Mirror mirrorIn) {
        return state.withRotation(mirrorIn.toRotation(state.getValue(FACING)));
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(FACING, EnumFacing.getFront(meta));
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(FACING).getIndex();
    }

    @Override
    public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer, EnumHand hand) {
        return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
    }

    //Collision
    public static AxisAlignedBB BIN_AABB, RAIL_AABB, POWER_AABB, FIRE_EXT_AABB, SCP_076_1_AABB, SHELFS_AABB, WET_FLOOR_SIGN_AABB, CZGLASS_AABB;
    public static AxisAlignedBB BARREL_AABB = new AxisAlignedBB(0.0625 * 3, 0, 0.0625 * 3, 0.0625 * 13, 0.0625 * 16, 0.0625 * 13);

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        switch (state.getValue(BlockHorizontal.FACING)) {
            case NORTH:
                BIN_AABB = new AxisAlignedBB(0.0625 * 3, 0, 0.0625 * 8.5, 0.0625 * 13, 0.0625 * 19, 0.0625 * 15.5);
                RAIL_AABB = new AxisAlignedBB(0.0625 * 16, 0, 0.0625 * 13, 0, 0.0625 * 16, 0.0625 * 15);
                POWER_AABB = new AxisAlignedBB(0.0625 * 2.5, 0.03125, 0.0625 * 14.5, 0.0625 * 13.5, 0.0625 * 16.5, 0.0625 * 16.5);
                FIRE_EXT_AABB = new AxisAlignedBB(0.0625 * 12, 0.0625, 0.0625 * 9, 0.0625 * 4, 0.0625 * 17, 0.0625 * 16);
                SCP_076_1_AABB = new AxisAlignedBB(0.0625 * 25, 0, 0, -0.0625 * 9, 0.0625 * 16, 0.0625 * 16);
                SHELFS_AABB = new AxisAlignedBB(0, 0, 0.0625 * 2, 0.0625 * 16, 0.0625 * 17, 0.0625 * 14);
                WET_FLOOR_SIGN_AABB = new AxisAlignedBB(0.0625 * 4, 0, -0.0625, 0.0625 * 12, 0.0625 * 21, 0.0625 * 17);
                CZGLASS_AABB = new AxisAlignedBB(0,0,0.0625 * 7,0.0625 * 16,0.0625 * 16,0.0625 * 9);
                break;
            case SOUTH:
                BIN_AABB = new AxisAlignedBB(0.0625 * 3, 0, 0.0625 / 2, 0.0625 * 13, 0.0625 * 19, 0.0625 * 7.5);
                RAIL_AABB = new AxisAlignedBB(0.0625 * 16, 0, 0.0625, 0, 0.0625 * 16, 0.0625 * 3);
                POWER_AABB = new AxisAlignedBB(0.0625 * 2.5, 0.03125, 0.0625 * 1.5, 0.0625 * 13.5, 0.0625 * 16.5, -0.03125);
                FIRE_EXT_AABB = new AxisAlignedBB(0.0625 * 4, 0.0625, 0, 0.0625 * 12, 0.0625 * 17, 0.0625 * 7);
                SCP_076_1_AABB = new AxisAlignedBB(0.0625 * 25, 0, 0, -0.0625 * 9, 0.0625 * 16, 0.0625 * 16);
                SHELFS_AABB = new AxisAlignedBB(0, 0, 0.0625 * 2, 0.0625 * 16, 0.0625 * 17, 0.0625 * 14);
                WET_FLOOR_SIGN_AABB = new AxisAlignedBB(0.0625 * 4, 0, -0.0625, 0.0625 * 12, 0.0625 * 21, 0.0625 * 17);
                CZGLASS_AABB = new AxisAlignedBB(0,0,0.0625 * 7,0.0625 * 16,0.0625 * 16,0.0625 * 9);
                break;
            case EAST:
                BIN_AABB = new AxisAlignedBB(0.0625 / 2, 0, 0.0625 * 3, 0.0625 * 7.5, 0.0625 * 19, 0.0625 * 13);
                RAIL_AABB = new AxisAlignedBB(0.0625 * 3, 0, 0, 0.0625, 0.0625 * 16, 0.0625 * 16);
                POWER_AABB = new AxisAlignedBB(-0.03125, 0.03125, 0.0625 * 2.5, 0.0625 * 1.5, 0.0625 * 16.5, 0.0625 * 13.5);
                FIRE_EXT_AABB = new AxisAlignedBB(0, 0.0625, 0.0625 * 4, 0.0625 * 7, 0.0625 * 17, 0.0625 * 12);
                SCP_076_1_AABB = new AxisAlignedBB(0, 0, 0.0625 * 25, 0.0625 * 16, 0.0625 * 16, -0.0625 * 9);
                SHELFS_AABB = new AxisAlignedBB(0.0625 * 2, 0, 0, 0.0625 * 14, 0.0625 * 17, 0.0625 * 16);
                WET_FLOOR_SIGN_AABB = new AxisAlignedBB(-0.0625, 0, 0.0625 * 4, 0.0625 * 17, 0.0625 * 21, 0.0625 * 12);
                CZGLASS_AABB = new AxisAlignedBB(0.0625 * 7,0,0,0.0625 * 9,0.0625 * 16,0.0625 * 16);
                break;
            case WEST:
                BIN_AABB = new AxisAlignedBB(0.0625 * 15.5, 0, 0.0625 * 3, 0.0625 * 8.5, 0.0625 * 19, 0.0625 * 13);
                RAIL_AABB = new AxisAlignedBB(0.0625 * 15, 0, 0, 0.0625 * 13, 0.0625 * 16, 0.0625 * 16);
                POWER_AABB = new AxisAlignedBB(0.0625 * 16.5, 0.03125, 0.0625 * 2.5, 0.0625 * 14.5, 0.0625 * 16.5, 0.0625 * 13.5);
                FIRE_EXT_AABB = new AxisAlignedBB(0.0625 * 16, 0.0625, 0.0625 * 4, 0.0625 * 9, 0.0625 * 17, 0.0625 * 12);
                SCP_076_1_AABB = new AxisAlignedBB(0, 0, 0.0625 * 25, 0.0625 * 16, 0.0625 * 16, -0.0625 * 9);
                SHELFS_AABB = new AxisAlignedBB(0.0625 * 2, 0, 0, 0.0625 * 14, 0.0625 * 17, 0.0625 * 16);
                WET_FLOOR_SIGN_AABB = new AxisAlignedBB(-0.0625, 0, 0.0625 * 4, 0.0625 * 17, 0.0625 * 21, 0.0625 * 12);
                CZGLASS_AABB = new AxisAlignedBB(0.0625 * 7,0,0,0.0625 * 9,0.0625 * 16,0.0625 * 16);
        }

        if (collision == Collision.BIN) return BIN_AABB;
        if (collision == Collision.RAIL) return RAIL_AABB;
        if (collision == Collision.POWER) return POWER_AABB;
        if (collision == Collision.FIRE_EXT) return FIRE_EXT_AABB;
        if (collision == Collision.COFFIN) return SCP_076_1_AABB;
        if (collision == Collision.SHELF) return SHELFS_AABB;
        if (collision == Collision.WET_FLOOR) return WET_FLOOR_SIGN_AABB;
        if (collision == Collision.BARREL) return BARREL_AABB;
        if (collision == Collision.CZGLASS) return CZGLASS_AABB;

        return new AxisAlignedBB(0, 0, 0, 1.0D, 1.0D, 1.0D); //Returns block if something went wrong
    }
}
