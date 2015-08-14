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

/**
 * Clase para validar el Número de Afiliación a la Seguridad Social (España).
 * 
 * @author alberto
 * 
 */
public  class NASSValidator {

	public static final NASSValidator INSTANCE = new NASSValidator();
	
    /**
    *
    */

   public NASSValidator() {
       super();
   }
    public boolean isValid(final String value) {
        return isValidNASS(value);
    }
    /**
     * 
     * @param value
     * @return
     */
    public boolean isValidNASS(final String value) {
        if (StringUtils.isEmpty(value)) {
            return true;
        }
        if (value.matches("^[0-9]{11,12}$")) {
            long provincia = Integer.parseInt(value.substring(0, 2));
            long codigo = Integer.parseInt(value.substring(2, value.length()-2));
            long control = Integer.parseInt(value.substring(value.length()-2, value.length()));

            final String numero = Long.toString(provincia) + Long.toString(codigo);

            return Long.parseLong(numero) % 97 == control;
        }
        return false;

    }
    


}
