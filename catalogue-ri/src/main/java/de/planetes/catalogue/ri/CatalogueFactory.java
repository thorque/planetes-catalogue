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
 * This is the factory to create all catalogue objects. There are at least one
 * static method per catalogue bean. This factory create the objects in such a
 * way the automatically bean validation is fired.
 * 
 * @author Thorsten Kamann
 * 
 * @see CatalogueValidationException
 * @see AbstractValidatedCatalogue
 */
public class CatalogueFactory {

	/**
	 * @param hours
	 * @param minutes
	 * @param seconds
	 * @return a new and validated instance of {@link IRightAscension}
	 * @throws CatalogueValidationException
	 */
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

	/**
	 * @param degree
	 * @param minutes
	 * @param seconds
	 * @return a new and validated instance of {@link IDeclination}
	 * @throws CatalogueValidationException
	 */
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

	/**
	 * @param rightAscension
	 * @param declination
	 * @return A new and validated instance of {@link IPosition}
	 * @throws CatalogueValidationException
	 */
	public static IPosition createPosition(IRightAscension rightAscension,
			IDeclination declination) throws CatalogueValidationException {
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

	/**
	 * @param name
	 * @param code
	 * @return a new and validated instance of {@link ISkyObjectType}
	 * @throws CatalogueValidationException
	 */
	public static ISkyObjectType createSkyObjectType(String name, String code)
			throws CatalogueValidationException {
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

	/**
	 * @param name
	 * @param description
	 * @param position
	 * @param type
	 * @return a new and validated instance of {@link ISkyObject}
	 * @throws CatalogueValidationException
	 */
	public static ISkyObject createSkyObject(String name, String description,
			IPosition position, ISkyObjectType type)
			throws CatalogueValidationException {
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

	/**
	 * @param name
	 * @param description
	 * @param position
	 * @param type
	 * @param constellation
	 * @param magnitude
	 * @return a new and validated instance of {@link IFixedSkyObject}
	 * @throws CatalogueValidationException
	 */
	public static IFixedSkyObject createFixedSkyObject(String name,
			String description, IPosition position, ISkyObjectType type,
			IConstellation constellation, double magnitude)
			throws CatalogueValidationException {
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

	/**
	 * @param name
	 * @param description
	 * @param position
	 * @param type
	 * @param constellation
	 * @param magnitude
	 * @return A new and validated instance of {@link IMessierObject}
	 * @throws CatalogueValidationException
	 */
	public static IMessierObject createMessierObject(String name,
			String description, IPosition position, ISkyObjectType type,
			IConstellation constellation, double magnitude)
			throws CatalogueValidationException {
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
	
	/**
	 * @param name
	 * @param code
	 * @return
	 * @throws CatalogueValidationException
	 */
	public static IConstellation createConstellation(String name,
			String code)
			throws CatalogueValidationException {
		try {
			return new Constellation(name, code);
		} catch (BeanCreationException e) {
			Throwable t = e.getRootCause();
			if (t != null && t instanceof CatalogueValidationException) {
				throw (CatalogueValidationException) e.getRootCause();
			}
		}
		return null;
	}

	/**
	 * @param name
	 * @param description
	 * @param code
	 * @param skyObjects
	 * @return A new and validated instance of {@link IConstellation}
	 * @throws CatalogueValidationException
	 */
	@Deprecated
	public static IConstellation createConstellation(String name,
			String description, String code, List<IFixedSkyObject> skyObjects)
			throws CatalogueValidationException {
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

	/**
	 * Convinience method to create a new instance of {@link IConstellation}.
	 * You can use a varargs argument instead a {@link List} to add
	 * IFixedSkyObject to the constellation.
	 * 
	 * @param name
	 * @param description
	 * @param code
	 * @param skyObjects
	 * @return A new and validated instance of {@link IConstellation}
	 * @throws CatalogueValidationException
	 */
	@Deprecated
	public static IConstellation createConstellation(String name,
			String description, String code, IFixedSkyObject... skyObjects) {
		return createConstellation(name, description, code,
				Arrays.asList(skyObjects));
	}

}
