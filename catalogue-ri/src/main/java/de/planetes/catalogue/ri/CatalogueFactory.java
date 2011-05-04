/**
 * 
 */
package de.planetes.catalogue.ri;

import org.springframework.beans.factory.BeanCreationException;

import de.planetes.catalogue.IDeclination;
import de.planetes.catalogue.IPosition;
import de.planetes.catalogue.IRightAscension;
import de.planetes.catalogue.ri.exception.CatalogueValidationException;

/**
 * @author kamann
 * 
 */
public class CatalogueFactory {

	public static IRightAscension createRightAscension(int hours, int minutes,
			double seconds) throws CatalogueValidationException {
		try {
			return new RightAscension(hours, minutes, seconds);
		} catch (BeanCreationException e) {
			Throwable t = e.getRootCause();
			if (t != null && t instanceof CatalogueValidationException) {
				throw (CatalogueValidationException) e.getRootCause();
			}
		}
		return null;
	}

	public static IDeclination createDeclination(int degree, int minutes,
			double seconds) throws CatalogueValidationException {
		try {
			return new Declination(degree, minutes, seconds);
		} catch (BeanCreationException e) {
			Throwable t = e.getRootCause();
			if (t != null && t instanceof CatalogueValidationException) {
				throw (CatalogueValidationException) e.getRootCause();
			}
		}
		return null;
	}

	public static IPosition createPosition(IRightAscension rightAscension,
			IDeclination declination) {
		try {
			return new Position(rightAscension, declination);
		} catch (BeanCreationException e) {
			Throwable t = e.getRootCause();
			if (t != null && t instanceof CatalogueValidationException) {
				throw (CatalogueValidationException) e.getRootCause();
			}
		}
		return null;
	}
}
