/**
 * 
 */
package de.planetes.catalogue.ri;

import org.springframework.beans.factory.annotation.Configurable;

import de.planetes.catalogue.IDeclination;
import de.planetes.catalogue.IPosition;
import de.planetes.catalogue.IRightAscension;

/**
 * Implementation of the {@link IPosition} interface. Newly created instances
 * are JSR-303 validated. You can create a new instance with the
 * {@link CatalogueFactory}:
 * 
 * <pre>
 * 		<code>Iposition position = CatalogueFactory.createPosition(IRightAscension, IDeclination);</code>
 * </pre>
 * 
 * @author Thorsten Kamann
 * 
 */
@Configurable
public class Position extends AbstractValidatedCatalogue implements IPosition {
	private IRightAscension rightAscension;
	private IDeclination declination;

	/**
	 * Protected constructor. Use {@link CatalogueFactory} to create a new
	 * instance.
	 * 
	 * @param rightAscension
	 * @param declination
	 */
	protected Position(IRightAscension rightAscension, IDeclination declination) {
		this.rightAscension = rightAscension;
		this.declination = declination;
	}

	/* (non-Javadoc)
	 * @see de.planetes.catalogue.IPosition#getRightAscension()
	 */
	public IRightAscension getRightAscension() {
		return rightAscension;
	}

	/**
	 * @param rightAscension
	 *            the rightAscension to set
	 */
	public void setRightAscension(IRightAscension rightAscension) {
		this.rightAscension = rightAscension;
	}

	/**
	 * @param declination
	 *            the declination to set
	 */
	public void setDeclination(IDeclination declination) {
		this.declination = declination;
	}

	/* (non-Javadoc)
	 * @see de.planetes.catalogue.IPosition#getDeclination()
	 */
	public IDeclination getDeclination() {
		return declination;
	}

}
