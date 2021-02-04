package gus.overtime.blocks.cosmetics;

import gus.overtime.blocks.XKBlockHorizontal;
import gus.overtime.Overtime;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class XKFireExtinguisher extends XKBlockHorizontal {
    public XKFireExtinguisher() {
        super("fireextinguixer", Overtime.TAB_COSMETICS, Material.IRON);
    }

    private final AxisAlignedBB
            NORTH_FIRE_EXT_AABB = new AxisAlignedBB(0.0625 * 12, 0.0625, 0.0625 * 9, 0.0625 * 4, 0.0625 * 17, 0.0625 * 16),
            SOUTH_FIRE_EXT_AABB = new AxisAlignedBB(0.0625 * 4, 0.0625, 0, 0.0625 * 12, 0.0625 * 17, 0.0625 * 7),
            EAST_FIRE_EXT_AABB = new AxisAlignedBB(0, 0.0625, 0.0625 * 4, 0.0625 * 7, 0.0625 * 17, 0.0625 * 12),
            WEST_FIRE_EXT_AABB = new AxisAlignedBB(0.0625 * 16, 0.0625, 0.0625 * 4, 0.0625 * 9, 0.0625 * 17, 0.0625 * 12);

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        switch (state.getValue(BlockHorizontal.FACING)) {
            case NORTH: default: return NORTH_FIRE_EXT_AABB;
            case SOUTH: return SOUTH_FIRE_EXT_AABB;
            case EAST: return EAST_FIRE_EXT_AABB;
            case WEST: return WEST_FIRE_EXT_AABB;
        }
    }
}
