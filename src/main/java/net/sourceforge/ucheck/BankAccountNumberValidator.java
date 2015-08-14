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
 * Comprueba que un codigo de cuenta bancaria es correcto.
 * @author alberto
 *
 */
public class BankAccountNumberValidator {
	

	public static final BankAccountNumberValidator INSTANCE = new BankAccountNumberValidator();
    /**
     * Pesos de los digitos
     */
    private static final int[] WEIGHTS = new int[] {1, 2, 4, 8, 5, 10, 9, 7, 3, 6 };


    /**
     */
    public BankAccountNumberValidator() {
        super();
    }
    /**
     * Comprueba que un numero de Cuenta Corriente es correcto.
     * @param value El numero de cuenta a comprobar
     * @return true si es correcto, false en otro caso
     */
    public boolean isValidBankAccountNumber(final String value) {
        if (StringUtils.isEmpty(value)) {
            return true;
        }
        if (value.matches("[0-9]{4}-[0-9]{4}-[0-9]{2}-[0-9]{10}")) {
            final String[] blocks = value.split("-");
            final int control = getControlDigits(blocks[0] + blocks[1], blocks[3]);
            return control == Integer.parseInt(blocks[2]);
        }
        return false;
    }

    /**
     * Obtiene los digitos de control.
     * @param office Oficina bancaria
     * @param account Cuenta bancaria
     * @return
     */
    protected int getControlDigits(
            final String office, final String account) {

        int officeControl = 0;
        int accountControl = 0;

        for (int i = 0; i < office.length(); i++) {
            final int digit = Character.getNumericValue(office.charAt(i));
            officeControl += digit * WEIGHTS[i + 2];
        }
        int remainder = officeControl % 11;
        officeControl = 11 - remainder;
        if (officeControl >= 10) {
            officeControl = remainder;
        }
        for (int i = 0; i < account.length(); i++) {
            final int digit = Character.getNumericValue(account.charAt(i));
            accountControl += digit * WEIGHTS[i];
        }
        remainder = accountControl % 11;
        accountControl = 11 - remainder;
        if (accountControl >= 10) {
            accountControl = remainder;
        }
        return officeControl * 10 + accountControl;
    }

}
