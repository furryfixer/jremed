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
package jremedsrc.actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import javax.swing.KeyStroke;
import jremedsrc.clipboard.JremedClipboard;
import jremedsrc.commands.CommandManager;
import jremedsrc.commands.NewItemCommand;
import jremedsrc.gui.MainFrame;
import jremedsrc.model.Category;
import jremedsrc.model.MenuItem;
import jremedsrc.persistence.FileUtil;
import jremedsrc.utils.Configuration;

/**
 * Paste action copies a menu item from clipboard to selected category.
 *
 */
public class PasteAction extends JremedAbstractAction {

    /**
     * Creates an action.
     */
    public PasteAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_C, ActionEvent.CTRL_MASK));
        putValue(MNEMONIC_KEY, KeyEvent.VK_V);
        putValue(SMALL_ICON, loadIcon("/jremedsrc/images/dialogs/edit-paste.png"));
        putValue(NAME, "Paste");
        putValue(SHORT_DESCRIPTION, "Paste menu item");
    }

    /**
     * Copies menu item, if any, from clipboard to selected category. Determines
     * selected category. Checks if it contains any menu item. If it does, item's
     * path is set depending on whether a user is root or regular user. Then it
     * creates a {@link NewItemCommand} with menu item from clipboard as new
     * item. Last, if a Pasted item was created by Cut action, Cliboard is
     * emptied.
     *
     * @param e not used
     */
    public void actionPerformed(ActionEvent e) {
        JremedClipboard lc = JremedClipboard.getClipboard();

        Category category = MainFrame.getInstance().getSelectedCategory();

        if (lc.isEmpty() || category == null) {
            return;
        }

        MenuItem toPaste = lc.getToPaste();
        toPaste.setCategory(category);

        if (Configuration.IS_ROOT) {
            toPaste.setPath(new File(Configuration.ROOT_APPS + "/" + FileUtil.getTimestampedFileName(toPaste.getName())));
        } else {
            toPaste.setPath(new File(Configuration.USER_APPS + "/" + FileUtil.getTimestampedFileName(toPaste.getName())));
        }

        NewItemCommand nic = new NewItemCommand(toPaste);
        CommandManager.getInstance().addCommand(nic);

        if (lc.isForCut()) {
            lc.emptyClipboard();
            lc.setForCut(false);
        }

        MainFrame.getInstance().updateCliboardButtons();
    }
}
