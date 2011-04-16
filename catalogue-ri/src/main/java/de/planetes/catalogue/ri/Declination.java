package de.planetes.catalogue.ri;

import de.planetes.catalogue.IDeclination;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 */
public class Declination implements IDeclination {
    private int degree;
    private int minutes;
    private double seconds;

    private Declination() {
    }

    public static Declination createDeclination(int degree, int minutes, double seconds) {
        Declination d = new Declination();
        d.degree = degree;
        d.minutes = minutes;
        d.seconds = seconds;
        return d;
    }

    /**
     * @return The degrees from -90 - 90.
     */
    public int getDegree() {
        return degree;
    }

    /**
     * @return the minutes in the range from 0 - 59
     */
    public int getMinutes() {
        return minutes;
    }

    /**
     * @return seconds in the range from 0-59. Seconds are decimal.
     */
    public double getSeconds() {
        return seconds;
    }

    @Override
    public String toString() {
        return degree + "° " + minutes + "' " + seconds + "\"";
    }
}
