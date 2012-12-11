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
package net.sourceforge.ucheck;

/**
 * 
 * @author alberto
 *
 */
public class ISBNValidator {
	
    /**
     * 
     */
    public ISBNValidator(){
        super();
    }

    /**
     * 
     * @param code
     * @return
     */
    public boolean isValidISBNCode(final String code) {
        
    	if (code == null || "".equals(code)){
            return true;
        }
        return false;
        // TODO Remove dependency on commons-validator
        /*
        org.apache.commons.validator.ISBNValidator v = 
            new org.apache.commons.validator.ISBNValidator();
        if (v.isValid(code)) {
            return true;
        } else {
            EANValidator validator = new EANValidator();
            return validator.isValidEAN13Code(code);
        }*/
    }
    /**
     * 
     * @param code
     * @return
     */
    public boolean isValid(final String code) {
        if (code == null || "".equals(code)) {
            return true;
        }
        return isValidISBNCode(code);
    }

    
    
}
