package com.github.soramame0256.lorereplacer.addon.util.event;

import com.github.soramame0256.lorereplacer.EventHandler;
import com.github.soramame0256.lorereplacer.addon.util.KeyInputHandler;
import net.minecraftforge.common.MinecraftForge;

public class EventManager {
    public static void registerHandler() {
        MinecraftForge.EVENT_BUS.register(new EventHandler());
        MinecraftForge.EVENT_BUS.register(new KeyInputHandler());
    }
}