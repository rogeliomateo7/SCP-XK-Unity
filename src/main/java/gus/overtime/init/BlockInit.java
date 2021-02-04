package gus.overtime.init;

import gus.overtime.blocks.XKBlock;
import gus.overtime.blocks.XKBlockHorizontal;
import gus.overtime.blocks.cosmetics.*;
import gus.overtime.blocks.custom.*;
import gus.overtime.Overtime;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.event.RegistryEvent;

import java.util.ArrayList;
import java.util.List;

import static gus.overtime.Overtime.*;

//TODO add the rest and fix XKBlock
public class BlockInit {
    public static final List<Block> BLOCKS = new ArrayList<>();

    //XK Blocks
    public static XKBlock WALL_1, WALL_1A, WALL_1B, WALL_1D, WALL_1E, WALL_1F;
    public static XKBlock WALL_2, WALL_2B, WALL_2D, WALL_2F;
    public static XKBlock WALL_3B, WALL_3D;
    public static XKBlock FLOORS, GRID, WALLPILLOW;

    public static XKBlock METALICHYD, CZGLASS;

    public static XKBlock SCP015A, SCP015B;
    public static XKBlock SCP076_1A, SCP076_1B, SCP076_1C, SCP076_1COFFIN;
    public static XKBlock SCP610A, SCP610B, SCP610LOG;
    //FIXME
    public static Block SCP610GRASS;


    //Cosmetics
    public static XKBlock TRASH_BIN;
    public static XKBlock RAIL_LEFT, RAIL_MIDDLE, RAIL_RIGHT;
    public static XKBlock POWER_BOX;
    public static XKBlock FIRE_EXT;
    public static XKBlock TINY_LAMP;
    public static XKBlock SHELF_LEFT, SHELF_MIDDLE, SHELF_RIGHT;
    public static XKBlock BARRELA, BARRELB;
    public static XKBlock WET_FLOOR_SIGN;


    //Site-93 (a lot of name inconsistency)
    public static XKBlock LCZ_FLOOR_A, LCZ_FLOOR_B, LCZ_BASE, LCZ_BOTTOM, LCZ_MIDDLE, LCZ_TOP;
    public static XKBlock ECZ_BASE, ECZ_MIDDLE, ECZ_TOP;
    public static XKBlock HCZ_FLOOR, HCZ_BASE, HCZ_MIDDLE, HCZ_TOP;
    public static XKBlock SHCZ_FLOOR, SHCZ_MIDDLE, SHCZ_WALL, SHCZ_TOP;


    //Site-78
    public static XKBlock PURPLE_OFFICE_TOP, RED_OFFICE_TOP, YELLOW_OFFICE_TOP, GREEN_OFFICE_TOP, DARK_GREEN_OFFICE_TOP, LIGHT_BLUE_OFFICE_TOP, BLUE_OFFICE_TOP, GREY_OFFICE_TOP, BLACK_OFFICE_TOP;
    public static XKBlock PURPLE_OFFICE_LINE, RED_OFFICE_LINE, YELLOW_OFFICE_LINE, GREEN_OFFICE_LINE, DARK_GREEN_OFFICE_LINE, LIGHT_BLUE_OFFICE_LINE, BLUE_OFFICE_LINE, GREY_OFFICE_LINE, BLACK_OFFICE_LINE;
    public static XKBlock PURPLE_OFFICE_BOTTOM, RED_OFFICE_BOTTOM, YELLOW_OFFICE_BOTTOM, GREEN_OFFICE_BOTTOM, DARK_GREEN_OFFICE_BOTTOM, LIGHT_BLUE_OFFICE_BOTTOM, BLUE_OFFICE_BOTTOM, GREY_OFFICE_BOTTOM, BLACK_OFFICE_BOTTOM;

    public static XKBlock ORANGE_OFFICE_TOP, ORANGE_OFFICE_LINE, ORANGE_OFFICE_BOTTOM;
    public static XKBlock CYAN_OFFICE_TOP, CYAN_OFFICE_LINE, CYAN_OFFICE_BOTTOM;


    //Tesla Blocks
    public static XKBlock TESLA_BLOCK;
    //Frame (NL= No Line, L= Line)
    public static XKBlock TFRAME_TOP_NL, TFRAME_MIDDLE_NL, TFRAME_BOTTOM_NL,
            TFRAME_TOP_L, TFRAME_MIDDLE_L, TFRAME_BOTTOM_L;

    //TODO Fix these 4
    public static Block FLAT_LIGHT_ON, FLAT_LIGHT_OFF;
    public static Block CLON, CLOFF;

