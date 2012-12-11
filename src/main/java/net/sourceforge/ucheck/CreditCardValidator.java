package net.sourceforge.ucheck;

public class CreditCardValidator {

    /**
     * 
     * @param value
     * @return
     */
    public boolean isValid(String value) {
        if (value == null || "".equals(value)) {
            return true;
        }
        if (value.matches("^[0-9]{16}$")) {
            int valA = 0;
            int valB = 0;
            for (int i = 0; i < value.length(); i += 2) {
                char c = value.charAt(i);
                int tmp = Character.getNumericValue(c);
                tmp = (tmp * 2);
                if (tmp > 9) {
                    tmp = tmp - 9;
                }
                valA += tmp;
            }
            for (int i = 1; i < value.length() - 1; i += 2) {
                valB += Character.getNumericValue(value.charAt(i));
            }
            int control = 10 - ((valA + valB) % 10);
            int last = Character.getNumericValue(value.charAt(15));
            return control == last;
        }
        return false;
    }
    
    /**
     * 
     */
    public CreditCardValidator () {
        super();
    }
}
