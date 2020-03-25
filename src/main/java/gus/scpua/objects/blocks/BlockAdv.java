package gus.scpua.objects.blocks;

import gus.scpua.init.BlockInit;
import gus.scpua.util.handlers.ScpEventHandler;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.*;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockAdv extends BlockBase {
    public BlockAdv(String name, Material material, int inv, boolean fullcube, int collision) {
        super(name, material, inv);
        fullCube = fullcube;
        collisSet = collision;
    }

    public boolean fullCube = true;
    public int collisSet;

    //Removes X-ray effect
    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return fullCube;
    }

    //Removes in block shadows
    @Override
    public boolean isFullCube(IBlockState state) {
        return fullCube;
    }

    //Allows transparency
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT;
    }

    /**
     * Collision Sector
     */
    public static AxisAlignedBB BASE_AABB = new AxisAlignedBB(0, 0, 0, 0.0625 * 16, 0.0625 * 16, 0.0625 * 16); //Returns Solid Block if something went wrong

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {

        //Non Directional BB's
        //BLOCK_AABB = new AxisAlignedBB(1.0D, 1.0D, 1.0D, 1.0D, 1.0D, 1.0D);

        //if(collisSet == 1) BASE_AABB = BLOCK_AABB;

        return BASE_AABB;
    }

    /**
     * Custom Code Section
     */
    @Override
    public void onBlockClicked(World worldIn, BlockPos pos, EntityPlayer playerIn) {
        //Pipe Nightmare
        if (this == BlockInit.SCP015B || this == BlockInit.SCP015A) {
            ScpEventHandler.pnHit = true;
            ScpEventHandler.worldIn = worldIn;
            ScpEventHandler.blockPos = pos;
            ScpEventHandler.playerIn = playerIn;
        }
    }
}
