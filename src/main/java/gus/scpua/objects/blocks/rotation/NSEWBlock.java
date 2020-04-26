package gus.scpua.objects.blocks.rotation;

import gus.scpua.init.BlockInit;
import gus.scpua.objects.blocks.BlockAdv;
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

    public int collisSet;

    public NSEWBlock(String name, Material material, int inv, boolean fullcube, int collision) {
        super(name, material, inv, fullcube, collision);
        collisSet = collision;

        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
    }

    //Rotation
    public static final PropertyDirection FACING = BlockHorizontal.FACING;

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, new IProperty[]{FACING});
    }

    @Override
    public IBlockState withRotation(IBlockState state, Rotation rot) {
        return state.withProperty(FACING, rot.rotate((EnumFacing) state.getValue(FACING)));
    }

    @Override
    public IBlockState withMirror(IBlockState state, Mirror mirrorIn) {
        return state.withRotation(mirrorIn.toRotation((EnumFacing) state.getValue(FACING)));
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(FACING, EnumFacing.getFront(meta));
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return ((EnumFacing) state.getValue(FACING)).getIndex();
    }

    @Override
    public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer, EnumHand hand) {
        return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
    }

    //Collision
    public static AxisAlignedBB BIN_AABB;
    public static AxisAlignedBB RAIL_AABB;
    public static AxisAlignedBB POWER_AABB;
    public static AxisAlignedBB FIRE_EXT_AABB;
    public static AxisAlignedBB SCP_076_1_AABB;
    public static AxisAlignedBB SHELFS_AABB;
    public static AxisAlignedBB WET_FLOOR_SIGN_AABB;
    public static AxisAlignedBB BARREL_AABB = new AxisAlignedBB(0.0625 * 3, 0, 0.0625 * 3, 0.0625 * 13, 0.0625 * 16, 0.0625 * 13);
    public static AxisAlignedBB CZGLASS_AABB = new AxisAlignedBB(0, 0, 0, 1.0D, 1.0D, 1.0D);

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        switch ((EnumFacing) state.getValue(BlockHorizontal.FACING)) {
            case NORTH:
                BIN_AABB = new AxisAlignedBB(0.0625 * 3, 0, 0.0625 * 8.5, 0.0625 * 13, 0.0625 * 19, 0.0625 * 15.5);
                RAIL_AABB = new AxisAlignedBB(0.0625 * 16, 0, 0.0625 * 13, 0, 0.0625 * 16, 0.0625 * 15);
                POWER_AABB = new AxisAlignedBB(0.0625 * 2.5, 0.03125, 0.0625 * 14.5, 0.0625 * 13.5, 0.0625 * 16.5, 0.0625 * 16.5);
                FIRE_EXT_AABB = new AxisAlignedBB(0.0625 * 12, 0.0625, 0.0625 * 9, 0.0625 * 4, 0.0625 * 17, 0.0625 * 16);
                SCP_076_1_AABB = new AxisAlignedBB(0.0625 * 25, 0, 0, -0.0625 * 9, 0.0625 * 16, 0.0625 * 16);
                SHELFS_AABB = new AxisAlignedBB(0, 0, 0.0625 * 2, 0.0625 * 16, 0.0625 * 17, 0.0625 * 14);
                WET_FLOOR_SIGN_AABB = new AxisAlignedBB(0.0625 * 4, 0, -0.0625, 0.0625 * 12, 0.0625 * 21, 0.0625 * 17);
                break;
            case SOUTH:
                BIN_AABB = new AxisAlignedBB(0.0625 * 3, 0, 0.0625 / 2, 0.0625 * 13, 0.0625 * 19, 0.0625 * 7.5);
                RAIL_AABB = new AxisAlignedBB(0.0625 * 16, 0, 0.0625, 0, 0.0625 * 16, 0.0625 * 3);
                POWER_AABB = new AxisAlignedBB(0.0625 * 2.5, 0.03125, 0.0625 * 1.5, 0.0625 * 13.5, 0.0625 * 16.5, -0.03125);
                FIRE_EXT_AABB = new AxisAlignedBB(0.0625 * 4, 0.0625, 0, 0.0625 * 12, 0.0625 * 17, 0.0625 * 7);
                SCP_076_1_AABB = new AxisAlignedBB(0.0625 * 25, 0, 0, -0.0625 * 9, 0.0625 * 16, 0.0625 * 16);
                SHELFS_AABB = new AxisAlignedBB(0, 0, 0.0625 * 2, 0.0625 * 16, 0.0625 * 17, 0.0625 * 14);
                WET_FLOOR_SIGN_AABB = new AxisAlignedBB(0.0625 * 4, 0, -0.0625, 0.0625 * 12, 0.0625 * 21, 0.0625 * 17);
                break;
            case EAST:
                BIN_AABB = new AxisAlignedBB(0.0625 / 2, 0, 0.0625 * 3, 0.0625 * 7.5, 0.0625 * 19, 0.0625 * 13);
                RAIL_AABB = new AxisAlignedBB(0.0625 * 3, 0, 0, 0.0625, 0.0625 * 16, 0.0625 * 16);
                POWER_AABB = new AxisAlignedBB(-0.03125, 0.03125, 0.0625 * 2.5, 0.0625 * 1.5, 0.0625 * 16.5, 0.0625 * 13.5);
                FIRE_EXT_AABB = new AxisAlignedBB(0, 0.0625, 0.0625 * 4, 0.0625 * 7, 0.0625 * 17, 0.0625 * 12);
                SCP_076_1_AABB = new AxisAlignedBB(0, 0, 0.0625 * 25, 0.0625 * 16, 0.0625 * 16, -0.0625 * 9);
                SHELFS_AABB = new AxisAlignedBB(0.0625 * 2, 0, 0, 0.0625 * 14, 0.0625 * 17, 0.0625 * 16);
                WET_FLOOR_SIGN_AABB = new AxisAlignedBB(-0.0625, 0, 0.0625 * 4, 0.0625 * 17, 0.0625 * 21, 0.0625 * 12);
                break;
            case WEST:
                BIN_AABB = new AxisAlignedBB(0.0625 * 15.5, 0, 0.0625 * 3, 0.0625 * 8.5, 0.0625 * 19, 0.0625 * 13);
                RAIL_AABB = new AxisAlignedBB(0.0625 * 15, 0, 0, 0.0625 * 13, 0.0625 * 16, 0.0625 * 16);
                POWER_AABB = new AxisAlignedBB(0.0625 * 16.5, 0.03125, 0.0625 * 2.5, 0.0625 * 14.5, 0.0625 * 16.5, 0.0625 * 13.5);
                FIRE_EXT_AABB = new AxisAlignedBB(0.0625 * 16, 0.0625, 0.0625 * 4, 0.0625 * 9, 0.0625 * 17, 0.0625 * 12);
                SCP_076_1_AABB = new AxisAlignedBB(0, 0, 0.0625 * 25, 0.0625 * 16, 0.0625 * 16, -0.0625 * 9);
                SHELFS_AABB = new AxisAlignedBB(0.0625 * 2, 0, 0, 0.0625 * 14, 0.0625 * 17, 0.0625 * 16);
                WET_FLOOR_SIGN_AABB = new AxisAlignedBB(-0.0625, 0, 0.0625 * 4, 0.0625 * 17, 0.0625 * 21, 0.0625 * 12);
        }

        if (collisSet == 1) return BIN_AABB;
        if (collisSet == 2) return RAIL_AABB;
        if (collisSet == 3) return POWER_AABB; //Power Box
        if (collisSet == 4) return FIRE_EXT_AABB;
        if (collisSet == 5) return SCP_076_1_AABB; //076 Coffin
        if (collisSet == 6) return SHELFS_AABB;
        if (collisSet == 7) return WET_FLOOR_SIGN_AABB;
        if (collisSet == 8) return BARREL_AABB;
        if (collisSet == 9) return CZGLASS_AABB;

        return new AxisAlignedBB(0, 0, 0, 1.0D, 1.0D, 1.0D); //Returns block if something went wrong
    }
}
