package gus.overtime.tileentity;

import elucent.albedo.Albedo;
import elucent.albedo.lighting.ILightProvider;
import elucent.albedo.lighting.Light;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

//TODO
public class AlbedoCL extends NoAlbedoCL {
    public int getColourFromID(int id) {
        //if (id == 1) return 0xFF0000;
        //if (id == 2) return 0x00FF00;
        //if (id == 3) return 0x0000FF;
        return 0xFF0000;
    }
    public ILightProvider cap = (gatherLightsEvent, entity) -> gatherLightsEvent.add(
            Light.builder().
                    pos(getPos()).
                    color(getColourFromID(colorIndex), false).
                    radius(15).
                    build()
    );

    @Override
    public boolean hasCapability(@Nonnull Capability<?> capability, @Nullable EnumFacing facing) {
        return super.hasCapability(capability, facing) || (capability == Albedo.LIGHT_PROVIDER_CAPABILITY);
    }

    @Nullable
    @Override
    public <T> T getCapability(@Nonnull Capability<T> capability, @Nullable EnumFacing facing) {
        return capability == Albedo.LIGHT_PROVIDER_CAPABILITY? Albedo.LIGHT_PROVIDER_CAPABILITY.cast(cap) : super.getCapability(capability, facing);
    }
}
