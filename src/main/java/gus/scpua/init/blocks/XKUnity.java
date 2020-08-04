package gus.scpua.init.blocks;

import gus.scpua.blocks.BlockAdv;
import gus.scpua.blocks.BlockBase;
import gus.scpua.blocks.Collision;
import gus.scpua.blocks.custom.Block610;
import gus.scpua.blocks.custom.Coffin076;
import gus.scpua.blocks.rotation.NSEWBlock;
import gus.scpua.blocks.rotation.UDNSEWBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import java.util.ArrayList;
import java.util.List;

public class XKUnity {
    public static final List<Block> XKUNITYBLOCKS = new ArrayList<Block>();

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

    // All of these hurt me inside
    public static final Block WALL_1 = new BlockBase(4,"walls1", Material.IRON, 1);
    public static final Block WALL_1A = new BlockBase(4,"walls1a", Material.IRON, 1);
    public static final Block WALL_1B = new BlockBase(4,"walls1b", Material.IRON, 1);
    public static final Block WALL_1D = new BlockBase(4,"walls1d", Material.IRON, 1);
    public static final Block WALL_1E = new BlockBase(4,"walls1e", Material.IRON, 1);
    public static final Block WALL_1F = new BlockBase(4,"walls1f", Material.IRON, 1);

    public static final Block WALL_2 = new BlockBase(4,"walls2", Material.IRON, 1);
    public static final Block WALL_2B = new BlockBase(4,"walls2b", Material.IRON, 1);
    public static final Block WALL_2D = new BlockBase(4,"walls2d", Material.IRON, 1);
    public static final Block WALL_2F = new BlockBase(4,"walls2f", Material.IRON, 1);

    public static final Block WALL_3B = new BlockBase(4,"walls3b", Material.IRON, 1);
    public static final Block WALL_3D = new BlockBase(4,"walls3d", Material.IRON, 1);

    public static final Block FLOORS = new BlockBase(4,"floors", Material.IRON, 1);
    public static final Block GRID = new BlockBase(4,"grid", Material.IRON, 1);
    public static final Block WALLPILLOW = new BlockBase(4,"wallpillow", Material.CLOTH, 1);

    public static final Block METALICHYD = new BlockAdv(4, "metallichydrogen", Material.IRON, 1, true, Collision.BLOCK);
    public static final Block CZGLASS = new NSEWBlock(4,"czglass", Material.GLASS, 1, false, Collision.CZGLASS);

    public static final Block SCP015A = new UDNSEWBlock(4,"pipenightmare", Material.IRON, 1, false, Collision.PIPENIGHTMARE);
    public static final Block SCP015B = new BlockAdv(4,"pipenightmareblock", Material.IRON, 1, true, Collision.BLOCK);

    public static final Block SCP610A = new Block610(4,"flesha", Material.CLAY, 1);
    public static final Block SCP610B = new Block610(4,"fleshb", Material.CLAY, 1);
    public static final Block SCP610LOG = new Block610.Log610(4,"fleshlog", Material.CLAY, 1);
    public static final Block SCP610GRASS = new Block610.Grass610("fleshgrass", Material.CLAY);

    public static final Block SCP0761A = new BlockBase(4,"ableblockfloor", Material.IRON, 1);
    public static final Block SCP0761B = new BlockBase(4,"ableblockbottom", Material.IRON, 1);
    public static final Block SCP0761C = new BlockBase(4,"ableblockmiddle", Material.IRON, 1);
    public static final Block SCP0761COFFIN = new Coffin076(4,"ablecoffin", Material.IRON, 1, false, Collision.COFFIN);

}
