package es.jsomoza.customvalidator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PostCodeValidator implements ConstraintValidator<PostCodeConstraint, String> {

	@Override
	public void initialize(PostCodeConstraint postCode) {
	}

	@Override
	public boolean isValid(String postCodeField, ConstraintValidatorContext cxt) {
		return postCodeField != null 
				&& postCodeField.matches("[0-9]{5}") 
					&& rangeIsCorrect(postCodeField);
	}

	private boolean rangeIsCorrect(String postCodeField) {
		int postCode = Integer.parseInt(postCodeField);
		return postCode >= 00000 && postCode <= 99999;
	}

}
