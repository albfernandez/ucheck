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

import junit.framework.Assert;
import junit.framework.TestCase;

import org.junit.Test;

public class NASSValidatorTest extends TestCase{

    @Test 
    public void testNASS(){
        NASSValidator validator = new NASSValidator();
        Assert.assertTrue(validator.isValidNASS(""));
        Assert.assertTrue(validator.isValidNASS(null));
        Assert.assertTrue(validator.isValid(null));
        Assert.assertTrue(validator.isValid("121001442752"));
        Assert.assertTrue(validator.isValid("280123456742"));
        Assert.assertTrue(validator.isValid("280234567818"));   
        Assert.assertTrue(validator.isValid("281234567840"));
        Assert.assertTrue(validator.isValid("28123456742"));
        
        Assert.assertFalse(validator.isValid("X"));
        
        Assert.assertFalse(validator.isValid("28123456743"));
        Assert.assertFalse(validator.isValid("281234567843"));        
    }
}
