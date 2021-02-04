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

public class XKShelf extends XKBlockHorizontal {
    public XKShelf(String name) {
        super(name, Overtime.TAB_COSMETICS, Material.WOOD);
    }

    private final AxisAlignedBB
            NS_SHELF_AABB = new AxisAlignedBB(0, 0, 0.0625 * 2, 0.0625 * 16, 0.0625 * 17, 0.0625 * 14),
            EW_SHELF_AABB = new AxisAlignedBB(0.0625 * 2, 0, 0, 0.0625 * 14, 0.0625 * 17, 0.0625 * 16);

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        if (state.getValue(BlockHorizontal.FACING) == EnumFacing.NORTH || state.getValue(BlockHorizontal.FACING) == EnumFacing.SOUTH) return NS_SHELF_AABB;
        else return EW_SHELF_AABB;
    }
}
