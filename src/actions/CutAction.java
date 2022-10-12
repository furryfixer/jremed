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
import javax.swing.KeyStroke;
import jremedsrc.clipboard.JremedClipboard;
import jremedsrc.commands.CommandManager;
import jremedsrc.commands.DeleteItemCommand;
import jremedsrc.gui.MainFrame;
import jremedsrc.model.MenuItem;

/**
 * Deletes selected menu item and clones it to Clipboard.
 *
 */
public class CutAction extends JremedAbstractAction {

    /**
     * Creates a cut action.
     */
    public CutAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_C, ActionEvent.CTRL_MASK));
        putValue(MNEMONIC_KEY, KeyEvent.VK_X);
        putValue(SMALL_ICON, loadIcon("/jremedsrc/images/dialogs/edit-cut.png"));
        putValue(NAME, "Cut");
        putValue(SHORT_DESCRIPTION, "Cut selected menu item");
    }

    /**
     * Clones & deletes selected menu item to clipboard. Creates a new
     * {@link DeleteItemCommand} which deletes selected menu item. Lastly, it
     * updates clipboard buttons on {@link MainFrame}.
     *
     * @param e not used
     */
    public void actionPerformed(ActionEvent e) {
        JremedClipboard lc = JremedClipboard.getClipboard();

        MenuItem selected = MainFrame.getInstance().getSelectedMenuItem();
        if (selected == null) {
            return;
        }

        lc.toClipboard(selected);
        CommandManager.getInstance().addCommand(new DeleteItemCommand(selected));
        lc.setForCut(true);
        MainFrame.getInstance().updateCliboardButtons();
    }
}
