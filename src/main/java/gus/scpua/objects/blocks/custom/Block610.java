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
        if (XKConfigHandler.SPREAD_610) setTickRandomly(true);
        else setTickRandomly(false);
    }

    @Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
        if (!worldIn.isAreaLoaded(pos, 1)) return;

        //System.out.println("Tick called");
        if (!XKConfigHandler.SPREAD_610) return; //Stops before anything happens
        //System.out.println("Passed Config Check");

        //Random Number On what face to do
        int whatFace = ThreadLocalRandom.current().nextInt(0, 5 + 1);

        //System.out.println(whatFace);

        BlockPos face = pos.up();


        int attempt = 0;
        boolean canPlace = false;
        while (!canPlace) { //It says its always true but its not, ignore it
            if (!state.isNormalCube()) return;

            if (whatFace == 0) { face = pos.up(); } //Up
            if (whatFace == 1) { face = pos.down(); }  //Down
            if (whatFace == 2) { face = pos.north(); } //North
            if (whatFace == 3) { face = pos.south(); } //South
            if (whatFace == 4) { face = pos.east(); } //East
            if (whatFace == 5) { face = pos.west(); } //West

            if (worldIn.getBlockState(new BlockPos(face)).getBlock() == Blocks.DIRT.getStateFromMeta(0).getBlock() || worldIn.getBlockState(new BlockPos(face)).getBlock() == Blocks.GRASS.getStateFromMeta(0).getBlock()) {
                canPlace = true;
                break;
            }
            whatFace = ThreadLocalRandom.current().nextInt(0, 5 + 1);
           // System.out.println("face not correct, retrying with " + whatFace);
            //System.out.println("attempt " + attempt);
            attempt = attempt + 1;
            if (attempt == 10) {
                //System.out.println("Unable to place Block");
                return;
            }
        }

        IBlockState whatBlock;
        whatBlock = new Random().nextBoolean() ? BlockInit.SCP610A.getDefaultState() : BlockInit.SCP610B.getDefaultState();

        worldIn.setBlockState(face, whatBlock);
        //System.out.println("Placed 610");
        canPlace = false;
    }
}
