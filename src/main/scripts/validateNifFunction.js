	/* File: validateNifFunction.js */
	

	function matches(re, str){
		return re.test(str);		
	}
	/**
	 * Comprueba si el valor es un NIF
	 * <p>
	 * @param nif La cadena de texto a verificar
	 */
	function _validateNif(nif){
		if (matches(/^[0-9]{1,8}[A-Z]$/,nif)){
			var letrasNif = "TRWAGMYFPDXBNJZSQVHLCKEO";
			var numero = nif.substring(0, nif.length-1);
			var pos_letra = numero % 23;
			var letra = letrasNif.charAt(pos_letra);
			return (nif.charAt(nif.length-1) == letra);
		}		
		return false;		
	}
	/**
	 * Comprueba si el valor es un NIE
	 * <p>
	 * @param nif La cadena de texto a verificar
	 */
	function _validateNie(nie){
		if (matches(/^X[0-9]{1,7}[A-Z]$/, nie)){
			return _validateNif(nie.substring(1));
		}
		return false;
	}
	/**
	 * Calcula el digito de control de un cif
	 * <p>
	 * @param nif El número del cif (sin primera letra ni digito de control)
	 */
	function digitoControlCif(numero){
		var control = 0;
		for (var i = 0; i < numero.length; i++) {
			var digito = parseInt(numero.charAt(i));

			if ( (i % 2) == 0){
				digito = digito * 2;
				if (digito >= 10){
					control += 1;
					control += (digito - 10);
				}
				else {
					control += digito;
				}
			}
			else {
				control += digito;
			}   			
		}
		return (10 - (control % 10));		
	}
	
	/**
	 * Comprueba si el valor es un CIF
	 * <p>
	 * @param nif La cadena de texto a verificar
	 */
	function _validateCif(cif){
		var letrasCIF = "JABCDEFGHIJ";
		if (matches(/^[ABCDEFGHKLMN][0-9]{8}$/, cif)){
			var digitoControl = digitoControlCif(cif.substring(1,8));
			return (digitoControl == cif.charAt(8));
		}
		else if (matches(/^[PQS][0-9]{7}[A-J]$/, cif)){
			var digitoControl = digitoControlCif(cif.substring(1,8));
			var charControl = letrasCif.charAt(digitoControl);
			return (charControl == cif.charAt(8));
		}
		return false;
	}
	
	/**
	 * Comprueba si el valor es un NIF o un NIE
	 * <p>
	 * @param nif La cadena de texto a verificar
	 */
	function _validateNifNie(value){
		return (_validateNif(value) || _validateNie(value));
	}
	/**
	 * Comprueba si el valor es un NIF o un CIF
	 * <p>
	 * @param nif La cadena de texto a verificar
	 */
	function _validateNifCif(value){
		return (_validateNif(value) || _validateCif(value));
	}
	/**
	 * Comprueba si el valor es un CIF o un NIE
	 * <p>
	 * @param nif La cadena de texto a verificar
	 */
	function _validateCifNie(value){
		return (_validateCif(value) || _validateNie(value));
	}
	/**
	 * Comprueba si el valor es un NIF, NIE o CIF
	 * <p>
	 * @param nif La cadena de texto a verificar
	 */
	function _validateNifNieCif(value){
		return (_validateNif(value) || _validateNie(value) || _validateCif(value));
	}
	
	/**
	 * Comprueba si los campos son NIFs válidos.
	 * Los campos no se revisan si están desactivados o sin valor.
	 * <p>
	 * @param form El formulario que se está verificando.
	 */
	function validateNif(form){
		var isValid = true;
		var focusField = null;
		var i = 0;
		var fields = new Array();
		var formName = form.getAttributeNode("name");
		
		oNif = eval('new ' + formName.value + '_nif()');
		for (x in oNif) {
			var field = form[oNif[x][0]];
			if ((field.type == 'hidden' ||
				field.type == 'text' ||
				field.type == 'password' ||
				field.type == 'textarea') &&
				(field.value.length > 0) &&
				field.disabled == false) {
				if (!_validateNif(field.value)){
					if (i == 0) {
						focusField = field;
					}
					fields[i++] = oNif[x][1];
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
