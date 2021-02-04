package gus.overtime.blocks.cosmetics;

import gus.overtime.blocks.XKBlockDirectional;
import gus.overtime.Overtime;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class XKTinyLamp extends XKBlockDirectional {
    public XKTinyLamp() {
        super("tinylamp", Overtime.TAB_COSMETICS, Material.IRON);
        setLightLevel(1F);
    }

    private final AxisAlignedBB
            UP_TINYLAMP_AABB = new AxisAlignedBB(0.0625 * 5.5, 0, 0.0625 * 5.5, 0.0625 * 10.5, 0.0625, 0.0625 * 10.5),
            DOWN_TINYLAMP_AABB = new AxisAlignedBB(0.0625 * 5.5, 0.0625 * 15, 0.0625 * 5.5, 0.0625 * 10.5, 0.0625 * 16, 0.0625 * 10.5),
            NORTH_TINYLAMP_AABB = new AxisAlignedBB(0.0625 * 5.5, 0.0625 * 5.5, 0.0625 * 15, 0.0625 * 10.5, 0.0625 * 10.5, 0.0625 * 16),
            SOUTH_TINYLAMP_AABB = new AxisAlignedBB(0.0625 * 5.5, 0.0625 * 5.5, 0.0625 * 0, 0.0625 * 10.5, 0.0625 * 10.5, 0.0625),
            EAST_TINYLAMP_AABB = new AxisAlignedBB(0, 0.0625 * 5.5, 0.0625 * 5.5, 0.0625, 0.0625 * 10.5, 0.0625 * 10.5),
            WEST_TINYLAMP_AABB = new AxisAlignedBB(0.0625 * 16, 0.0625 * 5.5, 0.0625 * 5.5, 0.0625 * 15, 0.0625 * 10.5, 0.0625 * 10.5);

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        switch (state.getValue(BlockDirectional.FACING)) {
            case UP: default: return UP_TINYLAMP_AABB;
            case DOWN: return DOWN_TINYLAMP_AABB;
            case NORTH: return NORTH_TINYLAMP_AABB;
            case SOUTH: return SOUTH_TINYLAMP_AABB;
            case EAST: return EAST_TINYLAMP_AABB;
            case WEST: return WEST_TINYLAMP_AABB;
        }
    }
}
