package com.github.soramame0256.lorereplacer.addon.util;

import com.github.soramame0256.lorereplacer.addon.util.proxy.ClientProxy;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class KeyInputHandler {
    public KeyInputHandler(){
        prevKeyStates = new boolean[6];
        keyStates = new boolean[6];
    }

    public static boolean Triggered(int index)
    {
        return (keyStates[index] && !prevKeyStates[index]);
    }
    public static boolean Released(int index)
    {
        return (!keyStates[index] && prevKeyStates[index]);
    }
    public static boolean Down(int index)
    {
        return keyStates[index];
    }

    @SubscribeEvent()
    public void onTickKeyCheck(TickEvent.ClientTickEvent event) {
        KeyBinding[] keyBinds = ClientProxy.keyBindings;

        for(int i = 0; i < keyStates.length; i ++)
        {
            keyStates[i] = keyBinds[i].isKeyDown();
        }

        //Saving key states
        for(int i = 0; i < keyStates.length; i ++)
        {
            prevKeyStates[i] = keyStates[i];
        }
    }

    public static boolean[] keyStates;
    public static boolean[] prevKeyStates;
}