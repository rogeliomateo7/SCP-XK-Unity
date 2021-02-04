package gus.overtime.blocks.cosmetics;

import gus.overtime.blocks.XKBlockHorizontal;
import gus.overtime.Overtime;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class XKWetFloorSign extends XKBlockHorizontal {
    public XKWetFloorSign() {
        super("wetfloorsign", Overtime.TAB_COSMETICS, Material.WOOD);
    }

    public static AxisAlignedBB
            NS_WET_FLOOR_SIGN_AABB = new AxisAlignedBB(0.0625 * 4, 0, -0.0625, 0.0625 * 12, 0.0625 * 21, 0.0625 * 17),
            EW_WET_FLOOR_SIGN_AABB = new AxisAlignedBB(-0.0625, 0, 0.0625 * 4, 0.0625 * 17, 0.0625 * 21, 0.0625 * 12);

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        if (state.getValue(BlockHorizontal.FACING) == EnumFacing.NORTH || state.getValue(BlockHorizontal.FACING) == EnumFacing.SOUTH) return NS_WET_FLOOR_SIGN_AABB;
        else return EW_WET_FLOOR_SIGN_AABB;
    }
}
