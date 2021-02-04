package gus.overtime.blocks.cosmetics;

import gus.overtime.blocks.XKBlockHorizontal;
import gus.overtime.Overtime;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class XKPowerBox extends XKBlockHorizontal {
    public XKPowerBox() {
        super("powerbox", Overtime.TAB_COSMETICS, Material.IRON);
    }

    private final AxisAlignedBB
            NORTH_POWER_AABB = new AxisAlignedBB(0.0625 * 2.5, 0.03125, 0.0625 * 14.5, 0.0625 * 13.5, 0.0625 * 16.5, 0.0625 * 16.5),
            SOUTH_POWER_AABB = new AxisAlignedBB(0.0625 * 2.5, 0.03125, 0.0625 * 1.5, 0.0625 * 13.5, 0.0625 * 16.5, -0.03125),
            EAST_POWER_AABB = new AxisAlignedBB(-0.03125, 0.03125, 0.0625 * 2.5, 0.0625 * 1.5, 0.0625 * 16.5, 0.0625 * 13.5),
            WEST_POWER_AABB = new AxisAlignedBB(0.0625 * 16.5, 0.03125, 0.0625 * 2.5, 0.0625 * 14.5, 0.0625 * 16.5, 0.0625 * 13.5);

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        switch (state.getValue(BlockHorizontal.FACING)) {
            case NORTH: default: return NORTH_POWER_AABB;
            case SOUTH: return SOUTH_POWER_AABB;
            case EAST: return EAST_POWER_AABB;
            case WEST: return WEST_POWER_AABB;
        }
    }
}
