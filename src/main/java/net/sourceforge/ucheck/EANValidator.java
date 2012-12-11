/*
    ucheck - A java library for commons validations.
    Copyright (C) 2008-2012  Alberto Fernandez <infjaf@gmail.com>

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
package net.sourceforge.ucheck;

import net.sourceforge.ucheck.utils.StringUtils;

/**
 * 
 * @author alberto
 *
 */
public class EANValidator {
	
	public static final EANValidator INSTANCE = new EANValidator();
	
    /**
     * 
     */

    public EANValidator() {
        super();
    }
	
    /**
     * 
     * @param code
     * @return
     */
    private String calculateControlDigit(final String code) {
        int pares = 0;
        int impares = 0;
        for (int i = code.length(); i > 0; i--) {
            final String digit = code.substring(i - 1, i);
            if ((code.length() - i) % 2 == 0) {
                pares += Integer.parseInt(digit);
            } else {
                impares += Integer.parseInt(digit);
            }
        }

        int total = (pares * 3) + impares;
        int check = 10 - (total % 10);
        if (check == 10){
            check = 0;
        }
        return Integer.toString(check);
    }
    /**
     * 
     * @param code
     * @return
     */
    public boolean isValidEAN8Code(final String code) {
        if (StringUtils.isEmpty(code)){
            return true;
        }
        boolean retVal = false;
        if (code.matches("\\d{8}")) {
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
    public boolean isValidEAN13Code(final String code) {
        if (StringUtils.isEmpty(code)){
            return true;
        }
        boolean retVal = false;
        if (code.matches("\\d{13}")) {
            final String code1 = code.substring(0, 12);
            final String control = code.substring(12);
            retVal = calculateControlDigit(code1).equals(control);
        }
        return retVal;
    }
    /**
     * 
     * @param code
     * @return
     */
    public boolean isValid(final String code) {
        return isValidEAN8Code(code) || isValidEAN13Code(code);
    }

}
