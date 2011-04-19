package de.planetes.catalogue;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

/**
 * This interface describes a fixed sky object. This means an object like a
 * star. Planets aren't a fix sky object.
 * 
 * @author Thorsten Kamann
 * @see ISkyObject
 */
public interface IFixedSkyObject extends ISkyObject {

	/**
	 * @return The constellation this object belongs to
	 */
	@NotNull
    public IConstellation getConstellation();

	/**
	 * 
	 * @return the magnitude of the object. This is the relative value, eg.
	 *         3.23m. The possible value range is from -5m upto 25m.
	 */
	@DecimalMin("-5")
	@DecimalMax("25")
	@Digits(integer = 2, fraction = 4)
	public double getMagnitude();

}
