package gus.scpua.init.blocks;

import gus.scpua.blocks.BlockBase;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import java.util.ArrayList;
import java.util.List;

public class Site93 {
    public static final List<Block> S93BLOCKS = new ArrayList<Block>();

    //MAJOR Inconsistency with names and files
    public static final Block LCZ_FLOOR_A = new BlockBase(3,"lczfloora", Material.IRON, 4);
    public static final Block LCZ_FLOOR_B = new BlockBase(3,"lczfloorb", Material.IRON, 4);
    public static final Block LCZ_BASE = new BlockBase(3,"lczbase", Material.IRON, 4);
    public static final Block LCZ_BOTTOM = new BlockBase(3,"lczbottom", Material.IRON, 4);
    public static final Block LCZ_MIDDLE = new BlockBase(3,"lczmiddle", Material.IRON, 4);
    public static final Block LCZ_TOP = new BlockBase(3,"lcztop", Material.IRON, 4);

    public static final Block HCZ_FLOOR = new BlockBase(3,"hczfloor", Material.IRON, 4);
    public static final Block HCZ_BASE = new BlockBase(3,"hczbase", Material.IRON, 4);
    public static final Block HCZ_MIDDLE = new BlockBase(3,"hczmiddle", Material.IRON, 4);
    public static final Block HCZ_TOP = new BlockBase(3,"hcztop", Material.IRON, 4);

    public static final Block ECZ_BASE = new BlockBase(3,"eczbase", Material.ROCK, 4);
    public static final Block ECZ_MIDDLE = new BlockBase(3,"eczmiddle", Material.ROCK, 4);
    public static final Block ECZ_TOP = new BlockBase(3,"ecztop", Material.ROCK, 4);

    public static final Block SHCZ_FLOOR = new BlockBase(3,"shczfloor", Material.IRON, 4);
    public static final Block SHCZ_MIDDLE = new BlockBase(3,"shczmiddle", Material.IRON, 4);
    public static final Block SHCZ_TOP = new BlockBase(3,"shczupper", Material.IRON, 4);
    public static final Block SHCZ_WALL = new BlockBase(3,"shczwall", Material.IRON, 4);
}
