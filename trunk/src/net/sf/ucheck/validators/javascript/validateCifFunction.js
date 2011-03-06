	/* File: validateCifFunction.js */
	/**
	 * Comprueba si los campos son CIFs válidos.
	 * Los campos no se revisan si están desactivados o sin valor.
	 * <p>
	 * @param form El formulario que se está verificando.
	 */

	function validateCif(form){
		var isValid = true;
		var focusField = null;
		var i = 0;
		var fields = new Array();
		var formName = form.getAttributeNode("name");

		oCif = eval('new ' + formName.value + '_cif()');
		for (x in oCif) {
			var field = form[oCif[x][0]];
			if ((field.type == 'hidden' ||
				field.type == 'text' ||
				field.type == 'password' ||
				field.type == 'textarea') &&
				(field.value.length > 0) &&
				field.disabled == false) {
				
				if (!_validateCif(field.value)){
					if (i == 0) {
						focusField = field;
					}
					fields[i++] = oCif[x][1];
					isValid = false;
				}
			}
		}
		if (fields.length > 0) {
			focusField.focus();
			alert(fields.join('\n'));
		}
		return isValid;
	}

