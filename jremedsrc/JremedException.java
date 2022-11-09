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
package jremedsrc;

/**
 * Jremed Exception.
 *
 */
public class JremedException extends RuntimeException {

    /**
     * Title for message box.
     */
    private String title;
    /**
     * Text for message box.
     */
    private String message;

    /**
     * Creates an exception.
     *
     * @param message message
     */
    public JremedException(String message) {
        super(message);
    }

    /**
     * Creates an exception.
     *
     * @param title title
     * @param message message
     */
    public JremedException(String title, String message) {
        super(message);
        this.title = title;
        this.message = message;
    }
}
