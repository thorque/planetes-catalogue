/**
 * 
 */
package de.planetes.catalogue.ri.exception;

import java.util.Set;

import javax.naming.OperationNotSupportedException;
import javax.validation.ConstraintViolation;

import de.planetes.catalogue.ri.AbstractValidatedCatalogue;

/**
 * Exception thrown if validation errors occured during bean validation.
 * 
 * @author Thorsten Kamann
 * 
 */
public class CatalogueValidationException extends RuntimeException {
	private Set<ConstraintViolation<AbstractValidatedCatalogue>> violations;
	private String ls = System.getProperty("line.separator");

	private static final long serialVersionUID = 1294741993137141674L;
	private final String constructor_error_msg = "Use only CatalogueValidationException(Set<ConstraintViolation<AbstractValidatedCatalogue>>";

	/**
	 * The only ready to use constructor. The validator transmit the validation
	 * errors to this exception class. All other constructors are not a valid
	 * option.
	 * 
	 * @param violations
	 */
	public CatalogueValidationException(
			Set<ConstraintViolation<AbstractValidatedCatalogue>> violations) {
		this.violations = violations;
	}

	/**
	 * @throws OperationNotSupportedException
	 * 
	 */
	protected CatalogueValidationException()
			throws OperationNotSupportedException {
		throw new OperationNotSupportedException(constructor_error_msg);
	}

	/**
	 * @param message
	 * @param cause
	 * @throws OperationNotSupportedException
	 */
	protected CatalogueValidationException(String message, Throwable cause)
			throws OperationNotSupportedException {
		throw new OperationNotSupportedException(constructor_error_msg);
	}

	/**
	 * @param message
	 * @throws OperationNotSupportedException
	 */
	protected CatalogueValidationException(String message)
			throws OperationNotSupportedException {
		throw new OperationNotSupportedException(constructor_error_msg);
	}

	/**
	 * @param cause
	 * @throws OperationNotSupportedException
	 */
	protected CatalogueValidationException(Throwable cause)
			throws OperationNotSupportedException {
		throw new OperationNotSupportedException(constructor_error_msg);
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
