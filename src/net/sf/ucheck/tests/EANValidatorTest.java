package net.sf.ucheck.tests;

import junit.framework.TestCase;
import net.sf.ucheck.validators.EANValidator;

import org.junit.Assert;
import org.junit.Test;

public class EANValidatorTest extends TestCase{
    @Test
    public void testEAN () {
        EANValidator validator = new EANValidator();
        Assert.assertTrue(validator.isValidEAN8Code(""));
        Assert.assertTrue(validator.isValidEAN8Code(null));
        Assert.assertFalse(validator.isValidEAN8Code("x"));
        Assert.assertTrue(validator.isValidEAN8Code("84160089"));
        Assert.assertFalse(validator.isValidEAN8Code("84160081"));
        Assert.assertFalse(validator.isValidEAN8Code("8429359002008"));
        Assert.assertFalse(validator.isValidEAN8Code("8429359002009"));
        
        Assert.assertTrue(validator.isValidEAN13Code(null));
        Assert.assertTrue(validator.isValidEAN13Code(""));
        Assert.assertFalse(validator.isValidEAN13Code("x"));
        Assert.assertFalse(validator.isValidEAN13Code("84160089"));
        Assert.assertFalse(validator.isValidEAN13Code("84160081"));
        Assert.assertTrue(validator.isValidEAN13Code("8429359002008"));
        Assert.assertFalse(validator.isValidEAN13Code("8429359002009"));
        
        Assert.assertTrue(validator.isValid(""));
        Assert.assertTrue(validator.isValid(null));
        Assert.assertFalse(validator.isValid("x"));
        Assert.assertTrue(validator.isValid("84160089"));
        Assert.assertFalse(validator.isValid("84160081"));
        Assert.assertTrue(validator.isValid("8429359002008"));
        Assert.assertFalse(validator.isValid("8429359002009"));
        Assert.assertTrue(validator.isValid("12345670"));
        
        
        
    }

}
