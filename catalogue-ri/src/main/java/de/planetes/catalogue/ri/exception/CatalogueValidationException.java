/**
 * 
 */
package de.planetes.catalogue.ri.exception;

import java.util.Set;

import javax.validation.ConstraintViolation;

import de.planetes.catalogue.ri.AbstractValidatedCatalogue;

/**
 * @author kamann
 *
 */
public class CatalogueValidationException extends RuntimeException {
	private Set<ConstraintViolation<AbstractValidatedCatalogue>> violations;
	private String ls = System.getProperty("line.separator");

	private static final long serialVersionUID = 1294741993137141674L;

	public CatalogueValidationException(
			Set<ConstraintViolation<AbstractValidatedCatalogue>> violations) {
		this.violations = violations;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Throwable#getLocalizedMessage()
	 */
	@Override
	public String getLocalizedMessage() {
		return getMessage();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Throwable#getMessage()
	 */
	@Override
	public String getMessage() {
		String message = "There are violations [" + ls;
		for (ConstraintViolation<AbstractValidatedCatalogue> violation : violations) {
			message += violation.getRootBeanClass().getName() + "."
					+ violation.getPropertyPath() + " "
					+ violation.getMessage() + ls;
		}
		message += "]";
		return message;
	}

}
