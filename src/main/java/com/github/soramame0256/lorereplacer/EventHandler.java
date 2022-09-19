package com.github.soramame0256.lorereplacer;

import com.github.soramame0256.lorereplacer.addon.util.KeyInputHandler;
import com.github.soramame0256.lorereplacer.addon.util.WrelfAddon;
import com.google.gson.JsonElement;
import net.minecraft.client.Minecraft;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.ArrayList;
import java.util.List;

import static com.github.soramame0256.lorereplacer.LoreReplacer.dataUtils;

public class EventHandler {
    @SubscribeEvent
    public void onLoreRender(ItemTooltipEvent e) {
        List<String> newLore = new ArrayList<>();
        if(Minecraft.getMinecraft().player == null || dataUtils == null) return;
        //if copy tooltip key is triggered, copy all tooltip content
        if(KeyInputHandler.Triggered(0))
        {
            WrelfAddon.copyToolTip(e.getToolTip());
        }

        for(String s : e.getToolTip()) {
            if (dataUtils.getRootJson().has("replacers"))
                for (JsonElement je : dataUtils.getRootJson().get("replacers").getAsJsonArray())
                    s = s.replaceAll(je.getAsJsonObject().get("from").getAsString(), je.getAsJsonObject().get("to").getAsString());
            if(!s.contains("//DELETE")) newLore.add(s);
        }
        e.getToolTip().clear();
        e.getToolTip().addAll(newLore);
    }
}
