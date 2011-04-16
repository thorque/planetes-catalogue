package de.planetes.catalogue;

/**
 * Created by IntelliJ IDEA.
 * User: kamann
 * Date: 15.04.11
 * Time: 10:12
 * To change this template use File | Settings | File Templates.
 */
public interface FixedSkyObject extends SkyObject {

    public Constellation getConstellation();

    public double getMagnitude();

}
