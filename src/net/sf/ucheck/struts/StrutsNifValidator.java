/*
    ucheck - A java library for commons validations.
    Copyright (C) 2008  Alberto Fernandez

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
package net.sf.ucheck.struts;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

import net.sf.ucheck.validators.NifCifValidator;

import org.apache.commons.validator.Field;
import org.apache.commons.validator.GenericValidator;
import org.apache.commons.validator.ValidatorAction;
import org.apache.commons.validator.util.ValidatorUtils;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.validator.Resources;

/**
 * @author alberto
 *
 */
public final class StrutsNifValidator implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 3026364246429836032L;
    /**
     *
     * @param bean
     * @param field
     * @return
     */

    private static String getValue(final Object bean, final Field field) {
        String value = null;
        if (isString(bean)) {
            value = (String) bean;
        } else {
            value = ValidatorUtils.getValueAsString(bean, field.getProperty());
        }
        return value;
    }
    /**
     *
     * @param bean
     * @param validatorAction
     * @param field
     * @param errors
     * @param request
     * @return
     */

    public static boolean validateNif(final Object bean, 
            final ValidatorAction validatorAction,
            final Field field, final ActionMessages errors,
            final HttpServletRequest request) {

        boolean retVal = true;
        final String value = getValue(bean, field);
        NifCifValidator nifCifValidator = new NifCifValidator();
        if (!GenericValidator.isBlankOrNull(value)
                && !nifCifValidator.isValidNif(value)) {
            errors.add(field.getKey(), Resources.getActionMessage(request,
                    validatorAction, field));
            retVal = false;
        }
        return retVal;
    }
    /**
     *
     * @param bean
     * @param validatorAction
     * @param field
     * @param errors
     * @param request
     * @return
     */

    public static boolean validateCif(final Object bean, 
            final ValidatorAction validatorAction,
            final Field field, final ActionMessages errors, 
            final HttpServletRequest request) {

        boolean retVal = true;
        final String value = getValue(bean, field);
        NifCifValidator nifCifValidator = new NifCifValidator();
        if (!GenericValidator.isBlankOrNull(value)
                && !nifCifValidator.isValidCif(value)) {
            errors.add(field.getKey(), Resources.getActionMessage(request,
                    validatorAction, field));
            retVal = false;
        }
        return retVal;
    }
    /**
     *
     * @param bean
     * @param validatorAction
     * @param field
     * @param errors
     * @param request
     * @return
     */

    public static boolean validateNie(final Object bean, 
            final ValidatorAction validatorAction,
            final Field field, final ActionMessages errors, 
            final HttpServletRequest request) {

        boolean retVal = true;
        final String value = getValue(bean, field);
        NifCifValidator nifCifValidator = new NifCifValidator();
        if (!GenericValidator.isBlankOrNull(value)
                && !nifCifValidator.isValidNie(value)) {
            errors.add(field.getKey(), Resources.getActionMessage(request,
                    validatorAction, field));
            retVal = false;
        }
        return retVal;
    }
    /**
     *
     * @param bean
     * @param validatorAction
     * @param field
     * @param errors
     * @param request
     * @return
     */
    public static boolean validateNifCif(final Object bean, 
            final ValidatorAction validatorAction,
            final Field field, final ActionMessages errors, 
            final HttpServletRequest request) {

        boolean retVal = true;
        final String value = getValue(bean, field);
        NifCifValidator nifCifValidator = new NifCifValidator();
        if (!GenericValidator.isBlankOrNull(value)
                && !nifCifValidator.isValidNifCif(value)) {
            errors.add(field.getKey(), Resources.getActionMessage(request,
                    validatorAction, field));
            retVal = false;
        }
        return retVal;
    }
    /**
     *
     * @param bean
     * @param validatorAction
     * @param field
     * @param errors
     * @param request
     * @return
     */
    public static boolean validateNifNie(final Object bean, 
            final ValidatorAction validatorAction,
            final Field field, final ActionMessages errors, 
            final HttpServletRequest request) {

        boolean retVal = true;
        final String value = getValue(bean, field);
        NifCifValidator nifCifValidator = new NifCifValidator();
        if (!GenericValidator.isBlankOrNull(value)
                && !nifCifValidator.isValidNifNie(value)) {
            errors.add(field.getKey(), Resources.getActionMessage(request,
                    validatorAction, field));
            retVal = false;
        }
        return retVal;
    }
    /**
     *
     * @param bean
     * @param validatorAction
     * @param field
     * @param errors
     * @param request
     * @return
     */

    public static boolean validateCifNie(final Object bean, 
            final ValidatorAction validatorAction,
            final Field field, final ActionMessages errors, 
            final HttpServletRequest request) {

        boolean retVal = true;
        final String value = getValue(bean, field);
        NifCifValidator nifCifValidator = new NifCifValidator();
        if (!GenericValidator.isBlankOrNull(value)
                && !nifCifValidator.isValidCifNie(value)) {
            errors.add(field.getKey(), Resources.getActionMessage(request,
                    validatorAction, field));
            retVal = false;
        }
        return retVal;
    }
    /**
     *
     * @param bean
     * @param validatorAction
     * @param field
     * @param errors
     * @param request
     * @return
     */

    public static boolean validateNifNieCif(final Object bean, 
            final ValidatorAction validatorAction,
            final Field field, final ActionMessages errors, 
            final HttpServletRequest request) {
        boolean retVal = true;
        final String value = getValue(bean, field);
        NifCifValidator nifCifValidator = new NifCifValidator();
        if (!GenericValidator.isBlankOrNull(value)
                && !nifCifValidator.isValidNifNieCif(value)) {
            errors.add(field.getKey(), Resources.getActionMessage(request,
                    validatorAction, field));
           retVal = false;
        }
        return retVal;
    }

    /**
     * Return <code>true</code> if the specified object is a String or a
     * <code>null</code> value.
     *
     * @param test
     *            Object to be tested
     * @return The string value
     */
    protected static boolean isString(final Object test) {
        return (test == null) ? true : String.class.isInstance(test);
    }
    /**
     *
     */
    private StrutsNifValidator() {
        // Empty private constructor
        // No instances of this class allowed
    }
}
