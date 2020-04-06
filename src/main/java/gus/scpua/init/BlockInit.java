package gus.scpua.init;

import java.util.ArrayList;
import java.util.List;

import gus.scpua.objects.blocks.custom.Block610;
import gus.scpua.objects.blocks.custom.BlockLamp;
import gus.scpua.objects.blocks.custom.BlockTesla;
import gus.scpua.objects.blocks.custom.Coffin076;
import gus.scpua.objects.blocks.rotation.NSEWBlock;
import gus.scpua.objects.blocks.rotation.UDNSEWBlock;
import gus.scpua.scpua;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import gus.scpua.objects.blocks.*;

public class BlockInit {
	public static final List<Block> BLOCKS = new ArrayList<Block>();

	/**
	 * BlockBase, handles basic things
	 * (String name, Material.material, int tab)
	 * ==========================================
	 * BlockAdv, (extends BlockBase) Handles issues ralating to models, and Collision and any custom events.
	 * (String name, Material.material, int tab, bool fullCube, int collision)
	 *
	 * EVERYTHING ELSE BRANCHES OFF BLOCKADV
	 *
	 * NSEWBlock, Player Based.
	 * UDNSEWBlock, Block face based.
	 *
	 * COLLISION (more hitboxes can be found in BlockAdv)
	 * 0 = Full-Cube Hitbox
	 *
	 * TABS
	 * 1 = Lockdown unity
	 * 2 = Tools scp
	 * 3 = Unity cosmetics
	 * 4 = Site-93
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
	public static final Block TRASH_BIN = new NSEWBlock("trashbin", Material.WOOD, 3, false, 1);
	public static final Block RAIL_LEFT = new NSEWBlock("railleft", Material.IRON, 3, false, 2);
	public static final Block RAIL_MIDDLE = new NSEWBlock("railmiddle", Material.IRON, 3, false,2);
	public static final Block RAIL_RIGHT = new NSEWBlock("railright", Material.IRON, 3, false, 2);
	public static final Block POWER_BOX = new NSEWBlock("powerbox", Material.IRON, 3, false, 3);
  	public static final Block FIRE_EXT = new NSEWBlock("fireextinguixer", Material.IRON, 3, false,4);
  	public static final Block TINY_LAMP = new BlockLamp("tinylamp", Material.IRON, 3 ,false, 2).setLightLevel(1.0F);
	public static final Block SHELF_LEFT = new NSEWBlock("shelfleft", Material.WOOD, 3 ,false, 6);
	public static final Block SHELF_MIDDLE = new NSEWBlock("shelfmiddle", Material.WOOD, 3,false, 6);
	public static final Block SHELF_RIGHT = new NSEWBlock("shelfright", Material.WOOD, 3,false, 6);
	public static final Block BARRELA = new BlockAdv("barrela", Material.IRON, 3,false, 1);
	public static final Block BARRELB = new BlockAdv("barrelb", Material.IRON, 3,false, 1);
	public static final Block WET_FLOOR_SIGN = new NSEWBlock("wetfloorsign", Material.WOOD, 3,false, 7);

	//Lockdown Unity
	// All of these hurt me inside
	public static final Block WALL_1 = new BlockBase("walls1", Material.IRON, 1);
	public static final Block WALL_1A = new BlockBase("walls1a", Material.IRON, 1);
	public static final Block WALL_1B = new BlockBase("walls1b", Material.IRON, 1);
	public static final Block WALL_1D = new BlockBase("walls1d", Material.IRON, 1);
	public static final Block WALL_1E = new BlockBase("walls1e", Material.IRON, 1);
	public static final Block WALL_1F = new BlockBase("walls1f", Material.IRON, 1);

	public static final Block WALL_2 = new BlockBase("walls2", Material.IRON, 1);
	public static final Block WALL_2B = new BlockBase("walls2b", Material.IRON, 1);
	public static final Block WALL_2D = new BlockBase("walls2d", Material.IRON, 1);
	public static final Block WALL_2F = new BlockBase("walls2f", Material.IRON, 1);

	public static final Block WALL_3B = new BlockBase("walls3b", Material.IRON, 1);
	public static final Block WALL_3D = new BlockBase("walls3d", Material.IRON, 1);

	public static final Block FLOORS = new BlockBase("floors", Material.IRON, 1);
	public static final Block GRID = new BlockBase("grid", Material.IRON, 1);
	public static final Block WALLPILLOW = new BlockBase("wallpillow", Material.CLOTH, 1);
	
	/* Needs to be fixed, can see through block */
	public static final Block SCP015A = new UDNSEWBlock("pipenightmare", Material.IRON, 1, false, 1);
	public static final Block SCP015B = new BlockAdv("pipenightmareblock", Material.IRON, 1, true, 0);
	public static final Block SCP610A = new Block610("flesha", Material.CLAY, 1);
	public static final Block SCP610B = new Block610("fleshb", Material.CLAY, 1);
	public static final Block SCP0761A = new BlockBase("ableblockfloor", Material.IRON, 1);
	public static final Block SCP0761B = new BlockBase("ableblockbottom", Material.IRON, 1);
	public static final Block SCP0761C = new BlockBase("ableblockmiddle", Material.IRON, 1);
	public static final Block SCP0761COFFIN = new Coffin076("ablecoffin", Material.IRON, 1, false, 5);



