package com.github.soramame0256.lorereplacer;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.github.soramame0256.lorereplacer.LoreReplacer.dataUtils;

public class CmdReloadReplacer extends CommandBase {

    @Override
    public String getName() {
        return "reloadreplacer";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "reloadreplacer";
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        try {
            LoreReplacer.dataUtils = new DataUtils("replacers.json");
        } catch (IOException e) {
            e.printStackTrace();
            sender.sendMessage(new TextComponentString("error: failed to load replacers.json"));
        }
    }
}

