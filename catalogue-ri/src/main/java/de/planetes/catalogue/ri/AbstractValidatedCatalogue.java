/**
 * 
 */
package de.planetes.catalogue.ri;

import java.util.Set;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Configurable;

import de.planetes.catalogue.ri.exception.CatalogueValidationException;

/**
 * This abstract class provides a @{@link PostConstruct} method to vaildate
 * (JSR-303) the vreated bean. This is done automatically. The bean inherits
 * from this class and the bean need the annotation {@link Configurable}.
 * 
 * @author Thorsten Kamann
 * 
 */
@SuppressWarnings("restriction")
public abstract class AbstractValidatedCatalogue extends AbstractIdentifiedCatalogObject {

	@Inject
	private Validator validator;

	/**
	 * This method fires the bean validation. If one or more validation errors
	 * occur a {@link CatalogueValidationException} is raised.
	 */
	@PostConstruct
	public void validate() {
		Set<ConstraintViolation<AbstractValidatedCatalogue>> violations = validator
				.validate(this);
		if (!violations.isEmpty()) {
			throw new CatalogueValidationException(violations);
		}
	}
}
