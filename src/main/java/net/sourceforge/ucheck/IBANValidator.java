package net.sourceforge.ucheck;


import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import net.sourceforge.ucheck.utils.StringUtils;

public class IBANValidator {

    private static final long MAX = 999999999;

    private static final long MODULUS = 97;
	public static final IBANValidator INSTANCE = new IBANValidator();
	 private Map<String, String> countryPatterns= new HashMap<String, String>();
	public IBANValidator() {
		super();
		 initCountryPatterns();
	}
	private void initCountryPatterns() {
        this.countryPatterns.put("AL", "\\d{8}[\\dA-Z]{16}");
        this.countryPatterns.put("AD", "\\d{8}[\\dA-Z]{12}");
        this.countryPatterns.put("AT", "\\d{16}");
        this.countryPatterns.put("AZ", "[\\dA-Z]{4}\\d{20}");
        this.countryPatterns.put("BE", "\\d{12}");
        this.countryPatterns.put("BH", "[A-Z]{4}[\\dA-Z]{14}");
        this.countryPatterns.put("BA", "\\d{16}");
        this.countryPatterns.put("BR", "\\d{23}[A-Z][\\dA-Z]");
        this.countryPatterns.put("BG", "[A-Z]{4}\\d{6}[\\dA-Z]{8}");
        this.countryPatterns.put("CR", "\\d{17}");
        this.countryPatterns.put("HR", "\\d{17}");
        this.countryPatterns.put("CY", "\\d{8}[\\dA-Z]{16}");
        this.countryPatterns.put("CZ", "\\d{20}");
        this.countryPatterns.put("DK", "\\d{14}");
        this.countryPatterns.put("DO", "[A-Z]{4}\\d{20}");
        this.countryPatterns.put("EE", "\\d{16}");
        this.countryPatterns.put("FO", "\\d{14}");
        this.countryPatterns.put("FI", "\\d{14}");
        this.countryPatterns.put("FR", "\\d{10}[\\dA-Z]{11}\\d{2}");
        this.countryPatterns.put("GE", "[\\dA-Z]{2}\\d{16}");
        this.countryPatterns.put("DE", "\\d{18}");
        this.countryPatterns.put("GI", "[A-Z]{4}[\\dA-Z]{15}");
        this.countryPatterns.put("GR", "\\d{7}[\\dA-Z]{16}");
        this.countryPatterns.put("GL", "\\d{14}");
        this.countryPatterns.put("GT", "[\\dA-Z]{4}[\\dA-Z]{20}");
        this.countryPatterns.put("HU", "\\d{24}");
        this.countryPatterns.put("IS", "\\d{22}");
        this.countryPatterns.put("IE", "[\\dA-Z]{4}\\d{14}");
        this.countryPatterns.put("IL", "\\d{19}");
        this.countryPatterns.put("IT", "[A-Z]\\d{10}[\\dA-Z]{12}");
        this.countryPatterns.put("KZ", "\\d{3}[\\dA-Z]{13}");
        this.countryPatterns.put("KW", "[A-Z]{4}[\\dA-Z]{22}");
        this.countryPatterns.put("LV", "[A-Z]{4}[\\dA-Z]{13}");
        this.countryPatterns.put("LB", "\\d{4}[\\dA-Z]{20}");
        this.countryPatterns.put("LI", "\\d{5}[\\dA-Z]{12}");
        this.countryPatterns.put("LT", "\\d{16}");
        this.countryPatterns.put("LU", "\\d{3}[\\dA-Z]{13}");
        this.countryPatterns.put("MK", "\\d{3}[\\dA-Z]{10}\\d{2}");
        this.countryPatterns.put("MT", "[A-Z]{4}\\d{5}[\\dA-Z]{18}");
        this.countryPatterns.put("MR", "\\d{23}");
        this.countryPatterns.put("MU", "[A-Z]{4}\\d{19}[A-Z]{3}");
        this.countryPatterns.put("MC", "\\d{10}[\\dA-Z]{11}\\d{2}");
        this.countryPatterns.put("MD", "[\\dA-Z]{2}\\d{18}");
        this.countryPatterns.put("ME", "\\d{18}");
        this.countryPatterns.put("NL", "[A-Z]{4}\\d{10}");
        this.countryPatterns.put("NO", "\\d{11}");

        this.countryPatterns.put("PK", "[\\dA-Z]{4}\\d{16}");
        this.countryPatterns.put("PS", "[\\dA-Z]{4}\\d{21}");
        this.countryPatterns.put("PL", "\\d{24}");
        this.countryPatterns.put("PT", "\\d{21}");
        this.countryPatterns.put("RO", "[A-Z]{4}[\\dA-Z]{16}");
        this.countryPatterns.put("SM", "[A-Z]\\d{10}[\\dA-Z]{12}");
        this.countryPatterns.put("SA", "\\d{2}[\\dA-Z]{18}");
        this.countryPatterns.put("RS", "\\d{18}");
        this.countryPatterns.put("SK", "\\d{20}");
        this.countryPatterns.put("SI", "\\d{15}");
        this.countryPatterns.put("ES", "\\d{20}");
        this.countryPatterns.put("SE", "\\d{20}");
        this.countryPatterns.put("CH", "\\d{5}[\\dA-Z]{12}");
        this.countryPatterns.put("TN", "\\d{20}");
        this.countryPatterns.put("TR", "\\d{5}[\\dA-Z]{17}");
        this.countryPatterns.put("AE", "\\d{3}\\d{16}");
        this.countryPatterns.put("GB", "[A-Z]{4}\\d{14}");
        this.countryPatterns.put("VG", "[\\dA-Z]{4}\\d{16}");
    }
	
