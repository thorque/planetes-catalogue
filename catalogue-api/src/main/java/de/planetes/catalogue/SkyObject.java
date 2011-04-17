package de.planetes.catalogue;

import javax.validation.constraints.NotNull;

/**
 * Created by IntelliJ IDEA.
 * User: kamann
 * Date: 15.04.11
 * Time: 10:08
 * To change this template use File | Settings | File Templates.
 */
public interface SkyObject {

    public String getName();

    @NotNull
    public IPosition getPosition();

    public SkyObjectType getType();
}
