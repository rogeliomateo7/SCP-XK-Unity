package gus.overtime.blocks.cosmetics;

import gus.overtime.blocks.XKBlockHorizontal;
import gus.overtime.Overtime;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class XKBarrel extends XKBlockHorizontal {
    public XKBarrel(String name) {
        super(name, Overtime.TAB_COSMETICS, Material.IRON);
    }

    private final AxisAlignedBB BARREL_AABB = new AxisAlignedBB(0.0625 * 3, 0, 0.0625 * 3, 0.0625 * 13, 0.0625 * 16, 0.0625 * 13);

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return BARREL_AABB;
    }
}
