package gus.overtime.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.*;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

public class XKBlockNonSolid extends XKBlock {
    public XKBlockNonSolid(String name, @Nullable CreativeTabs tabs, Material material) {
        super(name, tabs, material);
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

    //Allows transparency
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.TRANSLUCENT;
    }
}
