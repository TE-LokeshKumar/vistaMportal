package com.te.vistaMportal.validator;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.te.vistaMportal.transaction_bean.Payments;

//@Component
public class PaymentValidation implements Validator{

	@Autowired
	private MessageSource messageSource;

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Payments.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Payments payments = (Payments) target;
	//	ValidationUtils.rejectIfEmpty(errors, "Date", messageSource.getMessage("", null,""));
		ValidationUtils.rejectIfEmpty(errors, "name",
                messageSource.getMessage("payments.date.error", null, Locale.getDefault()));
		
		/*
		 * if (payments.getPaymentDate() ) {
		 * 
		 * }
		 */
	}
	
	
}
