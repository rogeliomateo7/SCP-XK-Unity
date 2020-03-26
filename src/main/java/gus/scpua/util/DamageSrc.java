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
    private boolean electrocution;
    private boolean isUnblockable;
    public String damageType;

    public boolean isUnblockable() {
        return this.isUnblockable;
    }

    public DamageSource setDamageBypassesArmor() {
        this.isUnblockable = true;
        return this;
    }

    //This is the thing that puts "death.attack.electrocution" in chat for all i know
    public ITextComponent getDeathMessage(EntityLivingBase entityLivingBaseIn) {
        EntityLivingBase entitylivingbase = entityLivingBaseIn.getAttackingEntity();
        String s = "death.attack." + this.damageType;
        String s1 = s + ".player";
        return entitylivingbase != null && I18n.canTranslate(s1) ? new TextComponentTranslation(s1, new Object[]{entityLivingBaseIn.getDisplayName(), entitylivingbase.getDisplayName()}) : new TextComponentTranslation(s, new Object[]{entityLivingBaseIn.getDisplayName()});
    }

    public String getDamageType() {
        return this.damageType;
    }

    public boolean isMagicDamage() {
        return this.electrocution;
    }
}
