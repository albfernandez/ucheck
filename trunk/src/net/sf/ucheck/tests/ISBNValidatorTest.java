package net.sf.ucheck.tests;

import junit.framework.TestCase;
import net.sf.ucheck.validators.ISBNValidator;

import org.junit.Assert;
import org.junit.Test;

public class ISBNValidatorTest extends TestCase{
    @Test
    public void testValidISBN () {
        ISBNValidator validator = new ISBNValidator();
        Assert.assertTrue(validator.isValid(null));
        Assert.assertTrue(validator.isValid(""));
        Assert.assertTrue(validator.isValidISBNCode(null));
        Assert.assertTrue(validator.isValidISBNCode(""));
        Assert.assertTrue(validator.isValid("9788447356027"));
        Assert.assertFalse(validator.isValid("9788495427796"));
        Assert.assertTrue(validator.isValid("848845757X"));
        Assert.assertTrue(validator.isValid("8476143885"));
        
        Assert.assertTrue(validator.isValid("9788439880370"));
        Assert.assertTrue(validator.isValid("8439880375"));
    }

}
