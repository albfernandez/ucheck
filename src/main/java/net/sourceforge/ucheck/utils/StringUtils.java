/*
    ucheck - A java library for commons validations.
    Copyright (C) 2008-2015  Alberto Fernandez <infjaf@gmail.com>

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package net.sourceforge.ucheck.utils;

public final class StringUtils {
	
	private StringUtils() {
		throw new AssertionError("this is a utility class, no instances are allowed");
	}

	public static boolean isBlank(final String test) {
		return test == null || "".equals(test.trim());
	}
	public static boolean isEmpty(final String test) {
		return test == null || "".equals(test);
	}
}
