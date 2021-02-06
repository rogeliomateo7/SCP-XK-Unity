package gus.overtime.blocks;

import gus.overtime.init.BlockInit;
import gus.overtime.Overtime;
import gus.overtime.init.ItemInit;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;

import javax.annotation.Nullable;

/**
 * Handles VERY Basic stuff like
 * What Inventory
 * Material Sounds and hardness
 *
 * EVERY OTHER BLock class is based off this due to CORE aspects of all blocks
 */
public class XKBlock extends Block {

	@Deprecated
	public XKBlock(int whatClass, String name, Material material, int inv) {
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);

		//Material Settings
		if (material == Material.IRON) {
			setSoundType(SoundType.METAL);
			setHardness(5.0F);
			setResistance(6);
		}
		if (material == Material.ROCK) {
			setSoundType(SoundType.STONE);
			setHardness(2.0F);
			setResistance(2);
		}
		if (material == Material.WOOD) {
			setSoundType(SoundType.WOOD);
			setHardness(2.0F);
			setResistance(2);
		}
		if (material == Material.CLOTH) {
			setSoundType(SoundType.CLOTH);
			setHardness(1.0F);
			setResistance(1);
		}
		if (material == Material.CLAY) {
			setSoundType(SoundType.SLIME);
			setHardness(1.5F);
			setResistance(2);
		}

		//Creative Tab set
		if(inv == 1) setCreativeTab(Overtime.TAB_OVERTIME);
		else if(inv == 2) setCreativeTab(Overtime.TAB_TOOLS);
		else if(inv == 3) setCreativeTab(Overtime.TAB_COSMETICS);
		else if(inv == 4) setCreativeTab(Overtime.TAB_SITE93);
		else if(inv == 5) setCreativeTab(Overtime.TAB_SITE78);

		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}

	public XKBlock(String name, @Nullable CreativeTabs tabs, Material material) {
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);

		if (tabs != null) setCreativeTab(tabs);

		//Material Settings
		if (material == Material.IRON) {
			setSoundType(SoundType.METAL);
			setHardness(5.0F);
			setResistance(6);
		}
		else if (material == Material.ROCK) {
			setSoundType(SoundType.STONE);
			setHardness(2.0F);
			setResistance(2);
		}
		else if (material == Material.WOOD) {
			setSoundType(SoundType.WOOD);
			setHardness(2.0F);
			setResistance(2);
		}
		else if (material == Material.CLOTH) {
			setSoundType(SoundType.CLOTH);
			setHardness(1.0F);
			setResistance(1);
		}
		else if (material == Material.CLAY) {
			setSoundType(SoundType.SLIME);
			setHardness(1.5F);
			setResistance(2);
		}
		if (material == Material.GLASS) {
			setSoundType(SoundType.GLASS);
			setHardness(1F);
			setResistance(1);
		}

		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(name));
	}

	public XKBlock(String name, @Nullable CreativeTabs creativeTabs) {
		this(name, creativeTabs, Material.IRON);
	}
	public XKBlock(String name) {
		this(name, null, Material.IRON);
	}
}
