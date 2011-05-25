/**
 * 
 */
package de.planetes.catalogue;

/**
 * Simple interface to provide the identifier feature to a catalogue object.
 * With this identifier you can set {@link Long} values to an instance to get an unique
 * identifier. This is commonly used by a persitence layer.
 * 
 * @author Thorsten Kamann
 */
public interface IdentifiedCatalogueObject {
	
	/**
	 * @return the current identifier or <code>null</code> if no identifer is set
	 */
	Long getIdentifier();
	
	
	/**
	 * @param identifier The identifier to set. If you set this manually think about uniqueness.
	 */
	void setIdentifier(Long identifier);
	
	

}
