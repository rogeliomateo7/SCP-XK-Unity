package gus.overtime.init;

import gus.overtime.entity.scp.EntitySCP049;
import gus.overtime.entity.scp.EntitySCP076_2;
import gus.overtime.entity.scp.EntitySCP999;
import gus.overtime.Overtime;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class EntityInit {

    public static void registerEntities() {
        int entityID = 0;
        registerEntity("scp049", EntitySCP049.class, entityID++, 15, 808080, 404040);
        registerEntity("scp999", EntitySCP999.class, entityID++, 15, 808080, 404040);
        registerEntity("scp076-2", EntitySCP076_2.class, entityID++, 15, 000000, 111111);
    }

    private static void registerEntity(String name, Class<? extends Entity> entity, int id, int range, int color1, int color2) {
        EntityRegistry.registerModEntity(new ResourceLocation(Overtime.MODID + ":" + name), entity, name, id, Overtime.instance, range, 1, true, color1, color2);
    }

    private static void registerNonMobEntity() {

    }
}
