package gus.scpua.objects.items.tools;

import gus.scpua.objects.items.ItemBase;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class Crowbar extends ItemBase {
    public Crowbar(String name) {
        super(name);
    }

    @Override
    public void onPlayerStoppedUsing(ItemStack stack, World worldIn, EntityLivingBase entityLiving, int timeLeft) {
        System.out.println("STOPPED USING CROWBAR");
        super.onPlayerStoppedUsing(stack, worldIn, entityLiving, timeLeft);
    }

    @Override
    public void onUsingTick(ItemStack stack, EntityLivingBase player, int count) {
        System.out.println("USING CROWBAR");
        super.onUsingTick(stack, player, count);
    }
}
