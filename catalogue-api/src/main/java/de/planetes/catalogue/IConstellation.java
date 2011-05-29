package de.planetes.catalogue;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * This interface describes a constellation a {@link IFixedSkyObject} belongs
 * to.
 * 
 * @author Thorsten Kamann
 */

public interface IConstellation extends IdentifiedCatalogueObject {

	/**
	 * 
	 * @return The name of the constellation
	 */
	@NotNull
	String getName();

	/**
	 * 
	 * @return The 3-char code of this constellation, eg. UMa for Ursa Major
	 */
	@NotNull
	@Size(min = 3, max = 3)
	String getCode();
}
