/**
 * 
 */
package de.planetes.catalogue.ri.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import de.planetes.catalogue.IConstellation;
import de.planetes.catalogue.IMessierObject;
import de.planetes.catalogue.db.repository.IConstellationRepository;
import de.planetes.catalogue.service.ISkyObjectService;

/**
 * @author kamann
 *
 */
@Service
public class SkyObjectService implements ISkyObjectService {

	@Inject
	private IConstellationRepository constellationRepository;

	/* (non-Javadoc)
	 * @see de.planetes.catalogue.service.ISkyObjectService#findAllMessierObjects()
	 */
	public List<IMessierObject> findAllMessierObjects() {
		
		return null;
	}

	/* (non-Javadoc)
	 * @see de.planetes.catalogue.service.ISkyObjectService#findAllConstellations()
	 */
	public List<IConstellation> findAllConstellations() {
		List<IConstellation> constellations = constellationRepository.findAllConstellations();
		return constellations;
	}
	
	
}
