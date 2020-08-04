package gus.scpua.init.blocks;

import gus.scpua.blocks.Collision;
import gus.scpua.blocks.custom.BlockLamp;
import gus.scpua.blocks.rotation.NSEWBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import java.util.ArrayList;
import java.util.List;

public class Cosmetics {
    public static final List<Block> COSMETICBLOCKS = new ArrayList<Block>();

    public static final Block TRASH_BIN = new NSEWBlock(1,"trashbin", Material.WOOD, 3, false, Collision.BIN);
    public static final Block RAIL_LEFT = new NSEWBlock(1,"railleft", Material.IRON, 3, false, Collision.RAIL);
    public static final Block RAIL_MIDDLE = new NSEWBlock(1,"railmiddle", Material.IRON, 3, false, Collision.RAIL);
    public static final Block RAIL_RIGHT = new NSEWBlock(1,"railright", Material.IRON, 3, false, Collision.RAIL);
    public static final Block POWER_BOX = new NSEWBlock(1,"powerbox", Material.IRON, 3, false, Collision.POWER);
    public static final Block FIRE_EXT = new NSEWBlock(1,"fireextinguixer", Material.IRON, 3, false, Collision.FIRE_EXT);
    public static final Block TINY_LAMP = new BlockLamp(1,"tinylamp", Material.IRON, 3, false, Collision.TINYLAMP, true).setLightLevel(1.0F);
    public static final Block SHELF_LEFT = new NSEWBlock(1,"shelfleft", Material.WOOD, 3, false, Collision.SHELF);
    public static final Block SHELF_MIDDLE = new NSEWBlock(1,"shelfmiddle", Material.WOOD, 3, false, Collision.SHELF);
    public static final Block SHELF_RIGHT = new NSEWBlock(1,"shelfright", Material.WOOD, 3, false, Collision.SHELF);
    public static final Block BARRELA = new NSEWBlock(1,"barrela", Material.IRON, 3, false, Collision.BARREL);
    public static final Block BARRELB = new NSEWBlock(1,"barrelb", Material.IRON, 3, false, Collision.BARREL);
    public static final Block WET_FLOOR_SIGN = new NSEWBlock(1,"wetfloorsign", Material.WOOD, 3, false, Collision.WET_FLOOR);
}
