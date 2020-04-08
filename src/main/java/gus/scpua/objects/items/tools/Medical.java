package gus.scpua.objects.items.tools;

import gus.scpua.init.ItemInit;
import gus.scpua.objects.items.ItemBase;
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
    public Medical(String name, int maxStack) {
        super(name);
        maxStackSize = maxStack;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        if (playerIn.isCreative()) return super.onItemRightClick(worldIn, playerIn, handIn);
        if (this == ItemInit.MEDKIT) {
            playerIn.heal(5.0F); //2 and a half

            SoundEvent sound = XKSoundHandler.MEDKIT;
            float pitch = worldIn.rand.nextFloat() * 0.1F + 0.9F;
            double random = Math.random() * 100;
            if (random < 1) { sound = XKSoundHandler.HLMEDKIT; pitch = 1F; }
            worldIn.playSound(null, playerIn.posX, playerIn.posY, playerIn.posZ, sound, SoundCategory.PLAYERS,0.5F, pitch);
        } else

        if (this == ItemInit.PK_CONTAINER) {
            playerIn.addItemStackToInventory(ItemInit.PK_PILL.getDefaultInstance());
            playerIn.addItemStackToInventory(ItemInit.PK_PILL.getDefaultInstance());
            playerIn.addItemStackToInventory(ItemInit.PK_PILL.getDefaultInstance());
            playerIn.addItemStackToInventory(ItemInit.PK_PILL.getDefaultInstance());
            playerIn.addItemStackToInventory(ItemInit.PK_PILL.getDefaultInstance());
        } else

        if (this == ItemInit.PK_PILL) {
            playerIn.heal(2.0F); //1 heart (seems too OP since you get 5)
            worldIn.playSound(null, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.ENTITY_GENERIC_EAT, SoundCategory.PLAYERS,1.0F, worldIn.rand.nextFloat() * 0.1F + 0.9F);
        } else

        if (this == ItemInit.ADRENALINE) {
            playerIn.addPotionEffect(new PotionEffect(MobEffects.SPEED, 2000, 1));
        } else

        if (this == ItemInit.BANDAGE) {
            playerIn.heal(4.0F); //2 Hearts
        }

        playerIn.inventory.getCurrentItem().shrink(1);
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}
