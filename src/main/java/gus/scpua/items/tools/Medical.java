package gus.scpua.items.tools;

import gus.scpua.init.ItemInit;
import gus.scpua.items.ItemBase;
import gus.scpua.util.enums.XKInventory;
import gus.scpua.util.handlers.XKSoundHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class Medical extends ItemBase {

    private final MedicalTool medTool;

    public Medical(String name, int maxStack, MedicalTool tool) {
        super(name, XKInventory.Weapon);
        maxStackSize = maxStack;
        this.medTool = tool;
    }

    //FIXME OMG PLEASE
    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        if (playerIn.isCreative()) return super.onItemRightClick(worldIn, playerIn, handIn);

        playerIn.inventory.getCurrentItem().shrink(1);

        switch (medTool) {
            case MEDKIT:
                playerIn.heal(5.0F); //2 and a half

                SoundEvent sound = XKSoundHandler.MEDKIT;
                float pitch = worldIn.rand.nextFloat() * 0.1F + 0.9F;
                if ((Math.random() * 100) <= 1) {
                    sound = XKSoundHandler.HLMEDKIT;
                    pitch = 1F;
                }
                worldIn.playSound(null, playerIn.posX, playerIn.posY, playerIn.posZ, sound, SoundCategory.PLAYERS, 0.5F, pitch);
                break;
            case PK_CONTAINER:
                for (int i = 0; i < 5; i++) {
                    playerIn.addItemStackToInventory(ItemInit.PK_PILL.getDefaultInstance());
                }
                break;
            case PK_PILL:
                playerIn.heal(2.0F); //1 heart (seems too OP since you get 5)
                worldIn.playSound(null, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.ENTITY_GENERIC_EAT, SoundCategory.PLAYERS,1.0F, worldIn.rand.nextFloat() * 0.1F + 0.9F);
            case ADREN:
                playerIn.addPotionEffect(new PotionEffect(MobEffects.SPEED, 2000, 1));
                break;
            case BANDAGE:
                playerIn.heal(4.0F); //2 Hearts
        }

        return super.onItemRightClick(worldIn, playerIn, handIn);
    }

    public enum MedicalTool {
        MEDKIT, PK_CONTAINER, PK_PILL, ADREN, BANDAGE
    }
}
