package gus.overtime.blocks.cosmetics;

import gus.overtime.blocks.XKBlockHorizontal;
import gus.overtime.Overtime;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class XKTrashBin extends XKBlockHorizontal {
    public XKTrashBin() {
        super("trashbin", Overtime.TAB_COSMETICS, Material.WOOD);
    }

    private final AxisAlignedBB
            NORTH_BIN_AABB = new AxisAlignedBB(0.0625 * 3, 0, 0.0625 * 8.5, 0.0625 * 13, 0.0625 * 19, 0.0625 * 15.5),
            SOUTH_BIN_AABB = new AxisAlignedBB(0.0625 * 3, 0, 0.0625 / 2, 0.0625 * 13, 0.0625 * 19, 0.0625 * 7.5),
            EAST_BIN_AABB = new AxisAlignedBB(0.0625 / 2, 0, 0.0625 * 3, 0.0625 * 7.5, 0.0625 * 19, 0.0625 * 13),
            WEST_BIN_AABB = new AxisAlignedBB(0.0625 * 15.5, 0, 0.0625 * 3, 0.0625 * 8.5, 0.0625 * 19, 0.0625 * 13);

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        switch (state.getValue(BlockHorizontal.FACING)) {
            case NORTH: default: return NORTH_BIN_AABB;
            case SOUTH: return SOUTH_BIN_AABB;
            case EAST: return EAST_BIN_AABB;
            case WEST: return WEST_BIN_AABB;
        }
    }
}
