package de.planetes.catalogue;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * This interface describes a constellation a {@link IFixedSkyObject} belongs
 * to.
 * 
 * @author Thorsten Kamann
 */

public interface IConstellation {

	/**
	 * 
	 * @return The name of the constellation
	 */
	@NotNull
	public String getName();

	/**
	 * 
	 * @return The (optional) description of this constellation
	 */
	public String getDescription();

	/**
	 * 
	 * @return The 3-char code of this constellation, eg. UMa for Ursa Major
	 */
	@NotNull
	@Size(min = 3, max = 3)
	public String getCode();

	/**
	 * 
	 * @return A {@link List} of {@link IFixedSkyObject} belonging to this
	 *         constellation
	 */
	@NotNull
	public List<IFixedSkyObject> getSkyObjects();
}
