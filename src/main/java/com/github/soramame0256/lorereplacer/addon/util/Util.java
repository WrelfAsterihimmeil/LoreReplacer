package com.github.soramame0256.lorereplacer.addon.util;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class Util {
    public static void copyToClipboard(String str)
    {
        Clipboard clipboard = Toolkit.getDefaultToolkit()
                .getSystemClipboard();
        StringSelection selection = new StringSelection(str);
        clipboard.setContents(selection, selection);
    }
}
