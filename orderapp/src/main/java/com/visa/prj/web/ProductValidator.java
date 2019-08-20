package com.visa.prj.web;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.visa.prj.entity.Product;

@Component
public class ProductValidator extends Object implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return true;
	}

	@Override
	public void validate(Object obj, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.req", "Name is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "category", "category.req", "Category is required");

		Product p = (Product) obj;
		if(p.getPrice() <= 0) {
			errors.rejectValue("price", "price.positive", "Price should be a positive number");
		}
	}

}