	public boolean isValidIBAN(String iban) {
		if (StringUtils.isEmpty(iban)){
			return true;
		}
		String iban1 = getCleanIBAN(iban);
		if (StringUtils.isBlank(iban1) || iban1.length() < 5) {
			return false;
		}
		String countryCode = iban1.substring(0, 2);
		if (!isValidPattern(iban1)) {
            return false;
        }
		boolean valid = isValid(iban1);
		if (!valid) {
			return false;
		}		
		if ("ES".equals(countryCode)){
			String bank =iban1.substring(4,8);
			String sucursal = iban1.substring(8,12);
			String control = iban1.substring(12,14);
			String cuenta = iban1.substring(14);
			String test = bank + "-" + sucursal + "-" + control + "-" + cuenta;
			return BankAccountNumberValidator.INSTANCE.isValidBankAccountNumber(test);
		}
		return valid;
		
	}
	
	private boolean isValidPattern(String iban1) {
        String countryCode = iban1.substring(0, 2);
        String pattern = getPattern(countryCode);
        // As new countries will start using IBAN in the
        // future, we only check if the countrycode is known.
        // This prevents false negatives, while almost all
        // false positives introduced by this, will be caught
        // by the checksum validation below anyway.
        // Strict checking should return FALSE for unknown
        // countries.
        if (pattern != null ) {
            return iban1.matches(pattern);
        }
        return true;
    }
	
    private String getPattern(String countryCode) {
        String pattern = this.countryPatterns.get(countryCode);
        if (pattern != null) {
            pattern = "^[A-Z]{2}\\d{2}" + pattern + "$";
        }
        return pattern;
    }
	
	public static String getCleanIBAN(String iban) {
		if (StringUtils.isBlank(iban)) {
            return "";
        }
        String iban1 = iban.replaceAll(" ", "").toUpperCase(Locale.ENGLISH);
        if (iban1.startsWith("IBAN")) {
            iban1 = iban1.substring(4);
        }
        return iban1;
	}

	private boolean isValid(String iban) {
		if (StringUtils.isBlank(iban) || iban.length() < 5) {
			return false;
		}

		int modulusResult = calculateModulus(iban);
		return modulusResult == 1;

	}
	 private int calculateModulus(String code) {
	        String reformattedCode = code.substring(4) + code.substring(0, 4);
	        long total = 0;
	        for (int i = 0; i < reformattedCode.length(); i++) {
	            int charValue = Character.getNumericValue(reformattedCode.charAt(i));
	            if (charValue < 0 || charValue > 35) {
	            	// invalid
	                return -1;
	            }
	            total = (charValue > 9 ? total * 100 : total * 10) + charValue;
	            if (total > MAX) {
	                total = total % MODULUS;
	            }
	        }
	        return (int)(total % MODULUS);
	    }
}
