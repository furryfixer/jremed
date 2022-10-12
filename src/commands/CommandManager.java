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

import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import jremedsrc.JremedException;
import jremedsrc.gui.MainFrame;

/**
 * Command manager is a singleton containing a history of all
 * {@link JremedCommand}s, pointer to current command.
 *
 */
public class CommandManager {

    /**
     * Commands list.
     */
    private List<JremedCommand> commands = new ArrayList<JremedCommand>();
    /**
     * Cursor which indicates current command.
     */
    private int currentCommand = 0;
    /**
     * Singleton.
     */
    private static CommandManager instance;

    /**
     * Private constructor.
     */
    private CommandManager() {
    }

    /**
     * Command Manager instance.
     */
    public static CommandManager getInstance() {
        if (instance == null) {
            instance = new CommandManager();
        }

        return instance;
    }

    /**
     * Adds a new command to command list.
     *
     * @param command new command
     */
    public void addCommand(JremedCommand command) throws JremedException {
        while (currentCommand < commands.size()) {
            commands.remove(currentCommand);
        }
        try {
            commands.add(command);
            doCommand();
        } catch (JremedException e) {
            throw e;
        }
    }

    /**
     * Executes a command.
     */
    public void doCommand() {
        if (currentCommand < commands.size()) {
            commands.get(currentCommand++).doCommand();
            refreshButtons();
        }
    }

    /**
     * Calls undo method on current command.
     */
    public void undoCommand() {
        if (currentCommand > 0) {
            commands.get(--currentCommand).undoCommand();
            refreshButtons();
        }
    }

    /**
     * Updates enability of Undo/Redo buttons on main form.
     */
    private void refreshButtons() {
        JButton undo = MainFrame.getInstance().getBtnUndo();
        JButton redo = MainFrame.getInstance().getBtnRedo();

        if (commands.isEmpty()) {
            undo.setEnabled(false);
            redo.setEnabled(false);
        } else if (currentCommand == commands.size()) {
            undo.setEnabled(true);
            redo.setEnabled(false);
        } else if (currentCommand == 0) {
            undo.setEnabled(false);
            redo.setEnabled(true);
        } else {
            undo.setEnabled(true);
            redo.setEnabled(true);
        }
    }
}
