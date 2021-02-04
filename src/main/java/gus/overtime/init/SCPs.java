package gus.overtime.init;

import gus.overtime.client.models.Model049;
import gus.overtime.entity.scp.EntitySCP049;
import gus.overtime.entity.scp.EntitySCP999;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;

public class SCPs {
    //TODO This class will be responsible for registering SCPs with:
    //  Entity
    //  Knowledge (if we gonna do it)
    //  Structure
    //  Classification
    //  And more

    public SCPs() {
        register("scp049", EntitySCP049.class, Model049.class);
        //register("scp999", EntitySCP999.class);
    }

    private void register(String name, Class<? extends Entity> entity, Class<? extends ModelBase> model) {
    }
}
