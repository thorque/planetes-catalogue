package de.planetes.catalogue.ri;

import javax.inject.Inject;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Configurable;

import de.planetes.catalogue.IDeclination;
import de.planetes.catalogue.ri.exception.WrongPositionDataException;
import de.planetes.catalogue.ri.validator.ValidatorHelper;

/**
 * Default implementation of the {@link IDeclination} interface. <br>
 * To create a new instance of this class use the provided factory:
 * 
 * <pre>
 * <code>
 * 		IDeclination declination = Declination.createDeclination(23, 22, 57);
 * 	</code>
 * </pre>
 * 
 * @author Thorsten Kamann
 */
@Configurable
public class Declination implements IDeclination {
    private int degree;
    private int minutes;
    private double seconds;

	@Inject
	private Validator validator;

    private Declination() {
    }

	/**
	 * @param degree
	 * @param minutes
	 * @param seconds
	 * @return A new instance of this class
	 */
	public static Declination createDeclination(int degree, int minutes,
			double seconds) throws WrongPositionDataException {

		Declination d = new Declination();
        d.degree = degree;
        d.minutes = minutes;
        d.seconds = seconds;

		ValidatorHelper helper = new ValidatorHelper();
		helper.setValidator(d.validator);
		helper.doValidate(d);
		if (!helper.hasViolations()) {
			throw new WrongPositionDataException(helper.toString());
		}
        return d;
    }

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.planetes.catalogue.IDeclination#getDegree()
	 */
    public int getDegree() {
        return degree;
    }

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.planetes.catalogue.IDeclination#getMinutes()
	 */
    public int getMinutes() {
        return minutes;
    }

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.planetes.catalogue.IDeclination#getSeconds()
	 */
    public double getSeconds() {
        return seconds;
    }

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
    @Override
    public String toString() {
		return degree + "¡ " + minutes + "' " + seconds + "\"";
    }
}