	//Site-78
	//Office Blocks
	//Top
	public static final Block PURPLE_OFFICE_TOP = new BlockBase("office_purple_top", Material.ROCK,5);
	public static final Block RED_OFFICE_TOP = new BlockBase("office_red_top", Material.ROCK,5);
	public static final Block YELLOW_OFFICE_TOP = new BlockBase("office_yellow_top", Material.ROCK,5);
	public static final Block GREEN_OFFICE_TOP = new BlockBase("office_green_top", Material.ROCK,5);
	public static final Block DARK_GREEN_OFFICE_TOP = new BlockBase("office_dark_green_top", Material.ROCK,5);
	public static final Block LIGHT_BLUE_OFFICE_TOP = new BlockBase("office_light_blue_top", Material.ROCK,5);
	public static final Block BLUE_OFFICE_TOP = new BlockBase("office_blue_top", Material.ROCK,5);
	public static final Block GREY_OFFICE_TOP = new BlockBase("office_grey_top", Material.ROCK,5);
	public static final Block BLACK_OFFICE_TOP = new BlockBase("office_black_top", Material.ROCK,5);
	//Line
	public static final Block PURPLE_OFFICE_LINE = new BlockBase("office_purple_line", Material.ROCK,5);
	public static final Block RED_OFFICE_LINE = new BlockBase("office_red_line", Material.ROCK,5);
	public static final Block YELLOW_OFFICE_LINE = new BlockBase("office_yellow_line", Material.ROCK,5);
	public static final Block GREEN_OFFICE_LINE = new BlockBase("office_green_line", Material.ROCK,5);
	public static final Block DARK_GREEN_OFFICE_LINE = new BlockBase("office_dark_green_line", Material.ROCK,5);
	public static final Block LIGHT_BLUE_OFFICE_LINE = new BlockBase("office_light_blue_line", Material.ROCK,5);
	public static final Block BLUE_OFFICE_LINE = new BlockBase("office_blue_line", Material.ROCK,5);
	public static final Block GREY_OFFICE_LINE = new BlockBase("office_grey_line", Material.ROCK,5);
	public static final Block BLACK_OFFICE_LINE = new BlockBase("office_black_line", Material.ROCK,5);
	//Bottom
	public static final Block PURPLE_OFFICE_BOTTOM = new BlockBase("office_purple_bottom", Material.ROCK,5);
	public static final Block RED_OFFICE_BOTTOM = new BlockBase("office_red_bottom", Material.ROCK,5);
	public static final Block YELLOW_OFFICE_BOTTOM = new BlockBase("office_yellow_bottom", Material.ROCK,5);
	public static final Block GREEN_OFFICE_BOTTOM = new BlockBase("office_green_bottom", Material.ROCK,5);
	public static final Block DARK_GREEN_OFFICE_BOTTOM = new BlockBase("office_dark_green_bottom", Material.ROCK,5);
	public static final Block LIGHT_BLUE_OFFICE_BOTTOM = new BlockBase("office_light_blue_bottom", Material.ROCK,5);
	public static final Block BLUE_OFFICE_BOTTOM = new BlockBase("office_blue_bottom", Material.ROCK,5);
	public static final Block GREY_OFFICE_BOTTOM = new BlockBase("office_grey_bottom", Material.ROCK,5);
	public static final Block BLACK_OFFICE_BOTTOM = new BlockBase("office_black_bottom", Material.ROCK,5);

	//Orange block cos it doesn't fit F
	public static final Block ORANGE_OFFICE_TOP = new BlockBase("office_orange_top", Material.ROCK,5);
	public static final Block ORANGE_OFFICE_LINE = new BlockBase("office_orange_line", Material.ROCK,5);
	public static final Block ORANGE_OFFICE_BOTTOM = new BlockBase("office_orange_bottom", Material.ROCK,5);

	//Tesla Blocks
	public static final Block TESLA_BLOCK = new BlockTesla("tesla_block", Material.ROCK, 5);
	//Frame (NL= No Line, L= Line)
	public static final Block TFRAME_TOP_NL = new NSEWBlock("tframe_top_nl", Material.IRON,5, true, 0);
	public static final Block TFRAME_MIDDLE_NL = new NSEWBlock("tframe_middle_nl", Material.IRON,5, true, 0);
	public static final Block TFRAME_BOTTOM_NL = new NSEWBlock("tframe_bottom_nl", Material.IRON,5, true, 0);
	public static final Block TFRAME_TOP_L = new NSEWBlock("tframe_top_l", Material.IRON,5, true, 0);
	public static final Block TFRAME_MIDDLE_L = new NSEWBlock("tframe_middle_l", Material.IRON,5, true, 0);
	public static final Block TFRAME_BOTTOM_L = new NSEWBlock("tframe_bottom_l", Material.IRON,5, true, 0);

	public static final Block FLAT_LIGHT_ON = new BlockLamp("flat_light_on", Material.REDSTONE_LIGHT, 5, false, 1).setLightLevel(1.0F);
	public static final Block FLAT_LIGHT_OFF = new BlockLamp("flat_light_off", Material.REDSTONE_LIGHT, 5, false, 1).setCreativeTab(scpua.tabsite78);
}
