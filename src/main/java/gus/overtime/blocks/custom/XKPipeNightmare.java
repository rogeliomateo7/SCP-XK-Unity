package gus.overtime.blocks.custom;

import gus.overtime.blocks.XKBlockDirectional;
import gus.overtime.Overtime;
import gus.overtime.util.DamageSrc;
import gus.overtime.util.handlers.XKSoundHandler;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Random;

public class XKPipeNightmare extends XKBlockDirectional {
    public XKPipeNightmare() {
        super("pipenightmare", Overtime.TAB_OVERTIME, Material.IRON);
    }

    private ArrayList<EntityPlayer> player= new ArrayList<>();

    @Override
    public void onBlockClicked(World worldIn, BlockPos pos, EntityPlayer playerIn) {
        if (!worldIn.isRemote) {
            if (playerIn.isCreative()) return;
            player.add(playerIn);
        }
        worldIn.scheduleUpdate(pos, worldIn.getBlockState(pos).getBlock(), 20);
    }

    @Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
        try {
            for (EntityPlayer e : player) {
                if (e.isDead) {
                    player.remove(e);
                    continue;
                }
                if (e.isSwingInProgress) {
                    e.addPotionEffect(new PotionEffect(MobEffects.POISON, 100, 2)); //Add Damage increase element
                    e.attackEntityFrom(DamageSrc.PIPENIGHT, 2);
                    worldIn.playSound(null, pos, XKSoundHandler.SCP015_STEAM, SoundCategory.AMBIENT, 1F, 1F);
                    worldIn.scheduleUpdate(pos, worldIn.getBlockState(pos).getBlock(), 20);
                } else {
                    player.remove(e);
                }
            }
        } catch (Exception ignored) { player.clear(); }
    }

    private final AxisAlignedBB
            UD_PN_AABB = new AxisAlignedBB(0.0625 * 2, 0, 0.0625 * 2, 0.0625 * 14, 0.0625 * 16, 0.0625 * 14),
            NS_PN_AABB = new AxisAlignedBB(0.0625 * 2, 0.0625 * 2, 0, 0.0625 * 14, 0.0625 * 14, 0.0625 * 16),
            EW_PN_AABB = new AxisAlignedBB(0, 0.0625 * 2, 0.0625 * 2, 0.0625 * 16, 0.0625 * 14, 0.0625 * 14);

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        switch (state.getValue(FACING)) {
            case UP: case DOWN: default: return UD_PN_AABB;
            case NORTH: case SOUTH: return NS_PN_AABB;
            case EAST: case WEST: return EW_PN_AABB;
        }
    }
}
