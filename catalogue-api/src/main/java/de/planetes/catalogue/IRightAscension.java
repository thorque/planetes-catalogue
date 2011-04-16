package de.planetes.catalogue;

import javax.validation.constraints.*;

/**
 * Right ascension is like the geographical longitude on earth. With this position you can determine the position of a
 * skyobject relative to the meridian.
 *
 * @author Thorsten Kamann
 */
public interface IRightAscension {

    /**
     * @return the hours from 0h - 23h
     */
    @Min(0)
    @Max(23)
    public int getHours();

    /**
     * @return the minutes in the range from 0 - 59
     */
    @Min(0)
    @Max(59)
    public int getMinutes();

    /**
     * @return seconds in the range from 0-59. Seconds are decimal.
     */
    @DecimalMin("0")
    @DecimalMax("59.9999")
    @Digits(integer = 2, fraction = 4)
    public double getSeconds();
}
