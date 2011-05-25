/**
 * 
 */
package de.planetes.catalogue.service;

import java.util.List;

import de.planetes.catalogue.IConstellation;

/**
 * @author kamann
 *
 */
public interface IConstellationService {
	
	List<IConstellation> findAllConstellations();

}
