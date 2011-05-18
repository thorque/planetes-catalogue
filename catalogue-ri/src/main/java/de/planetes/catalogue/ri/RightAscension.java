/**
 * 
 */
package de.planetes.catalogue.ri;

import org.springframework.beans.factory.annotation.Configurable;

import de.planetes.catalogue.IRightAscension;

/**
 * Implementastion of the {@link IRightAscension} interface. A newly created
 * instance is JSR-303 validated. You can create a new instance like this
 * snippet:
 * 
 * <pre>
 * 		<code>IRightAscension ra = {@link CatalogueFactory}.createRightAscension(int, int, double);</code>
 * </pre>
 * 
 * @author Thorsten Kamann
 */
@Configurable
public class RightAscension extends AbstractValidatedCatalogue implements IRightAscension {
	private int hours;
	private int minutes;
	private double seconds;

	/**
	 * Protected constructor. Use {@link CatalogueFactory} to create a new
	 * instance of this class.
	 * 
	 * @param hours
	 * @param minutes
	 * @param seconds
	 */
	protected RightAscension(int hours, int minutes, double seconds) {
		this.hours = hours;
		this.minutes = minutes;
		this.seconds = seconds;
	}

	/* (non-Javadoc)
	 * @see de.planetes.catalogue.IRightAscension#getHours()
	 */
	public int getHours() {
		return hours;
	}

	/* (non-Javadoc)
	 * @see de.planetes.catalogue.IRightAscension#getMinutes()
	 */
	public int getMinutes() {
		return minutes;
	}

	/* (non-Javadoc)
	 * @see de.planetes.catalogue.IRightAscension#getSeconds()
	 */
	public double getSeconds() {
		return seconds;
	}

}
