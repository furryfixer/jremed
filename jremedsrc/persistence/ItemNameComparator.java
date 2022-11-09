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
package jremedsrc.persistence;

import java.util.Comparator;
import jremedsrc.model.MenuItem;

/**
 * Comparator which compares menu items by it's name.
 *
 */
public class ItemNameComparator implements Comparator<MenuItem> {

    /**
     * Case insensitive comparison of two menu items. If both menu items are
     * null, 0 is returned.
     *
     * @param o1 first menu item
     * @param o2 second menu item
     * @return equality status of two menu items
     */
    public int compare(MenuItem o1, MenuItem o2) {
        if (o1.getName() == null && o2.getName() == null) {
            return 0;
        }
        if (o1.getName() == null) {
            return 1;
        }
        if (o2.getName() == null) {
            return -1;
        }
        return o1.getName().compareToIgnoreCase(o2.getName());
    }
}
