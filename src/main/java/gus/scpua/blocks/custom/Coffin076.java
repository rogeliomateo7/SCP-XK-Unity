package gus.scpua.blocks.custom;

import gus.scpua.blocks.Collision;
import gus.scpua.blocks.rotation.NSEWBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Coffin076 extends NSEWBlock {

    public static final PropertyBool MIDDLE = PropertyBool.create("middle");

    public Coffin076(int whatClass, String name, Material material, int inv, boolean fullcube, Collision collision) {
        super(whatClass, name, material, inv, fullcube, collision);
    }

    @Override
    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
        EnumFacing middleBlock = state.getValue(FACING);

        if (middleBlock == EnumFacing.NORTH || middleBlock == EnumFacing.DOWN) {
            worldIn.setBlockState(pos.east(), getDefaultState().withProperty(MIDDLE, false).withProperty(FACING, EnumFacing.WEST));
            worldIn.setBlockState(pos.west(), getDefaultState().withProperty(MIDDLE, false).withProperty(FACING, EnumFacing.EAST));
        } else {
            worldIn.setBlockState(pos.north(), getDefaultState().withProperty(MIDDLE, false).withProperty(FACING, EnumFacing.NORTH));
            worldIn.setBlockState(pos.south(), getDefaultState().withProperty(MIDDLE, false).withProperty(FACING, EnumFacing.SOUTH));
        }
    }

    @Override
    public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {
        boolean isMiddle = worldIn.getBlockState(pos).getValue(MIDDLE);
        EnumFacing enumfacing = state.getValue(FACING);
        if (!isMiddle) {
            if (worldIn.getBlockState(pos.offset(enumfacing)).getBlock() != this) {
                worldIn.setBlockState(pos, Blocks.AIR.getDefaultState());
            }
        }
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, MIDDLE, FACING);
    }

    public EnumBlockRenderType getRenderType(IBlockState state) {
        return state.getValue(MIDDLE) ? EnumBlockRenderType.MODEL : EnumBlockRenderType.INVISIBLE;
    }
}
