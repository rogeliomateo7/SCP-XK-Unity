package gus.scpua.objects.blocks;

import gus.scpua.init.BlockInit;
import gus.scpua.init.ItemInit;
import gus.scpua.objects.blocks.BlockBase;
import gus.scpua.scpua;
import gus.scpua.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.audio.Sound;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;

public class OrientableBlock extends Block implements IHasModel {

    public static final PropertyDirection FACING = BlockHorizontal.FACING;
    public boolean fullCube = true;
    public int collisSet;

    public OrientableBlock(String name, Material material, int inv, int collision) {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setHardness(2.0F);
        setResistance(30);

        collisSet = collision;

        if (name.equals("trashbin") || name.contains("rail") || name.equals("powerbox") || name.contains("fire")) fullCube = false;

        //Sounds
        if (material == Material.IRON) setSoundType(SoundType.METAL);
        if (material == Material.ROCK) setSoundType(SoundType.STONE);
        if (material == Material.WOOD) setSoundType(SoundType.WOOD);
        if (material == Material.CLOTH) setSoundType(SoundType.CLOTH);

        //Creative Tab set
        if(inv == 1) setCreativeTab(scpua.tablockdownunitytab);
        if(inv == 2) setCreativeTab(scpua.tabweaponsscp);
        if(inv == 3) setCreativeTab(scpua.tablockdownunitycosmetics);
        if(inv == 4) setCreativeTab(scpua.tabsite93blocks);

        BlockInit.BLOCKS.add(this);
        ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(name));
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING , EnumFacing.NORTH));
    }

    @Override
    public void registerModels() {
        scpua.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }

    //Removes X-ray effect
    @Override
    public boolean isOpaqueCube(IBlockState state) { return fullCube; }

    //Removes in block shadows
    @Override
    public boolean isFullCube(IBlockState state) { return fullCube; }

    //Allows transparency
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.CUTOUT;
    }

    /**
     * Collision Sector
     * 1 = Bin
     * 2 = Rail
     * 3 = PowerBox
     * 4 = Fire Ext
     */

    public static AxisAlignedBB BASE_AABB = new AxisAlignedBB(0, 0, 0, 0, 0, 0); //Used for Returning
    public static AxisAlignedBB BIN_AABB = new AxisAlignedBB(0, 0, 0, 0, 0, 0);
    public static AxisAlignedBB RAIL_AABB = new AxisAlignedBB(0, 0, 0, 0, 0, 0);
    public static AxisAlignedBB POWER_AABB = new AxisAlignedBB(0, 0, 0, 0, 0, 0);
    public static AxisAlignedBB FIRE_EXT_AABB = new AxisAlignedBB(0, 0, 0, 0, 0, 0);

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        switch ((EnumFacing) state.getValue(BlockHorizontal.FACING)){
            case NORTH:
                BIN_AABB = new AxisAlignedBB(0.0625 * 4, 0, 0.0625 * 8, 0.0625 * 12, 0.0625 * 16, 0.0625 * 15);
                RAIL_AABB = new AxisAlignedBB(0.0625 * 16, 0, 0.0625 * 13, 0, 0.0625 * 16, 0.0625 * 15);
                POWER_AABB = new AxisAlignedBB(0.0625 * 2.5, 0.03125, 0.0625 * 14.5, 0.0625 * 13.5, 0.0625 * 16.5, 0.0625 * 16.5);
                FIRE_EXT_AABB = new AxisAlignedBB(0.0625 * 12, 0.0625, 0.0625 * 9, 0.0625 * 4, 0.0625 * 17, 0.0625 * 16);
                break;
            case SOUTH:
                BIN_AABB = new AxisAlignedBB(0.0625 * 4, 0, 0.0625, 0.0625 * 12, 0.0625 * 16, 0.0625 * 8);
                RAIL_AABB = new AxisAlignedBB(0.0625 * 16, 0, 0.0625, 0, 0.0625 * 16, 0.0625 * 3);
                POWER_AABB = new AxisAlignedBB(0.0625 * 2.5, 0.03125, 0.0625 * 1.5, 0.0625 * 13.5, 0.0625 * 16.5, -0.03125);
                FIRE_EXT_AABB = new AxisAlignedBB(0.0625 * 4, 0.0625, 0, 0.0625 * 12, 0.0625 * 17, 0.0625 * 7);
                break;
            case EAST:
                BIN_AABB = new AxisAlignedBB(0.0625, 0, 0.0625 * 4, 0.0625 * 8, 0.0625 * 16, 0.0625 * 12);
                RAIL_AABB = new AxisAlignedBB(0.0625 * 3, 0, 0, 0.0625, 0.0625 * 16, 0.0625 * 16);
                POWER_AABB = new AxisAlignedBB(-0.03125, 0.03125, 0.0625 * 2.5, 0.0625 * 1.5, 0.0625 * 16.5, 0.0625 * 13.5);
                FIRE_EXT_AABB = new AxisAlignedBB(0, 0.0625, 0.0625 * 4, 0.0625 * 7, 0.0625 * 17, 0.0625 * 12);
                break;
            case WEST:
                BIN_AABB = new AxisAlignedBB(0.0625 * 15, 0, 0.0625 * 4, 0.0625 * 8, 0.0625 * 16, 0.0625 * 12);
                RAIL_AABB = new AxisAlignedBB(0.0625 * 15, 0, 0, 0.0625 * 13, 0.0625 * 16, 0.0625 * 16);
                POWER_AABB = new AxisAlignedBB(0.0625 * 16.5, 0.03125, 0.0625 * 2.5, 0.0625 * 14.5, 0.0625 * 16.5, 0.0625 * 13.5);
                FIRE_EXT_AABB = new AxisAlignedBB(0.0625 * 16, 0.0625, 0.0625 * 4, 0.0625 * 9, 0.0625 * 17, 0.0625 * 12);
        }

        if(collisSet == 1) BASE_AABB = BIN_AABB; //Bin
        if(collisSet == 2) BASE_AABB = RAIL_AABB; //Rail
        if(collisSet == 3) BASE_AABB = POWER_AABB; //Power Box
        if(collisSet == 4) BASE_AABB = FIRE_EXT_AABB; //Fire Extinguisher

        return BASE_AABB;
    }

    /**
     * Rotating Sector
     *
     * Called after the block is set in the Chunk data, but before the Tile Entity is set
     */
    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state)
    {
        this.setDefaultFacing(worldIn, pos, state);
    }

    private void setDefaultFacing(World worldIn, BlockPos pos, IBlockState state)
    {
        if (!worldIn.isRemote)
        {
            IBlockState iblockstate = worldIn.getBlockState(pos.north());
            IBlockState iblockstate1 = worldIn.getBlockState(pos.south());
            IBlockState iblockstate2 = worldIn.getBlockState(pos.west());
            IBlockState iblockstate3 = worldIn.getBlockState(pos.east());
            EnumFacing enumfacing = (EnumFacing)state.getValue(FACING);

            if (enumfacing == EnumFacing.NORTH && iblockstate.isFullBlock() && !iblockstate1.isFullBlock()) { enumfacing = EnumFacing.SOUTH; }
            else if (enumfacing == EnumFacing.SOUTH && iblockstate1.isFullBlock() && !iblockstate.isFullBlock()) { enumfacing = EnumFacing.NORTH; }
            else if (enumfacing == EnumFacing.WEST && iblockstate2.isFullBlock() && !iblockstate3.isFullBlock()) { enumfacing = EnumFacing.EAST; }
            else if (enumfacing == EnumFacing.EAST && iblockstate3.isFullBlock() && !iblockstate2.isFullBlock()) { enumfacing = EnumFacing.WEST; }

            worldIn.setBlockState(pos, state.withProperty(FACING, enumfacing), 2);
        }
    }

    /**
     * This part basically makes it possible to keep the data stored...... It makes it so blocks dont reset when you reload map
     */
    public IBlockState getStateFromMeta(int meta)
    {
        EnumFacing enumfacing = EnumFacing.getFront(meta);

        if (enumfacing.getAxis() == EnumFacing.Axis.Y) { enumfacing = EnumFacing.NORTH; }

        return this.getDefaultState().withProperty(FACING, enumfacing);
    }

    /**
     * Convert the BlockState into the correct metadata value
     */
    public int getMetaFromState(IBlockState state) {
        return ((EnumFacing)state.getValue(FACING)).getIndex();
    }

    /**
     * Returns the blockstate with the given rotation from the passed blockstate. If inapplicable, returns the passed
     * blockstate.
     */
    public IBlockState withRotation(IBlockState state, Rotation rot) {
        return state.withProperty(FACING, rot.rotate((EnumFacing)state.getValue(FACING)));
    }

    /**
     * Returns the blockstate with the given mirror of the passed blockstate. If inapplicable, returns the passed
     * blockstate.
     */
    public IBlockState withMirror(IBlockState state, Mirror mirrorIn) {
        return state.withRotation(mirrorIn.toRotation((EnumFacing)state.getValue(FACING)));
    }

    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, new IProperty[] {FACING});
    }

    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
        worldIn.setBlockState(pos, state.withProperty(FACING, placer.getHorizontalFacing().getOpposite()), 2);
    }
}
