	/* File: validateNieFunction.js */	
	/**
	 * Comprueba si los campos son CIFs válidos.
	 * Los campos no se revisan si están desactivados o sin valor.
	 * <p>
	 * @param form El formulario que se está verificando.
	 */
	
	function validateNie(form){
		var isValid = true;
		var focusField = null;
		var i = 0;
		var fields = new Array();
		var formName = form.getAttributeNode("name");
		
		oNie = eval('new ' + formName.value + '_nie()');
		for (x in oNie) {
			var field = form[oCif[x][0]];
			if ((field.type == 'hidden' ||
				field.type == 'text' ||
				field.type == 'password' ||
				field.type == 'textarea') &&
				(field.value.length > 0) &&
				field.disabled == false) {
				if (!_validateNie(field.value)){
					if (i == 0) {
						focusField = field;
					}
					fields[i++] = oNie[x][1];
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
