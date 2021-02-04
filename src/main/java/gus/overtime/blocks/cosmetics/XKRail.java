package gus.overtime.blocks.cosmetics;

import gus.overtime.blocks.XKBlockHorizontal;
import gus.overtime.Overtime;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class XKRail extends XKBlockHorizontal {
    public XKRail(String name) {
        super(name, Overtime.TAB_COSMETICS, Material.IRON);
    }

    private final AxisAlignedBB
            NORTH_RAIL_AABB = new AxisAlignedBB(0.0625 * 16, 0, 0.0625 * 13, 0, 0.0625 * 16, 0.0625 * 15),
            SOUTH_RAIL_AABB = new AxisAlignedBB(0.0625 * 16, 0, 0.0625, 0, 0.0625 * 16, 0.0625 * 3),
            EAST_RAIL_AABB = new AxisAlignedBB(0.0625 * 3, 0, 0, 0.0625, 0.0625 * 16, 0.0625 * 16),
            WEST_RAIL_AABB = new AxisAlignedBB(0.0625 * 15, 0, 0, 0.0625 * 13, 0.0625 * 16, 0.0625 * 16);

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        switch (state.getValue(BlockHorizontal.FACING)) {
            case NORTH: default: return NORTH_RAIL_AABB;
            case SOUTH: return SOUTH_RAIL_AABB;
            case EAST: return EAST_RAIL_AABB;
            case WEST: return WEST_RAIL_AABB;
        }
    }
}
