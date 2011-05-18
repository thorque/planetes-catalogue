/**
 * 
 */
package de.planetes.catalogue.ri.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import de.planetes.catalogue.IMessierObject;
import de.planetes.catalogue.ri.service.repository.SkyObjectRepository;
import de.planetes.catalogue.service.ISkyObjectService;

/**
 * @author kamann
 *
 */
@Service
public class SkyObjectService implements ISkyObjectService {

	@Inject
	private SkyObjectRepository skyObjectRepository;

	/* (non-Javadoc)
	 * @see de.planetes.catalogue.service.ISkyObjectService#findAllMessierObjects()
	 */
	public List<IMessierObject> findAllMessierObjects() {
		List<IMessierObject> messierObjects;

		messierObjects = skyObjectRepository.findAllMessierObjects();
		return messierObjects;
	}
}
