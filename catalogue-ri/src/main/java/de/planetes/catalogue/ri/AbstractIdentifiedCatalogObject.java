/**
 * 
 */
package de.planetes.catalogue.ri;

import de.planetes.catalogue.IdentifiedCatalogueObject;

/**
 * @author kamann
 *
 */
public abstract class AbstractIdentifiedCatalogObject implements IdentifiedCatalogueObject {
	protected Long identifier;

	/**
	 * @return the identifier
	 */
	public Long getIdentifier() {
		return identifier;
	}

	/**
	 * @param id the id to set
	 */
	public void setIdentifier(Long identifier) {
		this.identifier = identifier;
	}
	
	

}
