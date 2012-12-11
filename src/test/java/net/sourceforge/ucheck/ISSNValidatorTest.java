package net.sourceforge.ucheck;


import org.junit.Test;

import junit.framework.Assert;
import junit.framework.TestCase;

public class ISSNValidatorTest extends TestCase{
    
    @Test
    public void testISSN (){
        ISSNValidator validator = new ISSNValidator();
        Assert.assertTrue(validator.isValid("03952037"));
        Assert.assertTrue(validator.isValid(""));
        Assert.assertTrue(validator.isValid(null));
        Assert.assertFalse(validator.isValid("x"));
        Assert.assertTrue(validator.isValid("1366204X"));
    }

}
