package gus.overtime.client;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.input.Keyboard;

/**
 * Registers and handle Keybinding Events
 */
@SideOnly(Side.CLIENT)
public class InputHandler {
    //Constant Vars
    private static final String MAIN_CATEGORY = "keys.overtime.category.main";
    private static final String KEY_DESC = "key.overtime.";

    //The Keys themselves
    //public static KeyBinding EXAMPLE = registerKey("example", Keyboard.KEY_E);
    //keyBindings[0] = new KeyBinding("key.coms.desc", Keyboard.KEY_G, "keys.s78.category");
    public static KeyBinding COM_SUIT = registerKey("comsuit",Keyboard.KEY_G);

    //Registration Part
    private static KeyBinding registerKey(String name, int code) { return registerKey(name, code, MAIN_CATEGORY); }
    private static KeyBinding registerKey(String name, int code, String category) {
        KeyBinding keyBind = new KeyBinding(KEY_DESC+name, code, category);
        ClientRegistry.registerKeyBinding(keyBind);
        return keyBind;
    }

    //KeyEvent Handler
    @SubscribeEvent
    public void onKeyPressed(InputEvent.KeyInputEvent event) {
        //if (EXAMPLE.isPressed()) {
            //System.out.println("KEY PRESSED");
        //}
    }
}
