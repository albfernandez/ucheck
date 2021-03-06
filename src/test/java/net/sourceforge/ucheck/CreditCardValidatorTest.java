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


import org.junit.Assert;
import org.junit.Test;

public class CreditCardValidatorTest {

    @Test
    public final void testIsValidCreditCard() {
        CreditCardValidator validator = new CreditCardValidator();
        Assert.assertTrue("Validacion", validator.isValid("5411068845199818"));
        Assert.assertFalse(validator.isValid("1234567812345678"));
        Assert.assertTrue("Validacion ", validator.isValid("3986829557281742"));
        Assert.assertTrue("Validacion", validator.isValid("4242424242424242"));

    }

    @Test
    public final void testIsValidCreditCard2() {
        CreditCardValidator validator = new CreditCardValidator();
        Assert.assertTrue("Validacion", validator.isValid(null));
        Assert.assertTrue("Validacion", validator.isValid(""));
        Assert.assertFalse("Validacion", validator.isValid("54110688A5199818"));

    }

}
