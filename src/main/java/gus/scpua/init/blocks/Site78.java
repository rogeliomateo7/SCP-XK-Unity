package gus.scpua.init.blocks;

import gus.scpua.objects.blocks.BlockBase;
import gus.scpua.objects.blocks.Collision;
import gus.scpua.objects.blocks.custom.BlockLamp;
import gus.scpua.objects.blocks.custom.BlockTesla;
import gus.scpua.objects.blocks.rotation.NSEWBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import java.util.ArrayList;
import java.util.List;

public class Site78 {
    public static final List<Block> S78BLOCKS = new ArrayList<Block>();

    //Office Blocks
    //Top
    public static final Block PURPLE_OFFICE_TOP = new BlockBase(2,"office_purple_top", Material.ROCK, 5);
    public static final Block RED_OFFICE_TOP = new BlockBase(2,"office_red_top", Material.ROCK, 5);
    public static final Block YELLOW_OFFICE_TOP = new BlockBase(2,"office_yellow_top", Material.ROCK, 5);
    public static final Block GREEN_OFFICE_TOP = new BlockBase(2,"office_green_top", Material.ROCK, 5);
    public static final Block DARK_GREEN_OFFICE_TOP = new BlockBase(2,"office_dark_green_top", Material.ROCK, 5);
    public static final Block LIGHT_BLUE_OFFICE_TOP = new BlockBase(2,"office_light_blue_top", Material.ROCK, 5);
    public static final Block BLUE_OFFICE_TOP = new BlockBase(2,"office_blue_top", Material.ROCK, 5);
    public static final Block GREY_OFFICE_TOP = new BlockBase(2,"office_grey_top", Material.ROCK, 5);
    public static final Block BLACK_OFFICE_TOP = new BlockBase(2,"office_black_top", Material.ROCK, 5);
    //Line
    public static final Block PURPLE_OFFICE_LINE = new BlockBase(2,"office_purple_line", Material.ROCK, 5);
    public static final Block RED_OFFICE_LINE = new BlockBase(2,"office_red_line", Material.ROCK, 5);
    public static final Block YELLOW_OFFICE_LINE = new BlockBase(2,"office_yellow_line", Material.ROCK, 5);
    public static final Block GREEN_OFFICE_LINE = new BlockBase(2,"office_green_line", Material.ROCK, 5);
    public static final Block DARK_GREEN_OFFICE_LINE = new BlockBase(2,"office_dark_green_line", Material.ROCK, 5);
    public static final Block LIGHT_BLUE_OFFICE_LINE = new BlockBase(2,"office_light_blue_line", Material.ROCK, 5);
    public static final Block BLUE_OFFICE_LINE = new BlockBase(2,"office_blue_line", Material.ROCK, 5);
    public static final Block GREY_OFFICE_LINE = new BlockBase(2,"office_grey_line", Material.ROCK, 5);
    public static final Block BLACK_OFFICE_LINE = new BlockBase(2,"office_black_line", Material.ROCK, 5);
    //Bottom
    public static final Block PURPLE_OFFICE_BOTTOM = new BlockBase(2,"office_purple_bottom", Material.ROCK, 5);
    public static final Block RED_OFFICE_BOTTOM = new BlockBase(2,"office_red_bottom", Material.ROCK, 5);
    public static final Block YELLOW_OFFICE_BOTTOM = new BlockBase(2,"office_yellow_bottom", Material.ROCK, 5);
    public static final Block GREEN_OFFICE_BOTTOM = new BlockBase(2,"office_green_bottom", Material.ROCK, 5);
    public static final Block DARK_GREEN_OFFICE_BOTTOM = new BlockBase(2,"office_dark_green_bottom", Material.ROCK, 5);
    public static final Block LIGHT_BLUE_OFFICE_BOTTOM = new BlockBase(2,"office_light_blue_bottom", Material.ROCK, 5);
    public static final Block BLUE_OFFICE_BOTTOM = new BlockBase(2,"office_blue_bottom", Material.ROCK, 5);
    public static final Block GREY_OFFICE_BOTTOM = new BlockBase(2,"office_grey_bottom", Material.ROCK, 5);
    public static final Block BLACK_OFFICE_BOTTOM = new BlockBase(2,"office_black_bottom", Material.ROCK, 5);

    //Orange block cos it doesn't fit F
    public static final Block ORANGE_OFFICE_TOP = new BlockBase(2,"office_orange_top", Material.ROCK, 5);
    public static final Block ORANGE_OFFICE_LINE = new BlockBase(2,"office_orange_line", Material.ROCK, 5);
    public static final Block ORANGE_OFFICE_BOTTOM = new BlockBase(2,"office_orange_bottom", Material.ROCK, 5);

    //Tesla Blocks
    public static final Block TESLA_BLOCK = new BlockTesla(2,"tesla_block", Material.ROCK, 5);
    //Frame (NL= No Line, L= Line)
    public static final Block TFRAME_TOP_NL = new NSEWBlock(2,"tframe_top_nl", Material.IRON, 5, true, Collision.BLOCK);
    public static final Block TFRAME_MIDDLE_NL = new NSEWBlock(2,"tframe_middle_nl", Material.IRON, 5, true, Collision.BLOCK);
    public static final Block TFRAME_BOTTOM_NL = new NSEWBlock(2,"tframe_bottom_nl", Material.IRON, 5, true, Collision.BLOCK);
    public static final Block TFRAME_TOP_L = new NSEWBlock(2,"tframe_top_l", Material.IRON, 5, true, Collision.BLOCK);
    public static final Block TFRAME_MIDDLE_L = new NSEWBlock(2,"tframe_middle_l", Material.IRON, 5, true, Collision.BLOCK);
    public static final Block TFRAME_BOTTOM_L = new NSEWBlock(2,"tframe_bottom_l", Material.IRON, 5, true, Collision.BLOCK);

    public static final Block FLAT_LIGHT_ON = new BlockLamp(2,"flat_light_on", Material.REDSTONE_LIGHT, 0, false, Collision.S78LIGHT, true).setLightLevel(1.0F);
    public static final Block FLAT_LIGHT_OFF = new BlockLamp(2,"flat_light_off", Material.REDSTONE_LIGHT, 5, false, Collision.S78LIGHT, false);
}
