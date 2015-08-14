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

public class ISBNValidatorTest {
    @Test
    public void testValidISBN () {
        ISBNValidator validator = new ISBNValidator();
        Assert.assertTrue(validator.isValid(null));
        Assert.assertTrue(validator.isValid(""));
        Assert.assertTrue(validator.isValidISBN10(null));
        Assert.assertTrue(validator.isValidISBN10(""));
        Assert.assertTrue(validator.isValidISBNCode(null));
        Assert.assertTrue(validator.isValidISBNCode(""));
        Assert.assertTrue(validator.isValid("9788447356027"));
        Assert.assertFalse(validator.isValid("9788495427796"));
        Assert.assertTrue(validator.isValid("848845757X"));
        Assert.assertTrue(validator.isValid("8476143885"));
        Assert.assertFalse(validator.isValid("8476143880"));
        
        Assert.assertTrue(validator.isValid("9788439880370"));
        Assert.assertTrue(validator.isValid("8439880375"));
    }

}
