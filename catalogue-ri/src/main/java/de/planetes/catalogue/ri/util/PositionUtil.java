/**
 * 
 */
package de.planetes.catalogue.ri.util;

import java.text.NumberFormat;

import de.planetes.catalogue.IRightAscension;
import de.planetes.catalogue.ri.CatalogueFactory;

/**
 * @author kamann
 *
 */
public class PositionUtil {

	/**
	 * Computes the data of  this {@link IRightAscension} to a decimal representation:
	 * <br/>
	 * 4h 30' 0'' to 60,5°
	 * @return The decimal value of this {@link IRightAscension} 
	 */
	public double toDecimalDegrees(IRightAscension rightAscension) {
		double degrees = (rightAscension.getSeconds()/ 60 + rightAscension.getMinutes()) / 60 + (rightAscension.getHours() * 15);
		return degrees;
	}

	/**
	 * Computes a new {@link IRightAscension} from a decimal represenation
	 * @param decimalDegrees
	 * @return A new {@link IRightAscension} object
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
		return CatalogueFactory.createRightAscension((int) (h / 15), m, s);
	}
}
