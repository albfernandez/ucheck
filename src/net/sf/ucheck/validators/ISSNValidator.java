/*
    ucheck - A java library for commons validations.
    Copyright (C) 2008  Alberto Fernandez <infjaf@gmail.com>

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
package net.sf.ucheck.validators;

/**
 * International Standard Serial Number
 * ISO 3297
 * @author alberto
 *
 */
public class ISSNValidator {

    /**
     *
     */
    private static final int[] PONDERACIONES = {8, 7, 6, 5, 4, 3, 2 };

    /**
     * 
     * @param code
     * @return
     */
    public boolean isValidISSNCode(final String code) {
        boolean retVal = false;
        if (code.matches("\\d{7}[0-9X]")) {
            final String code1 = code.substring(0, 7);
            final String control = code.substring(7);

            retVal = calculateControlDigit(code1).equals(control);
        }
        return retVal;

    }

    /**
     * 
     * @param code
     * @return
     */

    public String calculateControlDigit(String code) {
        int total = 0;
        for (int i = 0; i < code.length(); i++) {
            final int digit = Integer.parseInt(code.substring(i, i + 1));
            total += digit * PONDERACIONES[i];
        }
        total = 11 - (total % 11);
        if (total == 10){
            return "X";
        }
        else{
            return Integer.toString(total);
        }
    }

    /**
     * 
     * @param code
     * @return
     */

    public boolean isValid(String code) {
        if (code == null || "".equals(code)) {
            return true;
        }
        return isValidISSNCode(code);
    }

    /**
     *
     */
    public ISSNValidator() {
        super();
    }
}
