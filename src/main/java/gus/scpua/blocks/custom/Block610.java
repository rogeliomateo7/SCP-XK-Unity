package gus.scpua.blocks.custom;

import gus.scpua.init.ItemInit;
import gus.scpua.init.blocks.XKUnity;
import gus.scpua.blocks.BlockBase;
import gus.scpua.scpua;
import gus.scpua.util.handlers.XKConfigHandler;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.*;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;

import javax.annotation.Nullable;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static gus.scpua.blocks.custom.Block610.Log610.FACING;
import static net.minecraft.block.BlockLog.LOG_AXIS;

public class Block610 extends BlockBase {
    protected static final int FLAMMABILITY = 3;
    protected static final int FIRE_SPREAD_SPEED = 3;


    public Block610(int whatClass, String name, Material material, int inv) {
        super(whatClass, name, material, inv);

        setHarvestLevel("shovel", 1);

        //Enable Spread based on config
        setTickRandomly(XKConfigHandler.SPREAD_610);
    }

    @Override
    public int getFlammability(IBlockAccess world, BlockPos pos, EnumFacing face) {
        return FLAMMABILITY;
    }

    @Override
    public int getFireSpreadSpeed(IBlockAccess world, BlockPos pos, EnumFacing face) {
        return FIRE_SPREAD_SPEED;
    }

    @Override
    public boolean canSustainLeaves(IBlockState state, net.minecraft.world.IBlockAccess world, BlockPos pos){ return true; }

    @Override
    public boolean canSustainPlant(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing direction, IPlantable plantable) {
        return true;
    }

    @Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
        if (!worldIn.isAreaLoaded(pos, 1)) return;

        //Random Number On what face to do
        int whatFace = ThreadLocalRandom.current().nextInt(0, 5 + 1);
        BlockPos face;

        Replacement replaceBlock = Replacement.NORMAL;
        int axis = 0;

        int attempt = 0;
        while (true) {
            if (!state.isNormalCube()) return; //Avoids Loop if block already destroyed

            switch (whatFace) {
                case 0: default: face = pos.up(); break;
                case 1: face = pos.down(); break;
                case 2: face = pos.north(); break;
                case 3: face = pos.south(); break;
                case 4: face = pos.east(); break;
                case 5: face = pos.west();
            }

            Block blockPos = worldIn.getBlockState(face).getBlock();

            //Correct Block
            if (blockPos == Blocks.DIRT.getDefaultState().getBlock()
                    || blockPos == Blocks.GRASS.getDefaultState().getBlock()
                    || blockPos == Blocks.GRASS_PATH.getDefaultState().getBlock()
                    || blockPos == Blocks.COBBLESTONE.getDefaultState().getBlock()
                    || blockPos == Blocks.MOSSY_COBBLESTONE.getDefaultState().getBlock()
                    || blockPos == Blocks.LEAVES.getDefaultState().getBlock()
                    || blockPos == Blocks.LEAVES2.getDefaultState().getBlock()
                    || blockPos == Blocks.PLANKS.getDefaultState().getBlock()) break;

            if (blockPos == Blocks.LOG.getDefaultState().getBlock()
                    || blockPos == Blocks.LOG2.getDefaultState().getBlock()) {
                switch (worldIn.getBlockState(face).getValue(LOG_AXIS)) {
                    case X: axis = 1; break;
                    case Z: axis = 2;
                }
                replaceBlock = Replacement.LOG;
                break;
            }

            //Incorrect Block
            whatFace = ThreadLocalRandom.current().nextInt(0, 5 + 1);
            attempt++;
            if (attempt == 10) return;
        }
        IBlockState block = XKUnity.SCP610A.getDefaultState();

        switch (replaceBlock) {
            case NORMAL: {
                double spawnChance = Math.random() * 100;
                if (spawnChance < 30) block = XKUnity.SCP610B.getDefaultState();
                break;
            }
            case LOG: {
                switch (axis) {
                    case 1:
                        block = XKUnity.SCP610LOG.getDefaultState().withProperty(FACING, EnumFacing.EAST);
                        break;
                    case 2:
                        block = XKUnity.SCP610LOG.getDefaultState().withProperty(FACING, EnumFacing.NORTH);
                        break;
                    default: 
                        block = XKUnity.SCP610LOG.getDefaultState().withProperty(FACING, EnumFacing.UP);
                        break;
                }
                break;
            }
            case GRASS: {

            }
        }
        worldIn.setBlockState(face, block);
    }

    @Nullable
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) { return new AxisAlignedBB(0, 0, 0, 0.0625 * 16, 0.0625 * 14.5, 0.0625 * 16); }

    @Override
    public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn) {
        entityIn.motionX *= 0.4D;
        entityIn.motionZ *= 0.4D;
    }

    private enum Replacement {
        NORMAL, LOG, GRASS
    }

    public static class Log610 extends Block610 {
        public Log610(int whatClass, String name, Material material, int inv) {
            super(whatClass, name, material, inv);

            this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.UP));
        }

        //Rotation
        public static final PropertyDirection FACING = BlockDirectional.FACING;

        @Override
        protected BlockStateContainer createBlockState() {
            return new BlockStateContainer(this, FACING);
        }

        @Override
        public IBlockState withRotation(IBlockState state, Rotation rot) {
            return state.withProperty(FACING, rot.rotate(state.getValue(FACING)));
        }

        @Override
        public IBlockState withMirror(IBlockState state, Mirror mirrorIn) {
            return state.withRotation(mirrorIn.toRotation(state.getValue(FACING)));
        }

        @Override
        public IBlockState getStateFromMeta(int meta) {
            return this.getDefaultState().withProperty(FACING, EnumFacing.getFront(meta));
        }

        @Override
        public int getMetaFromState(IBlockState state) {
            return state.getValue(FACING).getIndex();
        }

        @Override
        public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer, EnumHand hand) {
            return this.getDefaultState().withProperty(FACING, facing);
        }
    }

    public static class Grass610 extends BlockBush {

        public Grass610(String name, Material material) {
            super(material);
            setUnlocalizedName(name);
            setRegistryName(name);

            setCreativeTab(scpua.tabxkunitytab);

            setSoundType(SoundType.SLIME);
            setHardness(1.5F);
            setResistance(2);

            XKUnity.XKUNITYBLOCKS.add(this);

            ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
        }

        @Override
        public int getFlammability(IBlockAccess world, BlockPos pos, EnumFacing face) {
            return FLAMMABILITY;
        }

        @Override
        public int getFireSpreadSpeed(IBlockAccess world, BlockPos pos, EnumFacing face) {
            return FIRE_SPREAD_SPEED;
        }
    }

}