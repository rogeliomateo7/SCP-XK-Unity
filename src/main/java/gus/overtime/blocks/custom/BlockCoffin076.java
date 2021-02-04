package gus.overtime.blocks.custom;

import gus.overtime.blocks.XKBlock;
import gus.overtime.blocks.XKBlockHorizontal;
import gus.overtime.entity.scp.EntitySCP076_2;
import gus.overtime.init.BlockInit;
import gus.overtime.init.ItemInit;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Random;

import static gus.overtime.Overtime.LOG;

public class BlockCoffin076 extends XKBlockHorizontal {

    public static final PropertyBool MIDDLE = PropertyBool.create("middle");

    public BlockCoffin076(String name, CreativeTabs tabs, Material material) {
        super(name, tabs, material);
        this.blockState.getBaseState().withProperty(MIDDLE, true).withProperty(FACING, EnumFacing.NORTH);
        setTickRandomly(true);
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (playerIn.getHeldItem(EnumHand.MAIN_HAND).getItem() != ItemInit.WRENCH) return false;
        if (!playerIn.isCreative()) return false;

        if (worldIn.isRemote) {
            ArrayList<BlockPos> ablePos = new ArrayList<>();
            int amount = 0;

            for (Entity e : worldIn.loadedEntityList) {
                if (e instanceof EntitySCP076_2) {
                    amount++;
                    ablePos.add(new BlockPos(e.posX, e.posY, e.posZ));
                }
            }

            if (amount == 0) {
                playerIn.sendMessage(new TextComponentString("§e§l[Debug]:§r An Able instance was not found"));
            } else {
                StringBuilder msg = new StringBuilder("§e§l[Debug]:§r " + amount + " Able Instances were found");
                for (BlockPos position : ablePos) {
                    msg.append("\nPosition: " + position);
                }

                playerIn.sendMessage(new TextComponentString(msg.toString()));
            }
            return true;
        }

        return false;
    }

    @Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
        if (!state.getValue(MIDDLE)) return;

        for (Entity entity : worldIn.loadedEntityList) {
            if (entity instanceof EntitySCP076_2) return;
        }

        double d = rand.nextDouble();
        LOG.info(d + "  |  " + (d < 0.0001));
        //if (d < 0.0001) {
            BlockPos SpawnPoint = pos;
            EnumFacing facing = state.getValue(FACING);

            if (facing == EnumFacing.NORTH || facing == EnumFacing.SOUTH) {
                if (worldIn.getBlockState(pos.east()).getBlock() == Blocks.AIR) SpawnPoint = pos.east();
                if (worldIn.getBlockState(pos.west()).getBlock() == Blocks.AIR) SpawnPoint = pos.west();
            }

            if (facing == EnumFacing.EAST || facing == EnumFacing.WEST) {
                if (worldIn.getBlockState(pos.north()).getBlock() == Blocks.AIR) SpawnPoint = pos.north();
                if (worldIn.getBlockState(pos.south()).getBlock() == Blocks.AIR) SpawnPoint = pos.south();
            }

            Entity able = new EntitySCP076_2(worldIn);
            able.setPosition(SpawnPoint.getX(), SpawnPoint.getY(), SpawnPoint.getZ());
            worldIn.spawnEntity(able);
        //}
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
        if (!state.getValue(MIDDLE)) return; //Just in case the Side block is somehow placed
        EnumFacing facing = state.getValue(FACING);

        if (facing == EnumFacing.NORTH || facing == EnumFacing.SOUTH) {
            if (worldIn.getBlockState(pos.east()).getBlock() == Blocks.AIR && worldIn.getBlockState(pos.west()).getBlock() == Blocks.AIR)
                return;
        }

        if (facing == EnumFacing.EAST || facing == EnumFacing.WEST) {
            if (worldIn.getBlockState(pos.north()).getBlock() == Blocks.AIR && worldIn.getBlockState(pos.south()).getBlock() == Blocks.AIR)
                return;
        }

