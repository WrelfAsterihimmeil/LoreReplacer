package com.github.soramame0256.lorereplacer.addon.util;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class WrelfAddon {
    public static void copyToolTip(java.util.List<String> tooltip)
    {
        String tipstr = new String();
        for(String t : tooltip)
        {
            tipstr += t;
            tipstr += "\n";
        }

        Clipboard clipboard = Toolkit.getDefaultToolkit()
                .getSystemClipboard();
        StringSelection selection = new StringSelection(tipstr);
        clipboard.setContents(selection, selection);
    }
}
