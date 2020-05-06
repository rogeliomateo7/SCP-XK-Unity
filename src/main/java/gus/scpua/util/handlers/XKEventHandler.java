package gus.scpua.util.handlers;

import gus.scpua.util.DamageSrc;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

@Mod.EventBusSubscriber
public class XKEventHandler {
//Used for Events that are handled by Multiple Objects

    private int tick = 0; // What tick the game is on
    //private int ticks = 0; // How many ticks have there been? (meant for some SPC's) max number is 200

    public static World worldIn; //World
    public static EntityPlayer playerIn; //Who?
    public static BlockPos blockPos; //Block Position

    public static boolean pnHit = false; //Pipe Nightmare hit?


    @SubscribeEvent
    public void generalTick(TickEvent.WorldTickEvent tickEvent) {
        if (tick != 20) tick = tick + 1;
        else tick = 0;

        //Pipe Nightmare
        {
            int pnAmp = 1;
            if (pnHit) {
                if (!playerIn.isSwingInProgress || playerIn.isCreative() || playerIn.isDead) { pnHit = false; return; } //Reset

                playerIn.addPotionEffect(new PotionEffect(MobEffects.POISON, 100, 2)); //Add Damage increase element
                playerIn.attackEntityFrom(DamageSrc.PIPENIGHT, 2); //Change Damage Source
                worldIn.playSound(null, blockPos, XKSoundHandler.SCP015_STEAM, SoundCategory.AMBIENT, 1F, 1F);
            }
        }

    }
}