    public static void init(RegistryEvent.Register<Block> event) {
        /*XKBlocks*/
        {
            {
                WALL_1 = new XKBlock("walls1", TAB_OVERTIME);
                WALL_1A = new XKBlock("walls1a", TAB_OVERTIME);
                WALL_1B = new XKBlock("walls1b", TAB_OVERTIME);
                WALL_1D = new XKBlock("walls1d", TAB_OVERTIME);
                WALL_1E = new XKBlock("walls1e", TAB_OVERTIME);
                WALL_1F = new XKBlock("walls1f", TAB_OVERTIME);

                WALL_2 = new XKBlock("walls2", TAB_OVERTIME);
                WALL_2B = new XKBlock("walls2b", TAB_OVERTIME);
                WALL_2D = new XKBlock("walls2d", TAB_OVERTIME);
                WALL_2F = new XKBlock("walls2f", TAB_OVERTIME);

                WALL_3B = new XKBlock("walls3b", TAB_OVERTIME);
                WALL_3D = new XKBlock("walls3d", TAB_OVERTIME);

                FLOORS = new XKBlock("floors", TAB_OVERTIME);
                GRID = new XKBlock("grid", TAB_OVERTIME);
                WALLPILLOW = new XKBlock("wallpillow", TAB_OVERTIME);
            }

            METALICHYD = new XKMetalicHydrogen();
            CZGLASS = new BlockCZGlass();

            SCP015A = new XKPipeNightmare();
            //TODO this
            SCP015B = new XKBlock("pipenightmareblock", TAB_OVERTIME);

            SCP076_1A = new XKBlock("ableblockfloor", TAB_OVERTIME);
            SCP076_1B = new XKBlock("ableblockbottom", TAB_OVERTIME);
            SCP076_1C = new XKBlock("ableblockmiddle", TAB_OVERTIME);
            SCP076_1COFFIN = new BlockCoffin076("ablecoffin", TAB_OVERTIME, Material.ROCK);

            SCP610A = new XKBlock("flesha", TAB_OVERTIME);
            SCP610B = new XKBlock("fleshb", TAB_OVERTIME);
            SCP610LOG = new XKBlock("fleshlog", TAB_OVERTIME);
            SCP610GRASS = new XKBlock("fleshgrass", TAB_OVERTIME);
        }

        /*Cosmetics*/
        {
            TRASH_BIN = new XKTrashBin();
            RAIL_LEFT = new XKRail("railleft");
            RAIL_MIDDLE = new XKRail("railmiddle");
            RAIL_RIGHT = new XKRail("railright");
            POWER_BOX = new XKPowerBox();
            FIRE_EXT = new XKFireExtinguisher();
            TINY_LAMP = new XKTinyLamp();
            BARRELA = new XKBarrel("barrela");
            BARRELB = new XKBarrel("barrelb");
            SHELF_LEFT = new XKShelf("shelfleft");
            SHELF_MIDDLE = new XKShelf("shelfmiddle");
            SHELF_RIGHT = new XKShelf("shelfright");
            WET_FLOOR_SIGN = new XKWetFloorSign();
        }

        /*Site-93*/
        {
            LCZ_FLOOR_A = new XKBlock("lczfloora", TAB_SITE93);
            LCZ_FLOOR_B = new XKBlock("lczfloorb", TAB_SITE93);
            LCZ_BASE = new XKBlock("lczbase", TAB_SITE93);
            LCZ_BOTTOM = new XKBlock("lczbottom", TAB_SITE93);
            LCZ_MIDDLE = new XKBlock("lczmiddle", TAB_SITE93);
            LCZ_TOP = new XKBlock("lcztop", TAB_SITE93);

            ECZ_BASE = new XKBlock("eczbase", TAB_SITE93);
            ECZ_MIDDLE = new XKBlock("eczmiddle", TAB_SITE93);
            ECZ_TOP = new XKBlock("ecztop", TAB_SITE93);

            HCZ_FLOOR = new XKBlock("hczfloor", TAB_SITE93);
            HCZ_BASE = new XKBlock("hczbase", TAB_SITE93);
            HCZ_MIDDLE = new XKBlock("hczmiddle", TAB_SITE93);
            HCZ_TOP = new XKBlock("hcztop", TAB_SITE93);

            SHCZ_FLOOR = new XKBlock("shczfloor", TAB_SITE93);
            SHCZ_MIDDLE = new XKBlock("shczmiddle", TAB_SITE93);
            SHCZ_WALL = new XKBlock("shczwall", TAB_SITE93);
            SHCZ_TOP = new XKBlock("shczupper", TAB_SITE93);
        }

        /*Site-78*/
        {
            //Office Blocks
            {
                //TODO Possible Replacement with for loop
                PURPLE_OFFICE_TOP = new XKBlock("office_purple_top", Overtime.TAB_SITE78, Material.ROCK);
                RED_OFFICE_TOP = new XKBlock("office_red_top", Overtime.TAB_SITE78, Material.ROCK);
                YELLOW_OFFICE_TOP = new XKBlock("office_yellow_top", Overtime.TAB_SITE78, Material.ROCK);
                GREEN_OFFICE_TOP = new XKBlock("office_green_top", Overtime.TAB_SITE78, Material.ROCK);
                DARK_GREEN_OFFICE_TOP = new XKBlock("office_dark_green_top", Overtime.TAB_SITE78, Material.ROCK);
                LIGHT_BLUE_OFFICE_TOP = new XKBlock("office_light_blue_top", Overtime.TAB_SITE78, Material.ROCK);
                BLUE_OFFICE_TOP = new XKBlock("office_blue_top", Overtime.TAB_SITE78, Material.ROCK);
                GREY_OFFICE_TOP = new XKBlock("office_grey_top", Overtime.TAB_SITE78, Material.ROCK);
                BLACK_OFFICE_TOP = new XKBlock("office_black_top", Overtime.TAB_SITE78, Material.ROCK);

                PURPLE_OFFICE_LINE = new XKBlock("office_purple_line", Overtime.TAB_SITE78, Material.ROCK);
                RED_OFFICE_LINE = new XKBlock("office_red_line", Overtime.TAB_SITE78, Material.ROCK);
                YELLOW_OFFICE_LINE = new XKBlock("office_yellow_line", Overtime.TAB_SITE78, Material.ROCK);
                GREEN_OFFICE_LINE = new XKBlock("office_green_line", Overtime.TAB_SITE78, Material.ROCK);
                DARK_GREEN_OFFICE_LINE = new XKBlock("office_dark_green_line", Overtime.TAB_SITE78, Material.ROCK);
                LIGHT_BLUE_OFFICE_LINE = new XKBlock("office_light_blue_line", Overtime.TAB_SITE78, Material.ROCK);
                BLUE_OFFICE_LINE = new XKBlock("office_blue_line", Overtime.TAB_SITE78, Material.ROCK);
                GREY_OFFICE_LINE = new XKBlock("office_grey_line", Overtime.TAB_SITE78, Material.ROCK);
                BLACK_OFFICE_LINE = new XKBlock("office_black_line", Overtime.TAB_SITE78, Material.ROCK);

                PURPLE_OFFICE_BOTTOM = new XKBlock("office_purple_bottom", Overtime.TAB_SITE78, Material.ROCK);
                RED_OFFICE_BOTTOM = new XKBlock("office_red_bottom", Overtime.TAB_SITE78, Material.ROCK);
                YELLOW_OFFICE_BOTTOM = new XKBlock("office_yellow_bottom", Overtime.TAB_SITE78, Material.ROCK);
                GREEN_OFFICE_BOTTOM = new XKBlock("office_green_bottom", Overtime.TAB_SITE78, Material.ROCK);
                DARK_GREEN_OFFICE_BOTTOM = new XKBlock("office_dark_green_bottom", Overtime.TAB_SITE78, Material.ROCK);
                LIGHT_BLUE_OFFICE_BOTTOM = new XKBlock("office_light_blue_bottom", Overtime.TAB_SITE78, Material.ROCK);
                BLUE_OFFICE_BOTTOM = new XKBlock("office_blue_bottom", Overtime.TAB_SITE78, Material.ROCK);
                GREY_OFFICE_BOTTOM = new XKBlock("office_grey_bottom", Overtime.TAB_SITE78, Material.ROCK);
                BLACK_OFFICE_BOTTOM = new XKBlock("office_black_bottom", Overtime.TAB_SITE78, Material.ROCK);

                ORANGE_OFFICE_TOP = new XKBlock("office_orange_top", Overtime.TAB_SITE78, Material.ROCK);
                ORANGE_OFFICE_LINE = new XKBlock("office_orange_line", Overtime.TAB_SITE78, Material.ROCK);
                ORANGE_OFFICE_BOTTOM = new XKBlock("office_orange_bottom", Overtime.TAB_SITE78, Material.ROCK);

                CYAN_OFFICE_TOP = new XKBlock("office_cyan_top", Overtime.TAB_SITE78, Material.ROCK);
                CYAN_OFFICE_LINE = new XKBlock("office_cyan_line", Overtime.TAB_SITE78, Material.ROCK);
                CYAN_OFFICE_BOTTOM = new XKBlock("office_cyan_bottom", Overtime.TAB_SITE78, Material.ROCK);
            }

            TESLA_BLOCK  = new BlockTesla();

            TFRAME_TOP_NL= new XKBlockHorizontal("tframe_top_nl", TAB_SITE78, Material.ROCK);
            TFRAME_MIDDLE_NL= new XKBlockHorizontal("tframe_middle_nl", TAB_SITE78, Material.ROCK);
            TFRAME_BOTTOM_NL= new XKBlockHorizontal("tframe_bottom_nl", TAB_SITE78, Material.ROCK);

            TFRAME_TOP_L= new XKBlockHorizontal("tframe_top_l", TAB_SITE78, Material.ROCK);
            TFRAME_MIDDLE_L= new XKBlockHorizontal("tframe_middle_l", TAB_SITE78, Material.ROCK);
            TFRAME_BOTTOM_L= new XKBlockHorizontal("tframe_bottom_l", TAB_SITE78, Material.ROCK);

            FLAT_LIGHT_ON = new BlockFlatLamp("flat_light_on", TAB_SITE78, true);
            FLAT_LIGHT_OFF = new BlockFlatLamp("flat_light_off", null, false);

            CLON = new CLBlock("coloured_light_on", null, true);
            CLOFF = new CLBlock("coloured_light_off", TAB_SITE78, false);

        }

        event.getRegistry().registerAll(BLOCKS.toArray(new Block[0]));
    }
}
