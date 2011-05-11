/**
 * 
 */
package de.planetes.catalogue.ri;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.BeanCreationException;

import de.planetes.catalogue.IConstellation;
import de.planetes.catalogue.IDeclination;
import de.planetes.catalogue.IFixedSkyObject;
import de.planetes.catalogue.IMessierObject;
import de.planetes.catalogue.IPosition;
import de.planetes.catalogue.IRightAscension;
import de.planetes.catalogue.ISkyObject;
import de.planetes.catalogue.ISkyObjectType;
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

	public static ISkyObjectType createSkyObjectType(String name, String code) {
		try {
			return new SkyObjectType(name, code);
		} catch (BeanCreationException e) {
			Throwable t = e.getRootCause();
			if (t != null && t instanceof CatalogueValidationException) {
				throw (CatalogueValidationException) e.getRootCause();
			}
		}
		return null;
	}

	public static ISkyObject createSkyObject(String name, String description,
			IPosition position, ISkyObjectType type) {
		try {
			return new SkyObject(name, description, position, type);
		} catch (BeanCreationException e) {
			Throwable t = e.getRootCause();
			if (t != null && t instanceof CatalogueValidationException) {
				throw (CatalogueValidationException) e.getRootCause();
			}
		}
		return null;
	}

	public static IFixedSkyObject createFixedSkyObject(String name,
			String description, IPosition position, ISkyObjectType type,
			IConstellation constellation, double magnitude) {
		try {
			return new FixedSkyObject(name, description, position, type,
					constellation, magnitude);
		} catch (BeanCreationException e) {
			Throwable t = e.getRootCause();
			if (t != null && t instanceof CatalogueValidationException) {
				throw (CatalogueValidationException) e.getRootCause();
			}
		}
		return null;
	}

	public static IMessierObject createMessierObject(String name,
			String description, IPosition position, ISkyObjectType type,
			IConstellation constellation, double magnitude) {
		try {
			return new MessierObject(name, description, position, type,
					constellation, magnitude);
		} catch (BeanCreationException e) {
			Throwable t = e.getRootCause();
			if (t != null && t instanceof CatalogueValidationException) {
				throw (CatalogueValidationException) e.getRootCause();
			}
		}
		return null;
	}

	public static IConstellation createConstellation(String name,
			String description, String code, List<IFixedSkyObject> skyObjects) {
		try {
			return new Constellation(name, description, code, skyObjects);
		} catch (BeanCreationException e) {
			Throwable t = e.getRootCause();
			if (t != null && t instanceof CatalogueValidationException) {
				throw (CatalogueValidationException) e.getRootCause();
			}
		}
		return null;
	}

	public static IConstellation createConstellation(String name,
			String description, String code, IFixedSkyObject... skyObjects) {
		return createConstellation(name, description, code,
				Arrays.asList(skyObjects));
	}

}
