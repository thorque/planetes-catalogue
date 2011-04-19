package de.planetes.catalogue;

import javax.validation.constraints.NotNull;

/**
 * This interface describes a SkyObject like Stars, DeepSky-Objects, Planets,...
 * There are othe interface for specializing this
 * 
 * @author Thorsten Kamann
 * @see IFixedSkyObject
 * @see IMessierObject
 */
public interface ISkyObject {

	/**
	 * 
	 * @return The name of the sky object
	 */
    public String getName();

	/**
	 * @return The (optional) description of this {@link IFixedSkyObject}
	 */
	public String getDescription();

	/**
	 * 
	 * @return The position of the sky object
	 * @see IPosition
	 * @see IDeclination
	 * @see IRightAscension
	 */
    @NotNull
    public IPosition getPosition();

	/**
	 * 
	 * @return The type of this skyobject (eg. Planet, Nebula, Galaxy,...)
	 */
    @NotNull
    public ISkyObjectType getType();
}
