package gus.scpua.objects.blocks;

import gus.scpua.init.BlockInit;
import gus.scpua.util.DamageSrc;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockTesla extends BlockBase {
    public BlockTesla(String name, Material material, int inv) {
        super(name, material, inv);
        setLightLevel(0.5F);
        setLightOpacity(1);
    }

    //Allows transparency
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT;
    }

    //Removes X-ray effect
    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    //Removes in block shadows
    @Override
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    //Hides that weird 2 faced inside thing
    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side) {
        IBlockState iblockstate = blockAccess.getBlockState(pos.offset(side));
        Block block = iblockstate.getBlock();

        //Bad excuse to have 2 returns on the same block
        if (this == BlockInit.TESLA_BLOCK) {
            if (block == this) {
                return false;
            }
        }

        return block == this ? false : super.shouldSideBeRendered(blockState, blockAccess, pos, side);
    }

    //The rest of this code is Collision Damage
    public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn) {
        entityIn.attackEntityFrom(DamageSrc.ELECTROCUTED, 100.0F);
    }

    //Collision
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
        return NULL_AABB;
    }

    @SideOnly(Side.CLIENT)
    public AxisAlignedBB getSelectedBoundingBox(IBlockState state, World worldIn, BlockPos pos) {
        return new AxisAlignedBB(0, 0, 0, 1D, 1D, 1D).offset(pos);
    }
}
