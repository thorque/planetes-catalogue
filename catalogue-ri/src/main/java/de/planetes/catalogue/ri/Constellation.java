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
 * Implementation of the {@link IConstellation} interface. A Constellation
 * contains all {@link IFixedSkyObject}s. At now no informations about the
 * bounds will be provided.
 * 
 * A newly created instance is validated (JSR-303).
 * 
 * To create a new instance use following snippet:
 * 
 * <pre>
 * 		<code>IConstellation constellation = CatalogueFactory.createConstellation(String, String, String,  List<IFixedSkyObject>)<code>
 * 		<br>or<br>
 * 		<code>IConstellation constellation = CatalogueFactory.createConstellation(String, String, String,  IFixedSkyObject...)</code>
 * </pre>
 * 
 * @author Thorsten Kamann
 */
@Configurable
public class Constellation extends AbstractValidatedCatalogue implements
		IConstellation {
	private String name;
	private String description;
	private String code;
	private List<IFixedSkyObject> skyObjects = new ArrayList<IFixedSkyObject>();

	/**
	 * Constructor for internal use only. Please use {@link CatalogueFactory} to
	 * create a new instance of this class.
	 * 
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
