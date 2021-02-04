package gus.overtime.blocks.custom;

import gus.overtime.blocks.XKBlock;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

import static gus.overtime.Overtime.TAB_OVERTIME;

public class XKMetalicHydrogen extends XKBlock {
    public XKMetalicHydrogen() {
        super("metallichydrogen", TAB_OVERTIME);
        this.setTickRandomly(true);
    }

    @Override
    public void onBlockHarvested(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player) {
        if (!player.isCreative()) {
            worldIn.createExplosion(null, pos.getX() + .5, pos.getY() + .5, pos.getZ() + .5, 4F, true);
            worldIn.playSound(null, pos, SoundEvents.ENTITY_GENERIC_EXPLODE, SoundCategory.BLOCKS, 1, 1);
        }
    }

    @Override
    public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand) {
        double x = (double)pos.getX() + .5;
        double y = (double)pos.getY() + .5;
        double z = (double)pos.getZ() + .5;

        double[] d = new double[4];
        for (int i = 0; i < 4; i++) d[i] = rand.nextBoolean() ? (-rand.nextDouble() + 0.45) : (rand.nextDouble() - 0.45);

        worldIn.spawnParticle(EnumParticleTypes.CLOUD, x, y, z, d[rand.nextInt(4)], rand.nextDouble() - 0.3, d[rand.nextInt(4)]);
        worldIn.spawnParticle(EnumParticleTypes.CLOUD, x, y, z, d[rand.nextInt(4)], rand.nextDouble() - 0.3, d[rand.nextInt(4)]);
        worldIn.spawnParticle(EnumParticleTypes.CLOUD, x, y, z, d[rand.nextInt(4)], rand.nextDouble() - 0.3, d[rand.nextInt(4)]);
        worldIn.spawnParticle(EnumParticleTypes.CLOUD, x, y, z, d[rand.nextInt(4)], rand.nextDouble() - 0.3, d[rand.nextInt(4)]);
    }

    @Override
    public int quantityDropped(Random random) {
        return 0;
    }
}
