package net.sourceforge.ucheck;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.junit.Test;

public class CreditCardValidatorTest extends TestCase {

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
