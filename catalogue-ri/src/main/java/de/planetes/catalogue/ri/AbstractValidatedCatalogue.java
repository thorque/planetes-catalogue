/**
 * 
 */
package de.planetes.catalogue.ri;

import java.util.Set;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import de.planetes.catalogue.ri.exception.CatalogueValidationException;

/**
 * @author kamann
 * 
 */
@SuppressWarnings("restriction")
public abstract class AbstractValidatedCatalogue {

	@Inject
	private Validator validator;

	@PostConstruct
	public void validate() {
		Set<ConstraintViolation<AbstractValidatedCatalogue>> violations = validator
				.validate(this);
		if (!violations.isEmpty()) {
			throw new CatalogueValidationException(violations);
		}
	}
}
