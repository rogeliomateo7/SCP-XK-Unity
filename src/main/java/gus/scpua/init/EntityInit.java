package gus.scpua.init;

import gus.scpua.entity.living.scp.scp049.EntitySCP049;
import gus.scpua.scpua;
import gus.scpua.util.Reference;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class EntityInit {

    public static void registerEntities() {
        registerEntity("scp049", EntitySCP049.class, Reference.ENTITY_049, 1, 808080, 404040);
    }

    private static void registerEntity(String name, Class<? extends Entity> entity, int id, int range, int color1, int color2) {
        EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID + ":" + name), entity, name, id, scpua.instance, range, 1, true, color1, color2);
    }
}
