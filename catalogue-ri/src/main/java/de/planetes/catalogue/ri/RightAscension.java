/**
 * 
 */
package de.planetes.catalogue.ri;

import org.springframework.beans.factory.annotation.Configurable;

import de.planetes.catalogue.IRightAscension;

/**
 * @author kamann
 *
 */
@Configurable
public class RightAscension extends AbstractValidatedCatalogue implements IRightAscension {
	private int hours;
	private int minutes;
	private double seconds;

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
