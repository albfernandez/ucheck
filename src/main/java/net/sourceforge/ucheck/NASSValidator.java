package net.sourceforge.ucheck;

/**
 * Clase para validar el Número de Afiliación a la Seguridad Social (España).
 * 
 * @author alberto
 * 
 */
public  class NASSValidator {

    public boolean isValid(final String value) {
        return isValidNASS(value);
    }
    /**
     * 
     * @param value
     * @return
     */
    public boolean isValidNASS(final String value) {
        if (value == null || "".equals(value)) {
            return true;
        }
        if (value.matches("^[0-9]{11,12}$")) {
            long provincia = Integer.parseInt(value.substring(0, 2));
            long codigo = Integer.parseInt(value.substring(2, value.length()-2));
            long control = Integer.parseInt(value.substring(value.length()-2, value.length()));

            final String numero = "" + provincia + codigo;

            return ((Long.parseLong(numero) % 97) == control);
        }
        return false;

    }
    

    /**
     *
     */

    public NASSValidator() {
        super();
    }
}
