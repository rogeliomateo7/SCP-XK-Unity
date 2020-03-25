package gus.scpua.objects.blocks.custom;

import gus.scpua.objects.blocks.rotation.NSEWBlock;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Coffin076 extends NSEWBlock {

    public static final PropertyEnum<Coffin076.EnumCoffinBlock> RIGHTSIDE = PropertyEnum.create("right", EnumCoffinBlock.class);
    public static final PropertyEnum<Coffin076.EnumCoffinBlock> LEFTSIDE = PropertyEnum.create("left", EnumCoffinBlock.class);

    public Coffin076(String name, Material material, int inv, boolean fullcube, int collision) {
        super(name, material, inv, fullcube, collision);
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        return super.onBlockActivated(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
    }

    public static enum EnumCoffinBlock implements IStringSerializable {
        RIGHT,
        MIDDLE,
        LEFT;

        @Override
        public String toString() { return this.getName(); }

        @Override
        public String getName() { return this == LEFT ? "left" : this == MIDDLE ? "middle" : "right"; }

    }
}
