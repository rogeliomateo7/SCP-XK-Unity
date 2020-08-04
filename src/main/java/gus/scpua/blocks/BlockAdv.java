package gus.scpua.blocks;

import gus.scpua.init.blocks.XKUnity;
import gus.scpua.util.handlers.XKEventHandler;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.*;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

public class BlockAdv extends BlockBase {
    public BlockAdv(int whatClass, String name, Material material, int inv, boolean fullcube, Collision collision) {
        super(whatClass, name, material, inv);
        fullCube = fullcube;
        this.collision = collision;
    }

    private boolean fullCube = true;
    private Collision collision;

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
    //public static AxisAlignedBB BARREL_AABB = new AxisAlignedBB(0.0625 * 3, 0, 0.0625 * 3, 0.0625 * 13, 0.0625 * 16, 0.0625 * 13);

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return new AxisAlignedBB(0, 0, 0, 1.0D, 1.0D, 1.0D);
    }

    /**
     * Custom Code Section
     */
    @Override
    public void onBlockClicked(World worldIn, BlockPos pos, EntityPlayer playerIn) {
        //FIXME Might change later on to separate classes
        //Pipe Nightmare
        if (this == XKUnity.SCP015B || this == XKUnity.SCP015A) {
            XKEventHandler.pnHit = true;
            XKEventHandler.worldIn = worldIn;
            XKEventHandler.blockPos = pos;
            XKEventHandler.playerIn = playerIn;
            return;
        }

        if (this == XKUnity.METALICHYD) {
            boolean executeMetalicExp;
            executeMetalicExp = !playerIn.isCreative();
            if (executeMetalicExp) {
                worldIn.setBlockState(pos, Blocks.AIR.getDefaultState());
                worldIn.createExplosion(null, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, 2F, true);
                worldIn.playSound(null, pos, SoundEvents.ENTITY_GENERIC_EXPLODE, SoundCategory.BLOCKS, 1, 1);
            }
            return;
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand) {
        if (this != XKUnity.METALICHYD) return;

        worldIn.spawnParticle(EnumParticleTypes.EXPLOSION_NORMAL, pos.getX() + 0.5,pos.getY() + 1,pos.getZ() + 0.5,0,0,0);
    }
}
