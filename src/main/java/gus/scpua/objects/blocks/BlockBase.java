package gus.scpua.objects.blocks;

import gus.scpua.scpua;
import gus.scpua.init.BlockInit;
import gus.scpua.init.ItemInit;
import gus.scpua.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockBase extends Block implements IHasModel {
	public BlockBase(String name, Material material, int inv) {
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setHardness(2.0F);
		setResistance(30);

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
