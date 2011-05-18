/**
 * 
 */
package de.planetes.catalogue.service;

import java.util.List;

import de.planetes.catalogue.IMessierObject;

/**
 * @author kamann
 *
 */
public interface ISkyObjectService {

	public List<IMessierObject> findAllMessierObjects();

}
