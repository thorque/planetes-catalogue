/**
 * 
 */
package de.planetes.catalogue.ri;

import org.springframework.beans.factory.annotation.Configurable;

import de.planetes.catalogue.IConstellation;
import de.planetes.catalogue.IMessierObject;
import de.planetes.catalogue.IPosition;
import de.planetes.catalogue.ISkyObjectType;

/**
 * @author Thorsten Kamann
 */
@Configurable
public class MessierObject extends FixedSkyObject implements
		IMessierObject {

	/**
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
