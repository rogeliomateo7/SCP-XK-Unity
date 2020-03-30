package gus.scpua.util;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.translation.I18n;

public class DamageSrc extends DamageSource {
    public DamageSrc(String damageTypeIn) {
        super(damageTypeIn);
    }

    public static final DamageSource ELECTROCUTED = (new DamageSource("electrocuted")).setDamageBypassesArmor();
    public static final DamageSource PIPENIGHT = (new DamageSource("pipenightmare")).setDamageBypassesArmor();
    private boolean isUnblockable;
    public String damageType;

    public boolean isUnblockable() {
        return this.isUnblockable;
    }

    public DamageSource setDamageBypassesArmor() {
        this.isUnblockable = true;
        return this;
    }

    public ITextComponent getDeathMessage(EntityLivingBase entityLivingBaseIn) {
        String deathMessage = "death.attack." + this.damageType;
        return new TextComponentTranslation(deathMessage);
    }

    public String getDamageType() {
        return this.damageType;
    }
}
