/**
 * 
 */
package de.planetes.catalogue.ri;

import de.planetes.catalogue.IConstellation;
import de.planetes.catalogue.IFixedSkyObject;
import de.planetes.catalogue.IPosition;
import de.planetes.catalogue.ISkyObjectType;

/**
 * @author Thorsten Kamann
 * 
 */
public class FixedSkyObject extends SkyObject implements
		IFixedSkyObject {
	private IConstellation constellation;
	private double magnitude;

	/**
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
