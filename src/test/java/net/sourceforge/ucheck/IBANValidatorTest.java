package net.sourceforge.ucheck;

import org.junit.Assert;
import org.junit.Test;

public class IBANValidatorTest {

	public IBANValidatorTest() {
		super();
	}
	
	@Test
	public void testValidIBANES() {
        Assert.assertTrue(isValidIBAN("ES80 2310 0001 1800 0001 2345"));
//		ok( isValidIBAN( "ES80 2310 0001 1800 0001 2345"), "Valid IBAN - ES");
	}
	
	@Test
    public void testValidIBAN()  {
        ok( isValidIBAN( "AL47 2121 1009 0000 0002 3569 8741"), "Valid IBAN - AL");
        ok( isValidIBAN( "AD12 0001 2030 2003 5910 0100"), "Valid IBAN - AD");
        ok( isValidIBAN( "AT61 1904 3002 3457 3201"), "Valid IBAN - AT");
        ok( isValidIBAN( "AZ21 NABZ 0000 0000 1370 1000 1944"), "Valid IBAN - AZ");
        ok( isValidIBAN( "BH67 BMAG 0000 1299 1234 56"), "Valid IBAN - BH");
        ok( isValidIBAN( "BE62 5100 0754 7061"), "Valid IBAN - BE");
        ok( isValidIBAN( "BA39 1290 0794 0102 8494"), "Valid IBAN - BA");
        ok( isValidIBAN( "BG80 BNBG 9661 1020 3456 78"), "Valid IBAN - BG");
        ok( isValidIBAN( "HR12 1001 0051 8630 0016 0"), "Valid IBAN - HR");
        ok( isValidIBAN( "CH93 0076 2011 6238 5295 7"), "Valid IBAN - CH");
        ok( isValidIBAN( "CY17 0020 0128 0000 0012 0052 7600"), "Valid IBAN - CY");
        ok( isValidIBAN( "CZ65 0800 0000 1920 0014 5399"), "Valid IBAN - CZ");
        ok( isValidIBAN( "DK50 0040 0440 1162 43"), "Valid IBAN - DK");
        ok( isValidIBAN( "EE38 2200 2210 2014 5685"), "Valid IBAN - EE");
        ok( isValidIBAN( "FO97 5432 0388 8999 44"), "Valid IBAN - FO");
        ok( isValidIBAN( "FI21 1234 5600 0007 85"), "Valid IBAN - FI");
        ok( isValidIBAN( "FR14 2004 1010 0505 0001 3M02 606"), "Valid IBAN - FR");
        ok( isValidIBAN( "GE29 NB00 0000 0101 9049 17"), "Valid IBAN - GE");
        ok( isValidIBAN( "DE89 3704 0044 0532 0130 00"), "Valid IBAN - DE");
        ok( isValidIBAN( "GI75 NWBK 0000 0000 7099 453"), "Valid IBAN - GI");
        ok( isValidIBAN( "GR16 0110 1250 0000 0001 2300 695"), "Valid IBAN - GR");
        ok( isValidIBAN( "GL56 0444 9876 5432 10"), "Valid IBAN - GL");
        ok( isValidIBAN( "HU42 1177 3016 1111 1018 0000 0000"), "Valid IBAN - HU");
        ok( isValidIBAN( "IS14 0159 2600 7654 5510 7303 39"), "Valid IBAN - IS");
        ok( isValidIBAN( "IE29 AIBK 9311 5212 3456 78"), "Valid IBAN - IE");
        ok( isValidIBAN( "IL62 0108 0000 0009 9999 999"), "Valid IBAN - IL");
        ok( isValidIBAN( "IT40 S054 2811 1010 0000 0123 456"), "Valid IBAN - IT");
        ok( isValidIBAN( "LV80 BANK 0000 4351 9500 1"), "Valid IBAN - LV");
        ok( isValidIBAN( "LB62 0999 0000 0001 0019 0122 9114"), "Valid IBAN - LB");
        ok( isValidIBAN( "LI21 0881 0000 2324 013A A"), "Valid IBAN - LI");
        ok( isValidIBAN( "LT12 1000 0111 0100 1000"), "Valid IBAN - LT");
        ok( isValidIBAN( "LU28 0019 4006 4475 0000"), "Valid IBAN - LU");
        ok( isValidIBAN( "MK07 2501 2000 0058 984"), "Valid IBAN - MK");
        ok( isValidIBAN( "MT84 MALT 0110 0001 2345 MTLC AST0 01S"), "Valid IBAN - MT");
        ok( isValidIBAN( "MU17 BOMM 0101 1010 3030 0200 000M UR"), "Valid IBAN - MU");
        ok( isValidIBAN( "MD24 AG00 0225 1000 1310 4168"), "Valid IBAN - MD");
        ok( isValidIBAN( "MC93 2005 2222 1001 1223 3M44 555"), "Valid IBAN - MC");
        ok( isValidIBAN( "ME25 5050 0001 2345 6789 51"), "Valid IBAN - ME");
        ok( isValidIBAN( "NL39 RABO 0300 0652 64"), "Valid IBAN - NL");
        ok( isValidIBAN( "NO93 8601 1117 947"), "Valid IBAN - NO");
        ok( isValidIBAN( "PK36 SCBL 0000 0011 2345 6702"), "Valid IBAN - PK");
        ok( isValidIBAN( "PL60 1020 1026 0000 0422 7020 1111"), "Valid IBAN - PL");
        ok( isValidIBAN( "PT50 0002 0123 1234 5678 9015 4"), "Valid IBAN - PT");
        ok( isValidIBAN( "RO49 AAAA 1B31 0075 9384 0000"), "Valid IBAN - RO");
        ok( isValidIBAN( "SM86 U032 2509 8000 0000 0270 100"), "Valid IBAN - SM");
        ok( isValidIBAN( "SA03 8000 0000 6080 1016 7519"), "Valid IBAN - SA");
        ok( isValidIBAN( "RS35 2600 0560 1001 6113 79"), "Valid IBAN - RS");
        ok( isValidIBAN( "SK31 1200 0000 1987 4263 7541"), "Valid IBAN - SK");
        ok( isValidIBAN( "SI56 1910 0000 0123 438"), "Valid IBAN - SI");
        ok( isValidIBAN( "ES80 2310 0001 1800 0001 2345"), "Valid IBAN - ES");
        ok( isValidIBAN( "SE35 5000 0000 0549 1000 0003"), "Valid IBAN - SE");
        ok( isValidIBAN( "CH93 0076 2011 6238 5295 7"), "Valid IBAN - CH");
        ok( isValidIBAN( "TN59 1000 6035 1835 9847 8831"), "Valid IBAN - TN");
        ok( isValidIBAN( "TR33 0006 1005 1978 6457 8413 26"), "Valid IBAN - TR");
        ok( isValidIBAN( "AE07 0331 2345 6789 0123 456"), "Valid IBAN - AE");
        ok( isValidIBAN( "GB29 NWBK 6016 1331 9268 19"), "Valid IBAN - GB");
    }
	
    private void ok (boolean resultado, String mensaje) {
        Assert.assertTrue(mensaje, resultado);
    }
    
    private boolean isValidIBAN (String iban)  {
        return IBANValidator.INSTANCE.isValidIBAN(iban.replaceAll(" ", ""));
    }
}
