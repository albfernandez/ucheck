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
package net.sf.ucheck.tests;

import junit.framework.Assert;
import junit.framework.TestCase;
import net.sf.ucheck.validators.NifCifValidator;

import org.junit.Test;

public class NifCifValidatorTest extends TestCase {
    @Test
    public final void testIsValidCIF() {
        NifCifValidator validator = new NifCifValidator();
        Assert.assertTrue(validator.isValidCif("B24489577"));
        Assert.assertFalse(validator.isValidCif("B24489578"));
        Assert.assertTrue(validator.isValidCif(null));
        Assert.assertTrue(validator.isValidCif(""));
        Assert.assertFalse(validator.isValidCif("xx"));
        Assert.assertTrue(validator.isValidCif("P1103500C"));
        Assert.assertTrue(validator.isValidCif("P0606300B"));
        Assert.assertFalse(validator.isValidCif("P0606300C"));
        Assert.assertTrue(validator.isValidCif("B53857660"));
        Assert.assertTrue(validator.isValid("B53857660"));
        
    }
    @Test
    public final void testIsValidNIE() {
        NifCifValidator validator = new NifCifValidator();
        Assert.assertTrue(validator.isValidNie("X1234567L"));
        Assert.assertTrue(validator.isValidNie("Y1234567L"));
        Assert.assertTrue(validator.isValidNie("Z1234567L"));
        Assert.assertTrue(validator.isValidNie(null));
        Assert.assertTrue(validator.isValidNie(""));
        Assert.assertFalse(validator.isValidNie("xx"));
    }
    @Test
    public final void testIsValidNIF() {
        NifCifValidator validator = new NifCifValidator();
        Assert.assertTrue(validator.isValidNif("22222222J"));
        Assert.assertFalse(validator.isValidNif("22222222X"));
        Assert.assertTrue(validator.isValidNif(null));
        Assert.assertTrue(validator.isValidNif(""));
        Assert.assertFalse(validator.isValidNif("xx"));
    }
    @Test
    public final void testIsValid() {
        NifCifValidator validator = new NifCifValidator();
        Assert.assertTrue(validator.isValid("B24489577"));
        Assert.assertFalse(validator.isValid("B24489578"));
        Assert.assertTrue(validator.isValid("22222222J"));
        Assert.assertFalse(validator.isValid("22222222X"));
        Assert.assertTrue(validator.isValid(null));
        Assert.assertTrue(validator.isValid(""));
        Assert.assertFalse(validator.isValid("xx"));
        Assert.assertTrue(validator.isValidNifNieCif(""));
    }
    
    @Test
    public final void testGeneral () {
        NifCifValidator validator = new NifCifValidator();
        
        Assert.assertTrue(validator.isValidNifNieCif(""));
        Assert.assertTrue(validator.isValidNifNieCif(null));
        Assert.assertTrue(validator.isValidNifNieCif("B24489577"));       
        Assert.assertTrue(validator.isValidNifNieCif("22222222J"));
        Assert.assertTrue(validator.isValidNifNieCif("X1234567L"));
        Assert.assertFalse(validator.isValidNifNieCif("X"));
        
        Assert.assertTrue(validator.isValidCifNie("B24489577"));
        Assert.assertTrue(validator.isValidCifNie("X1234567L"));
        Assert.assertFalse(validator.isValidCifNie("X"));
        
        Assert.assertTrue(validator.isValidNifNie("22222222J"));
        Assert.assertTrue(validator.isValidNifNie("X1234567L"));
        Assert.assertFalse(validator.isValidNifNie("X1234567X"));
        Assert.assertFalse(validator.isValidNifNie("B24489577"));
        
        Assert.assertTrue(validator.isValidNifCif("22222222J"));
        Assert.assertTrue(validator.isValidNifCif("B24489577"));
        Assert.assertFalse(validator.isValidNifCif("X"));
        
        
        
    }

}
