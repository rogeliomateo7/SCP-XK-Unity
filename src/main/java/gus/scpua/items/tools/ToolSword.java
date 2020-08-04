package gus.scpua.items.tools;

import com.google.common.collect.Multimap;
import gus.scpua.init.ItemInit;
import gus.scpua.scpua;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

public class ToolSword extends ItemSword {
    public ToolSword(String name, ToolMaterial material) {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(scpua.tabweaponsscp);

        ItemInit.ITEMS.add(this);
    }

    /**
     * ngl i got this section from stack overflow (well majority of it)
     */
    @Override
    public Multimap<String, AttributeModifier> getAttributeModifiers(EntityEquipmentSlot slot, ItemStack stack) {
        final Multimap<String, AttributeModifier> modifiers = super.getAttributeModifiers(slot, stack);
        float damage = 0;
        float speed = 10;

        if (this == ItemInit.CROWBAR) { damage = 1.5F; speed = 1;}
        if (this == ItemInit.COMBATKNIFE) { damage = 2; speed = -2; }
        if (this == ItemInit.FIREAXE) { damage = 2.5F; speed = 1.1F; }
        if (this == ItemInit.BROKENPIPE) { damage = 2.2F; speed = 1.2F; }
        if (this == ItemInit.ABLESWORD) { damage = 3.3F; speed = 1.4F; }

        if (slot == EntityEquipmentSlot.MAINHAND) {
            replaceModifier(modifiers, SharedMonsterAttributes.ATTACK_DAMAGE, ATTACK_DAMAGE_MODIFIER, damage);
            replaceModifier(modifiers, SharedMonsterAttributes.ATTACK_SPEED, ATTACK_SPEED_MODIFIER, speed);
        }

        return modifiers;
    }

    private void replaceModifier(Multimap<String, AttributeModifier> modifierMultimap, IAttribute attribute, UUID id, double multiplier) {
        // Get the modifiers for the specified attribute
        final Collection<AttributeModifier> modifiers = modifierMultimap.get(attribute.getName());

        // Find the modifier with the specified ID, if any
        final Optional<AttributeModifier> modifierOptional = modifiers.stream().filter(attributeModifier -> attributeModifier.getID().equals(id)).findFirst();

        if (modifierOptional.isPresent()) { // If it exists,
            final AttributeModifier modifier = modifierOptional.get();
            modifiers.remove(modifier); // Remove it
            modifiers.add(new AttributeModifier(modifier.getID(), modifier.getName(), modifier.getAmount() * multiplier, modifier.getOperation())); // Add the new modifier
        }
    }
}
