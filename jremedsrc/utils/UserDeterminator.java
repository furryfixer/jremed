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
package jremedsrc.utils;

/**
 * Identifies whether a user launching an application is root or not.
 */
public class UserDeterminator {

    /**
     * Determines a user and sets IS_ROOT attribute in Configuration class.
     * @see Configuration#IS_ROOT
     */
    public static void determineUser() {
        String userId = ProcessExecutor.execute("id -u");

        Integer id = Integer.parseInt(userId);

        if (id == 0) {
            Configuration.IS_ROOT = true;
        } else {
            Configuration.IS_ROOT = false;
        }
    }
}
