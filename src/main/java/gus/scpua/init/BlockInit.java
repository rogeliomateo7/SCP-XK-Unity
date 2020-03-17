package gus.scpua.init;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import gus.scpua.objects.blocks.*;

public class BlockInit {
	public static final List<Block> BLOCKS = new ArrayList<Block>();

	/*
	public static final Block BLOCK_IN_CAPS = new BlockBase("block_in_lowcase", Material., Tab);
	TABS
	1 = Lockdown unity
	2 = Tools scp
	3 = Unity cosmetics
	4 = Site-93
	*/

	//Site-98 Blocks MAJOR Discrepancy with names and files
	public static final Block LCZ_FLOOR_A = new BlockBase("lczfloora", Material.IRON, 4);
	public static final Block LCZ_FLOOR_B = new BlockBase("lczfloorb", Material.IRON, 4);
	public static final Block LCZ_BASE = new BlockBase("lczbase", Material.IRON, 4);
	public static final Block LCZ_BOTTOM = new BlockBase("lczbottom", Material.IRON, 4);
	public static final Block LCZ_MIDDLE = new BlockBase("lczmiddle", Material.IRON, 4);
	public static final Block LCZ_TOP = new BlockBase("lcztop", Material.IRON, 4);

	public static final Block HCZ_FLOOR = new BlockBase("hczfloor", Material.IRON, 4);
	public static final Block HCZ_BASE = new BlockBase("hczbase", Material.IRON, 4);
	public static final Block HCZ_MIDDLE = new BlockBase("hczmiddle", Material.IRON, 4);
	public static final Block HCZ_TOP = new BlockBase("hcztop", Material.IRON, 4);

	public static final Block ECZ_BASE = new BlockBase("eczbase", Material.ROCK, 4);
	public static final Block ECZ_MIDDLE = new BlockBase("eczmiddle", Material.ROCK, 4);
	public static final Block ECZ_TOP = new BlockBase("ecztop", Material.ROCK, 4);

	public static final Block SHCZ_FLOOR = new BlockBase("shczfloor", Material.IRON, 4);
	public static final Block SHCZ_MIDDLE = new BlockBase("shczmiddle", Material.IRON, 4);
	public static final Block SHCZ_TOP = new BlockBase("shczupper", Material.IRON, 4);
	public static final Block SHCZ_WALL = new BlockBase("shczwall", Material.IRON, 4);

	//Cosmetics
	public static final Block TRASH_BIN = new OrientableBlock("trashbin", Material.WOOD, 3, 1);
	public static final Block RAIL_LEFT = new OrientableBlock("railleft", Material.IRON, 3, 2);
	public static final Block RAIL_MIDDLE = new OrientableBlock("railmiddle", Material.IRON, 3, 2);
	public static final Block RAIL_RIGHT = new OrientableBlock("railright", Material.IRON, 3, 2);
	public static final Block POWER_BOX = new OrientableBlock("powerbox", Material.IRON, 3, 3);
}
