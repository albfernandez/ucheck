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

/**
 * 
 * http://en.wikipedia.org/wiki/European_Article_Number
 * http://en.wikipedia.org/wiki/ISBN
 * http://www.isbn.org/standards/home/isbn/transition.asp
 */
public class ISBNValidator {
	
	public static final ISBNValidator INSTANCE  = new ISBNValidator();
	
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
        return
        		isValidISBN10(code) ||
        		EANValidator.INSTANCE.isValidEAN13Code(code);
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
    
    public boolean isValidISBN10(final String code) {
    	if (code == null || "".equals(code)){
    		return true;
    	}
    	if (code.length() != 10){
    		return false;
    	}
    	int suma = 0;
    	for (int i = 0; i < 10; i++) {
    		char c = code.charAt(i);
    		if (c == 'X'){
    			suma += 10 * (10-i);
    		}
    		else {
    			suma += Integer.parseInt(Character.toString(c)) *(10-i);
    		}
    	}
    	return suma % 11 == 0;    	
 	
    }


    
    
}
