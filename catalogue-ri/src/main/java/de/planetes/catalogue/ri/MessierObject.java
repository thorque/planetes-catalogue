/**
 * 
 */
package de.planetes.catalogue.ri;

import org.springframework.beans.factory.annotation.Configurable;

import de.planetes.catalogue.IConstellation;
import de.planetes.catalogue.IFixedSkyObject;
import de.planetes.catalogue.IMessierObject;
import de.planetes.catalogue.IPosition;
import de.planetes.catalogue.ISkyObjectType;

/**
 * A {@link MessierObject} is an extension of the {@link FixedSkyObject}. It's
 * only marks a {@link FixedSkyObject} as {@link MessierObject}. This helps to
 * find {@link MessierObject}s a little bit more efficiently.
 * 
 * Like the {@link IFixedSkyObject} implementation instances of this class are
 * validated and can be created like this snippet:
 * 
 * <pre>
 * 		<code>IMessierObject messierObject = CatalogueFactory.createMessierObject(String, String, IPosition, ISkyObjectType, IConstellation, double)</code>
 * </pre>
 * 
 * @author Thorsten Kamann
 */
@Configurable
public class MessierObject extends FixedSkyObject implements
		IMessierObject {

	/**
	 * Protected constructor. Use {@link CatalogueFactory} to create new
	 * instances of this class.
	 * 
	 * @param name
	 * @param description
	 * @param position
	 * @param type
	 * @param constellation
	 * @param magnitude
	 */
	protected MessierObject(String name, String description,
			IPosition position, ISkyObjectType type,
			IConstellation constellation, double magnitude) {
		super(name, description, position, type, constellation, magnitude);
	}

}
