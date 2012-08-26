package cardcomparer.service;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import cardcomparer.domain.Card;

public class CardValidator implements Validator {
	
	public boolean supports(Class clazz) {
		return Card.class.equals(clazz);
	}

	public void validate(Object validationObject, Errors errors) {
		Card card = (Card) validationObject;
		
		if (card.getTitle().isEmpty()) {
			errors.rejectValue("title", "error.no-title");
		}
		if (card.getDescription().isEmpty()) {
			errors.rejectValue("description", "error.no-description");
		}
	}


}
