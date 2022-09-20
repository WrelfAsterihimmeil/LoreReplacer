package com.github.soramame0256.lorereplacer.addon.util;

import com.github.soramame0256.lorereplacer.*;
import com.github.soramame0256.lorereplacer.addon.util.CommonProxy;
import com.github.soramame0256.lorereplacer.addon.util.event.EventManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.input.Keyboard;

import java.io.IOException;

@SideOnly(Side.CLIENT)
public class ClientProxy extends CommonProxy {
    public static KeyBinding[] keyBindings;

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);

        try {
            LoreReplacer.dataUtils = new DataUtils("replacers.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
        EventManager.registerHandler();
        ClientCommandHandler.instance.registerCommand(new CmdAddReplacer());
        ClientCommandHandler.instance.registerCommand(new CmdRemoveReplacer());
        ClientCommandHandler.instance.registerCommand(new CmdReloadReplacer());

        keyBindings = new KeyBinding[1];

        keyBindings[0] = new KeyBinding(I18n.format("lorereplacer.copylore"), Keyboard.KEY_F8, I18n.format("lorereplacer.key.category"));

        for (KeyBinding keyBinding : keyBindings) {
            ClientRegistry.registerKeyBinding(keyBinding);
        }

        EventManager.registerHandler();
    }

}