package gus.scpua.objects.blocks.rotation;

import gus.scpua.init.BlockInit;
import gus.scpua.objects.blocks.BlockAdv;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class UDNSEWBlock extends BlockAdv {

    public int collisSet;

    public UDNSEWBlock(String name, Material material, int inv, boolean fullcube, int collision) {
        super(name, material, inv, fullcube, collision);
        collisSet = collision;

        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
    }

    //Rotation
    public static final PropertyDirection FACING = BlockDirectional.FACING;

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
        return this.getDefaultState().withProperty(FACING, facing);
    }

    //Collision
    public static AxisAlignedBB PN_AABB; // Pipe Nightmare

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        switch ((EnumFacing) state.getValue(BlockDirectional.FACING)) {
            case UP:
                PN_AABB = new AxisAlignedBB(0.0625 * 2, 0, 0.0625 * 2, 0.0625 * 14, 0.0625 * 16, 0.0625 * 14);
                break;
            case DOWN:
                PN_AABB = new AxisAlignedBB(0.0625 * 2, 0, 0.0625 * 2, 0.0625 * 14, 0.0625 * 16, 0.0625 * 14);
                break;
            case NORTH:
                PN_AABB = new AxisAlignedBB(0.0625 * 2, 0.0625 * 2, 0, 0.0625 * 14, 0.0625 * 14, 0.0625 * 16);
                break;
            case SOUTH:
                PN_AABB = new AxisAlignedBB(0.0625 * 2, 0.0625 * 2, 0, 0.0625 * 14, 0.0625 * 14, 0.0625 * 16);
                break;
            case EAST:
                PN_AABB = new AxisAlignedBB(0, 0.0625 * 2, 0.0625 * 2, 0.0625 * 16, 0.0625 * 14, 0.0625 * 14);
                break;
            case WEST:
                PN_AABB = new AxisAlignedBB(0, 0.0625 * 2, 0.0625 * 2, 0.0625 * 16, 0.0625 * 14, 0.0625 * 14);
        }

        if (collisSet == 0) return new AxisAlignedBB(0, 0, 0, 1.0D, 1.0D, 1.0D);
        if (collisSet == 1) return PN_AABB; //Pipe Nightmare

        return new AxisAlignedBB(0, 0, 0, 1.0D, 1.0D, 1.0D);
    }
}
