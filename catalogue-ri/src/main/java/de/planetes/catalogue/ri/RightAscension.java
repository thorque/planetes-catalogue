/**
 * 
 */
package de.planetes.catalogue.ri;

import java.math.BigDecimal;
import java.text.NumberFormat;

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
public class RightAscension extends AbstractValidatedCatalogue implements
		IRightAscension {
	private static final long serialVersionUID = -7597602656202612738L;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.planetes.catalogue.IRightAscension#getHours()
	 */
	public int getHours() {
		return hours;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.planetes.catalogue.IRightAscension#getMinutes()
	 */
	public int getMinutes() {
		return minutes;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.planetes.catalogue.IRightAscension#getSeconds()
	 */
	public double getSeconds() {
		return seconds;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.planetes.catalogue.IRightAscension#toDecimal()
	 */
	public double toDecimalDegrees() {
		double degrees = (seconds / 60 + minutes) / 60 + (hours * 15);
		// double degrees = 15*(hours+(1/60)*minutes+(1/3600)*seconds);
		return degrees;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return hours + "h " + minutes + "' " + seconds + "\"";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.planetes.catalogue.IRightAscension#fromDecimal()
	 */
	public IRightAscension fromDecimalDegrees(double decimalDegrees) {
		int h = (int) decimalDegrees;
		double m1 = (decimalDegrees - h) * 60;
		int m = (int) m1;
		double s = (m1 - m) * 60;

		NumberFormat n = NumberFormat.getInstance();
		n.setMaximumFractionDigits(5);
		s = Double.valueOf(n.format(s));
		s = Math.round(s);
		System.out.println("" + h + " " + m + " " + s);
		return CatalogueFactory.createRightAscension((int) (h / 15), m, s);
	}

}
