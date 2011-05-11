/**
 * 
 */
package de.planetes.catalogue.ri;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Configurable;

import de.planetes.catalogue.IConstellation;
import de.planetes.catalogue.IFixedSkyObject;

/**
 * @author Thorsten Kamann
 * 
 */
@Configurable
public class Constellation extends AbstractValidatedCatalogue implements
		IConstellation {
	private String name;
	private String description;
	private String code;
	private List<IFixedSkyObject> skyObjects = new ArrayList<IFixedSkyObject>();

	/**
	 * @param name
	 * @param description
	 * @param code
	 * @param skyObjects
	 */
	protected Constellation(String name, String description, String code,
			List<IFixedSkyObject> skyObjects) {
		this.name = name;
		this.description = description;
		this.code = code;
		this.skyObjects = skyObjects;
	}

	/* (non-Javadoc)
	 * @see de.planetes.catalogue.IConstellation#getName()
	 */
	public String getName() {
		return name;
	}

	/* (non-Javadoc)
	 * @see de.planetes.catalogue.IConstellation#getDescription()
	 */
	public String getDescription() {
		return description;
	}

	/* (non-Javadoc)
	 * @see de.planetes.catalogue.IConstellation#getCode()
	 */
	public String getCode() {
		return code;
	}

	/* (non-Javadoc)
	 * @see de.planetes.catalogue.IConstellation#getSkyObjects()
	 */
	public List<IFixedSkyObject> getSkyObjects() {
		return skyObjects;
	}


}
