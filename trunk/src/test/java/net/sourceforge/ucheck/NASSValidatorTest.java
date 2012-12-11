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
