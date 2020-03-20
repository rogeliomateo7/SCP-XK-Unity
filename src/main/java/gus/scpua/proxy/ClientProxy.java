package gus.scpua.proxy;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import org.lwjgl.input.Keyboard;


public class ClientProxy extends CommonProxy {
	public static KeyBinding[] keyBindings;

	@Override
	public void registerItemRenderer(Item item, int meta, String id) {
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), id));
	}

	@Override
	public void clientInit() {
		/*
		//Declare an array of bindings
		keyBindings = new KeyBinding[1];

		//Instance the bindings
		keyBindings[0] = new KeyBinding("key.coms.desc", Keyboard.KEY_G, "keys.s78.category");
		//keyBindings[1] = new KeyBinding("key.coms.desc", Keyboard.KEY_G, "keys.s78.category");

		// Reg all the bindings
		for (int i = 0; i < keyBindings.length; ++i) {
			ClientRegistry.registerKeyBinding(keyBindings[i]);
			*/
	}
}
