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
package jremedsrc.commands;

import java.util.logging.Level;
import java.util.logging.Logger;
import jremedsrc.model.Category;
import jremedsrc.model.MenuItem;
import jremedsrc.model.Model;

/**
 * Delete command provides a way to delete a menu item, and then revert it.
 *
 */
public class DeleteItemCommand implements JremedCommand {

    /**
     * Menu item to delete.
     */
    private MenuItem menuItem;
    /**
     * Category of deleted menu item.
     */
    private Category category;

    /**
     * Creates a new delete command.
     *
     * @param toDelete menu item to delete
     */
    public DeleteItemCommand(MenuItem toDelete) {
        this.menuItem = toDelete;
        category = toDelete.getCategory();
    }

    /**
     * Addresses a {@link Model} to delete a menu item.
     */
    @Override
    public void doCommand() {
        try {
            Model.getModel().deleteMenuItem(menuItem);
        } catch (Exception e) {
            Logger.getLogger(DeleteItemCommand.class.getName()).log(Level.SEVERE, "Delete command redo", e);
        }
    }

    /**
     * Sets a category to deleted menu item, thus returning it to life, and
     * addresses {@link Model} to add deleted menu item.
     */
    @Override
    public void undoCommand() {
        try {
            menuItem.setCategory(category);
            Model.getModel().addMenuItem(menuItem);
        } catch (Exception e) {
            Logger.getLogger(DeleteItemCommand.class.getName()).log(Level.SEVERE, "Delete command undo", e);
        }
    }
}
