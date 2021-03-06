/**
 * 
 */
package de.planetes.catalogue.ri;

import org.springframework.beans.factory.annotation.Configurable;

import de.planetes.catalogue.ISkyObjectType;

/**
 * RI of the interface {@link ISkyObjectType}. This class is describing the type
 * of a SkyObject, like planet, star, galaxy and so on.
 * 
 * You can create a new instance of this class like this:
 * 
 * <pre>
 * 		<code>ISkyObjectType type = CatalogueFactory.createSkyObjectType(String, String);</code>
 * </pre>
 * 
 * All instances are JSR-303 validated
 * 
 * @author Thorsten Kamann
 */
@Configurable
public class SkyObjectType extends AbstractValidatedCatalogue implements
		ISkyObjectType {
	private String name;
	private String code;

	/**
	 * Constructor for this class. It's protected because only the
	 * {@link CatalogueFactory} should create a new instance of this class. For
	 * the same reason no setter method existing.
	 * 
	 * @param name
	 * @param code
	 */
	protected SkyObjectType(String name, String code) {
		this.name = name;
		this.code = code;
	}

	/* (non-Javadoc)
	 * @see de.planetes.catalogue.ISkyObjectType#getName()
	 */
	public String getName() {
		return name;
	}

	/* (non-Javadoc)
	 * @see de.planetes.catalogue.ISkyObjectType#getCode()
	 */
	public String getCode() {
		return code;
	}

}
