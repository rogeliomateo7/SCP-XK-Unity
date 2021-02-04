package gus.overtime.items.armour;

import gus.overtime.client.InputHandler;
import gus.overtime.init.ItemInit;
import gus.overtime.proxy.ClientProxy;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class COMSuit extends ItemArmor {

    public String textureName;

    public COMSuit(String name, ItemArmor.ArmorMaterial material, EntityEquipmentSlot equipmentSlotIn) {
        super(material, 0, equipmentSlotIn);
        this.textureName = name;
        setUnlocalizedName(name);
        setRegistryName(name);

        ItemInit.ITEMS.add(this);
    }

    @Nullable
    @Override
    public CreativeTabs getCreativeTab() { return null; }

    //Logic Section
    public static boolean keyToggle = false;
    public static String texture;
    public static String head;
    public static String chest;
    public static String leg;
    public static String feet;

    //FIXME Probably a better way to do this
    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
        super.onArmorTick(world, player, itemStack);

        if (InputHandler.COM_SUIT.isPressed()) {
            if (checkInv(player)) keyToggle = !keyToggle; //If suit on, can toggle
        }

        //if toggle on and suit on...
        if (checkInv(player) && keyToggle) {
            player.addPotionEffect(new PotionEffect(MobEffects.INVISIBILITY, 20, 0, false, false)); //Add Potion Effect

            //May need to send packet to server
        } else {
            player.removePotionEffect(MobEffects.INVISIBILITY);//Remove effect
            keyToggle = false;//Set Toggle To false if Suit not on
        }
    }

    //FIXME Known bug... might change how it works
    @Nullable
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type) {
        if (keyToggle) {
            if (textureName.equals("coms_helmet") || textureName.equals("coms_chestplate") || textureName.equals("coms_boots"))
                texture = "scpua:textures/models/armor/coms_layer_3.png";
            if (textureName.equals("coms_leggings")) texture = "scpua:textures/models/armor/coms_layer_4.png";
        } else {
            if (textureName.equals("coms_helmet") || textureName.equals("coms_chestplate") || textureName.equals("coms_boots"))
                texture = "scpua:textures/models/armor/coms_layer_1.png";
            if (textureName.equals("coms_leggings")) texture = "scpua:textures/models/armor/coms_layer_2.png";
        }
        return texture;
    }

    //Checks inventory when called and returns true if all are COMs
    public boolean checkInv(EntityPlayer player) {
        head = player.inventory.armorInventory.get(3).getUnlocalizedName();
        chest = player.inventory.armorInventory.get(2).getUnlocalizedName();
        leg = player.inventory.armorInventory.get(1).getUnlocalizedName();
        feet = player.inventory.armorInventory.get(0).getUnlocalizedName();
        return head.equals("item.coms_helmet") && chest.equals("item.coms_chestplate") && leg.equals("item.coms_leggings") && feet.equals("item.coms_boots");
    }

    @Nullable
    @Override
    public NBTTagCompound getNBTShareTag(ItemStack stack) {
        return super.getNBTShareTag(stack);
    }
}
