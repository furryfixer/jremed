// jremed - JRE Menu Editor, by William Rueger (furryfixer), 2022
// derived from https://lxmed.sourceforge.net/
// Copyright (C) 2011  Marko Čičak
//
// This file is part of jremed.
//
// jremed is free software: you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// jremed is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with lxmed.  If not, see <http://www.gnu.org/licenses/>.
package jremedsrc.clipboard;

import jremedsrc.model.MenuItem;

/**
 * Jremed Clipboard can persist up to one pasted menu item.
 *
 */
public class JremedClipboard {

    /**
     * Pasted item.
     */
    private MenuItem toPaste = null;
    /**
     * Singleton instance.
     */
    private static JremedClipboard clipboard;
    /**
     * If a clipboard is filled with cut action, this is set to true.
     */
    private boolean forCut = false;

    /**
     * Private constructor.
     */
    private JremedClipboard() {
    }

    /**
     * Jremed Clipboard.
     */
    public static JremedClipboard getClipboard() {
        if (clipboard == null) {
            clipboard = new JremedClipboard();
        }
        return clipboard;
    }

    /**
     * Menu item to paste.
     *
     * @return null if clipboard is empty, otherwise returns menu item to paste
     */
    public MenuItem getToPaste() {
        try {
            return (MenuItem) toPaste.clone();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    /**
     * Sets new menu item to clipboard. If there was an old one, it is replaced
     * by the new menu item.
     *
     * @param menuItem menu item to be set on clipboard.
     */
    public void toClipboard(MenuItem menuItem) {
        try {
            toPaste = (MenuItem) menuItem.clone();
            toPaste.setReadOnly(false);
            toPaste.setCategory(null);
        } catch (CloneNotSupportedException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Empties the clipboard.
     */
    public void emptyClipboard() {
        forCut = false;
        toPaste = null;
    }

    /**
     * Checks if clipboard is empty.
     *
     * @return true if it is empty, otherwise false
     */
    public boolean isEmpty() {
        return toPaste == null;
    }

    /**
     * Checks if pasted item was created by Cut action.
     *
     * @return true if pasted item was created by Cut action, false otherwise
     */
    public boolean isForCut() {
        return forCut;
    }

    /**
     * Sets a status whether the clipboard item was placed here by Cut or Copy
     * action.
     *
     * @param forCut should be true, if Cut action placed the item to clipboard,
     * otherwise, if Copy action did it, parameter should be false
     */
    public void setForCut(boolean forCut) {
        this.forCut = forCut;
    }
}
