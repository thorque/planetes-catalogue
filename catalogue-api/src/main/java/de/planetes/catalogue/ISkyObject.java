package de.planetes.catalogue;

import javax.validation.constraints.NotNull;

/**
 */
public interface ISkyObject {

    public String getName();

    @NotNull
    public IPosition getPosition();

    @NotNull
    public ISkyObjectType getType();
}
