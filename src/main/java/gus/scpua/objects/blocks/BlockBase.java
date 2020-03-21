package gus.scpua.objects.blocks;

import gus.scpua.scpua;
import gus.scpua.init.BlockInit;
import gus.scpua.init.ItemInit;
import gus.scpua.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockBase extends Block implements IHasModel {
	/**
	 * Handles VERY Basic stuff like
	 * What Inventory
	 * Material Sounds, and hardness
	 * and render functions.
	 *
	 * EVERY OTHER BLock class is based off this due to CORE aspects of all blocks
	 */

	public BlockBase(String name, Material material, int inv) {
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
		if(inv == 1) setCreativeTab(scpua.tablockdownunitytab);
		if(inv == 2) setCreativeTab(scpua.tabweaponsscp);
		if(inv == 3) setCreativeTab(scpua.tablockdownunitycosmetics);
		if(inv == 4) setCreativeTab(scpua.tabsite93blocks);
		
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}

	@Override
	public void registerModels() {
		scpua.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
}
