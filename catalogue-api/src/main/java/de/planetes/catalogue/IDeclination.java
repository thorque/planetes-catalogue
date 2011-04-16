package de.planetes.catalogue;

import javax.validation.constraints.*;

/**
 * The declination is like the geographical latitude on earth.
 * With this you can determine the position over the horizon.
 *
 * @author Thorsten Kamann
 */
public interface IDeclination {


    /**
     * @return The degrees in the range from -90 - 90.
     */
    @Min(-89)
    @Max(89)
    public int getDegree();


    /**
     * @return the minutes in the range from 0 - 59
     */
    @Min(value = 0)
    @Max(value = 59)
    public int getMinutes();

    /**
     * @return seconds in the range from 0-59. Seconds are decimal.
     */
    @DecimalMin("0")
    @DecimalMax("59.9999")
    @Digits(integer = 2, fraction = 4)
    public double getSeconds();
}
