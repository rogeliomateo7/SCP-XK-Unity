/*
package apocalypse_craft.block;

import gus.scpua.util.handlers.XKSoundHandler;
import net.minecraft.block.BlockDoor;
import net.minecraft.util.*;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.world.World;
import net.minecraft.world.IBlockAccess;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.Item;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.EnumPushReaction;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.Block;

import apocalypse_craft.item.ItemMetalScrap;

import apocalypse_craft.creativetab.TabApocalypseCraft;

import apocalypse_craft.ElementsApocalypseCraft;

import java.util.Random;

@ElementsApocalypseCraft.ModElement.Tag
public class BlockSaferoomDoor extends ElementsApocalypseCraft.ModElement {
    @GameRegistry.ObjectHolder("apocalypse_craft:saferoomdoor")
    public static final Block block = null;
    public BlockSaferoomDoor(ElementsApocalypseCraft instance) {
        super(instance, 139);
    }

    @Override
    public void initElements() {
        elements.blocks.add(() -> new BlockCustom().setRegistryName("saferoomdoor"));
        elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerModels(ModelRegistryEvent event) {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0,
                new ModelResourceLocation("apocalypse_craft:saferoomdoor", "inventory"));
    }



    public static class BlockCustom extends BlockDoor {

        public BlockCustom() {
            super(Material.IRON);
            setUnlocalizedName("saferoomdoor");
            setSoundType(SoundType.METAL);
            setHarvestLevel("pickaxe", 2);
            setHardness(3.5F);
            setResistance(10F);
            setLightLevel(0F);
            setLightOpacity(255);
            setCreativeTab(TabApocalypseCraft.tab);
        }

        @Override
        public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
            BlockPos blockpos = state.getValue(HALF) == BlockDoor.EnumDoorHalf.LOWER ? pos : pos.down();
            IBlockState iblockstate = pos.equals(blockpos) ? state : worldIn.getBlockState(blockpos);
            if (iblockstate.getBlock() != this) {
                return false;
            } else {
                state = iblockstate.cycleProperty(OPEN);
                worldIn.setBlockState(blockpos, state, 10);
                worldIn.markBlockRangeForRenderUpdate(blockpos, pos);
                worldIn.playSound(null, pos, (state.getValue(OPEN) ? getOpenSound() : getCloseSound()), SoundCategory.BLOCKS, 1, 1);

                if (state.getValue(OPEN)) {
                    worldIn.scheduleUpdate(pos, worldIn.getBlockState(pos).getBlock(), 70);
                }

                return true;
            }
        }

        @Override
        public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
            if (state.getValue(OPEN)) {
                BlockPos blockpos = state.getValue(HALF) == BlockDoor.EnumDoorHalf.LOWER ? pos : pos.down();
                IBlockState iblockstate = pos.equals(blockpos) ? state : worldIn.getBlockState(blockpos);

                if (iblockstate.getBlock() == this) {
                    state = iblockstate.cycleProperty(OPEN);
                    worldIn.setBlockState(blockpos, state, 10);
                    worldIn.markBlockRangeForRenderUpdate(blockpos, pos);
                    worldIn.playSound(null, pos, getCloseSound(), SoundCategory.BLOCKS, 1, 1);
                }
            }
        }

        //TODO Replace these with your open and close sounds
        private SoundEvent getCloseSound() { return SoundEvent.REGISTRY.getObject(new ResourceLocation("apocalypse_craft:saferoomdoor.close")); }
        private SoundEvent getOpenSound() { return SoundEvent.REGISTRY.getObject(new ResourceLocation("apocalypse_craft:saferoomdoor.open")); }

        @Override
        public MapColor getMapColor(IBlockState state, IBlockAccess blockAccess, BlockPos pos) {
            return MapColor.IRON;
        }

        @Override
        public boolean canSilkHarvest(World world, BlockPos pos, IBlockState state, EntityPlayer player) {
            return false;
        }

        @Override
        public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
            drops.add(new ItemStack(ItemMetalScrap.block, (int) (10)));
        }
    }
}

 */
