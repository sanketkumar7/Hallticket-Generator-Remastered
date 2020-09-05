package com.hallTicket.factory;

import com.hallTicket.validate.ValidateImpl;

public class ValidateImplFactory {
	private ValidateImpl validateimpl=null;
	{
		validateimpl=new ValidateImpl();
	}
	public ValidateImpl getValidateimpl() {
		return validateimpl;
	}
}
