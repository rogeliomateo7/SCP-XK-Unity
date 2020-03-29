package gus.scpua.objects.blocks.custom;

import gus.scpua.objects.blocks.rotation.UDNSEWBlock;
import net.minecraft.block.material.Material;

public class BlockLamp extends UDNSEWBlock {
    public BlockLamp(String name, Material material, int inv, boolean fullcube, int collision) {
        super(name, material, inv, fullcube, collision);

        setLightLevel(6.0F);
    }

    //Will add some red stone function later
}
