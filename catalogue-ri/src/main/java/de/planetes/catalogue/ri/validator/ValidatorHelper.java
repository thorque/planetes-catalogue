/**
 * 
 */
package de.planetes.catalogue.ri.validator;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

/**
 * @author kamann
 * 
 */
public class ValidatorHelper {
	private Validator validator;
	private Set<ConstraintViolation<Object>> violations;
	private String ls = System.getProperty("line.separator");

	/**
	 * @param validator
	 *            the validator to set
	 */
	public void setValidator(Validator validator) {
		this.validator = validator;
	}

	public void doValidate(Object object2Validate) {
		violations = validator.validate(object2Validate);
	}

	public boolean hasViolations() {
		return violations.size() > 0;
	}

	public String toString() {
		String message = "There are violations [" + ls;
		for (ConstraintViolation<Object> violation : violations) {
			message += violation.getRootBeanClass().getName() + "."
					+ violation.getPropertyPath() + " "
					+ violation.getMessage() + ls;
		}
		message += "]";
		return message;
	}

}
