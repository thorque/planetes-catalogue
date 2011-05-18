/**
 * 
 */
package de.planetes.catalogue.ri.service.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import de.planetes.catalogue.IMessierObject;

/**
 * @author kamann
 *
 */
@Repository
public class SkyObjectRepository {

	public List<IMessierObject> findAllMessierObjects() {
		List<IMessierObject> messierObjects = new ArrayList<IMessierObject>();
		String query = "FROM messierobject mo";

		return messierObjects;
	}

}
