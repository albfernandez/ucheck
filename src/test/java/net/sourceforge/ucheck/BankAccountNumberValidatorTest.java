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

import org.junit.Test;

import junit.framework.Assert;
import junit.framework.TestCase;

public class BankAccountNumberValidatorTest extends TestCase {

    @Test
    public final void testIsValidBankAccountNumber() {
        BankAccountNumberValidator validator = new BankAccountNumberValidator();
        Assert.assertTrue(validator
                .isValidBankAccountNumber("2100-0150-63-0200455826"));
        Assert.assertFalse(validator
                .isValidBankAccountNumber("2100-0150-63-0200455827"));
        Assert.assertTrue(validator.isValidBankAccountNumber(
                "2077-0024-00-3102575766"));
        
    }

    @Test
    public final void testIsValidBankAccountNumbe2r() {
        BankAccountNumberValidator validator = new BankAccountNumberValidator();
        Assert.assertTrue(validator.isValidBankAccountNumber(null));
        Assert.assertTrue(validator.isValidBankAccountNumber(""));
        Assert.assertFalse(validator.isValidBankAccountNumber("cx"));
        Assert.assertTrue(validator.isValidBankAccountNumber(null));

    }
}