        worldIn.setBlockToAir(pos);
        stack.grow(1);
    }

    @Override
    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
        if (!state.getValue(MIDDLE)) return;

        EnumFacing facing = state.getValue(FACING);
        IBlockState sideState = getDefaultState().withProperty(MIDDLE, false);

        if (facing == EnumFacing.NORTH || facing == EnumFacing.SOUTH) {
            worldIn.setBlockState(pos.east(), sideState.withProperty(FACING, EnumFacing.EAST), 2);
            worldIn.setBlockState(pos.west(), sideState.withProperty(FACING, EnumFacing.WEST),2);
        } else {
            worldIn.setBlockState(pos.north(), sideState.withProperty(FACING, EnumFacing.NORTH),2);
            worldIn.setBlockState(pos.south(), sideState.withProperty(FACING, EnumFacing.SOUTH),2);
        }
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(FACING).getHorizontalIndex() + (state.getValue(MIDDLE) ? 4 : 0);
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        boolean middle = meta > 3;
        EnumFacing facing = EnumFacing.getHorizontal(meta);
        return getDefaultState().withProperty(MIDDLE, middle).withProperty(FACING, facing);
    }

    @Override
    public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {
        EnumFacing facing = state.getValue(FACING);
        XKBlock coffin = BlockInit.SCP076_1COFFIN; //Easier to reference

        if (state.getValue(MIDDLE)) {
            if (facing == EnumFacing.NORTH || facing == EnumFacing.SOUTH) {
                if (worldIn.getBlockState(pos.west()).getBlock() == coffin && worldIn.getBlockState(pos.east()).getBlock() == coffin) return;
                worldIn.destroyBlock(pos.west(), false);
                worldIn.destroyBlock(pos.east(), false);
            } else {
                if (worldIn.getBlockState(pos.north()).getBlock() == coffin && worldIn.getBlockState(pos.south()).getBlock() == coffin) return;
                worldIn.destroyBlock(pos.north(), false);
                worldIn.destroyBlock(pos.south(), false);
            }
        } else {
            BlockPos check = new BlockPos(pos).add(facing.getOpposite().getDirectionVec());
            if (worldIn.getBlockState(check).getBlock() == coffin && worldIn.getBlockState(check.add(facing.getOpposite().getDirectionVec())).getBlock() == coffin) return;
        }
        worldIn.destroyBlock(pos, false);
    }

    @Override
    public EnumBlockRenderType getRenderType(IBlockState state) {
        return state.getValue(MIDDLE) ? EnumBlockRenderType.MODEL : EnumBlockRenderType.INVISIBLE;
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, MIDDLE, FACING);
    }

    public static AxisAlignedBB
            NS_COFFIN_MIDDLE_AABB = new AxisAlignedBB(25/16D, 0, 0, -9/16D, 1, 1),
            EW_COFFIN_MIDDLE_AABB = new AxisAlignedBB(0, 0, 25/16D, 1, 1, -9/16D),

            N_COFFIN_AABB = new AxisAlignedBB(0, 0, 7/16D, 1, 1, 41/16D),
            S_COFFIN_AABB = new AxisAlignedBB(0, 0, 9/16D, 1, 1, -25/16D),
            E_COFFIN_AABB = new AxisAlignedBB(9/16D,0,0,-25/16D,1,1),
            W_COFFIN_AABB = new AxisAlignedBB(7/16D,0,0,41/16D,1,1);

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        if (state.getValue(MIDDLE)) {
            if (state.getValue(FACING) == EnumFacing.NORTH || state.getValue(FACING) == EnumFacing.SOUTH) return NS_COFFIN_MIDDLE_AABB;
            else return EW_COFFIN_MIDDLE_AABB;
        }
        switch (state.getValue(FACING)) {
            case NORTH: default: return N_COFFIN_AABB;
            case SOUTH: return S_COFFIN_AABB;
            case EAST: return E_COFFIN_AABB;
            case WEST: return W_COFFIN_AABB;
        }
    }
}
