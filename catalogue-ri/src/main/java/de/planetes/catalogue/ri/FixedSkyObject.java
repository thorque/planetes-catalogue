/**
 * 
 */
package de.planetes.catalogue.ri;

import de.planetes.catalogue.IConstellation;
import de.planetes.catalogue.IFixedSkyObject;
import de.planetes.catalogue.IPosition;
import de.planetes.catalogue.ISkyObjectType;

/**
 * Implementation of the {@link IFixedSkyObject} interface. Newly created
 * instances will be validated (JSR-303). To create a new instance you can use
 * this snippet:
 * 
 * <pre>
 * 		<code>IFixedSkyObject skyObject = CatalogueFactory.createFixedSkyObject(String, String, IPosition, ISkyObjectType, IConstellation, double);</code>
 * </pre>
 * 
 * @author Thorsten Kamann
 * 
 */
public class FixedSkyObject extends SkyObject implements
		IFixedSkyObject {
	private IConstellation constellation;
	private double magnitude;

	/**
	 * Protected constructor. Please use the {@link CatalogueFactory} instead.
	 * 
	 * @param name
	 * @param description
	 * @param position
	 * @param type
	 * @param constellation
	 * @param magnitude
	 */
	protected FixedSkyObject(String name, String description,
			IPosition position, ISkyObjectType type,
			IConstellation constellation, double magnitude) {
		super(name, description, position, type);
		this.constellation = constellation;
		this.magnitude = magnitude;
	}

	/* (non-Javadoc)
	 * @see de.planetes.catalogue.IFixedSkyObject#getConstellation()
	 */
	public IConstellation getConstellation() {
		return constellation;
	}

	/* (non-Javadoc)
	 * @see de.planetes.catalogue.IFixedSkyObject#getMagnitude()
	 */
	public double getMagnitude() {
		return magnitude;
	}

}
