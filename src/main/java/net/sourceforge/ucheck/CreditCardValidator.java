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
package net.sourceforge.ucheck;

import net.sourceforge.ucheck.utils.StringUtils;

public class CreditCardValidator {
	public static final CreditCardValidator INSTANCE = new CreditCardValidator();
	
    /**
     * 
     */
    public CreditCardValidator () {
        super();
    }

    /**
     * 
     * @param value
     * @return
     */
    public boolean isValid(String value) {
        if (StringUtils.isEmpty(value)) {
            return true;
        }
        if (value.matches("^[0-9]{16}$")) {
            int valA = 0;
            int valB = 0;
            for (int i = 0; i < value.length(); i += 2) {
                char c = value.charAt(i);
                int tmp = Character.getNumericValue(c);
                tmp = (tmp * 2);
                if (tmp > 9) {
                    tmp = tmp - 9;
                }
                valA += tmp;
            }
            for (int i = 1; i < value.length() - 1; i += 2) {
                valB += Character.getNumericValue(value.charAt(i));
            }
            int control = 10 - ((valA + valB) % 10);
            int last = Character.getNumericValue(value.charAt(15));
            return control == last;
        }
        return false;
    }
    

}
