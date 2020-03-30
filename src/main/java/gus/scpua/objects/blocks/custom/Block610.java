package gus.scpua.objects.blocks.custom;

import gus.scpua.init.BlockInit;
import gus.scpua.objects.blocks.BlockBase;
import gus.scpua.util.handlers.XKConfigHandler;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Block610 extends BlockBase {
    public Block610(String name, Material material, int inv) {
        super(name, material, inv);

        setHarvestLevel("shovel", 1);

        //Enable Spread based on config
        if (XKConfigHandler.SPREAD_610) setTickRandomly(true);
        else setTickRandomly(false);
    }

    @Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
        if (!worldIn.isAreaLoaded(pos, 1)) return;

        //Random Number On what face to do
        int whatFace = ThreadLocalRandom.current().nextInt(0, 5 + 1);

        BlockPos face;

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

            //Correct Block
            if (worldIn.getBlockState(new BlockPos(face)).getBlock() == Blocks.DIRT.getDefaultState().getBlock()
                    || worldIn.getBlockState(new BlockPos(face)).getBlock() == Blocks.GRASS.getDefaultState().getBlock()
                    || worldIn.getBlockState(new BlockPos(face)).getBlock() == Blocks.GRASS_PATH.getDefaultState().getBlock()
                    || worldIn.getBlockState(new BlockPos(face)).getBlock() == Blocks.COBBLESTONE.getDefaultState().getBlock()
                    || worldIn.getBlockState(new BlockPos(face)).getBlock() == Blocks.MOSSY_COBBLESTONE.getDefaultState().getBlock()
                    || worldIn.getBlockState(new BlockPos(face)).getBlock() == Blocks.LOG.getDefaultState().getBlock()
                    || worldIn.getBlockState(new BlockPos(face)).getBlock() == Blocks.PLANKS.getDefaultState().getBlock()) break;

            //Incorrect Block
            whatFace = ThreadLocalRandom.current().nextInt(0, 5 + 1);
            attempt = attempt + 1;
            if (attempt == 10) return;
        }

        IBlockState Block = BlockInit.SCP610A.getDefaultState();
        double spawnChance = Math.random() * 100;

        if (spawnChance > 30) Block = BlockInit.SCP610A.getDefaultState();
        if (spawnChance < 30) Block = BlockInit.SCP610B.getDefaultState();

        worldIn.setBlockState(face, Block);
    }
}