package de.planetes.catalogue;

import javax.validation.constraints.NotNull;

/**
 * This interface describes the position of an skyobject.
 * This interface is readonly so you get only getter-methods.
 *
 * @author Thorsten Kamann
 *
 */
public interface IPosition {

    /**
     *
     * @return the right ascension (hours, minutes, seconds)
     * @see IRightAscension
     */
    @NotNull
    public IRightAscension getRightAscension();

    /**
     *
     * @return The declination (degree, minutes and seconds) of a skyobject
     * @see IDeclination
     */
    @NotNull
    public IDeclination getDeclination();

}
