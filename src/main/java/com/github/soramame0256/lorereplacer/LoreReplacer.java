package com.github.soramame0256.lorereplacer;

import com.github.soramame0256.lorereplacer.addon.util.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.io.IOException;

@Mod(
        modid = LoreReplacer.MOD_ID,
        name = LoreReplacer.MOD_NAME,
        version = LoreReplacer.VERSION
)
public class LoreReplacer {

    public static final String MOD_ID = "lorereplacer";
    public static final String MOD_NAME = "LoreReplacer";
    public static final String VERSION = "1.0-SNAPSHOT";

    /**
     * This is the instance of your mod as created by Forge. It will never be null.
     */
    @Mod.Instance(MOD_ID)
    public static LoreReplacer INSTANCE;
    public static DataUtils dataUtils;

    public static final String CLIENT_PROXY = "com.github.soramame0256.lorereplacer.addon.util.CommonProxy";
    @SidedProxy(clientSide = CLIENT_PROXY)
    public static CommonProxy proxy;
    /**
     * This is the first initialization event. Register tile entities here.
     * The registry events below will have fired prior to entry to this method.
     */
    @Mod.EventHandler
    public void preinit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
    }

    /**
     * This is the second initialization event. Register custom recipes
     */
    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    /**
     * This is the final initialization event. Register actions from other mods here
     */
    @Mod.EventHandler
    public void postinit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }


}
