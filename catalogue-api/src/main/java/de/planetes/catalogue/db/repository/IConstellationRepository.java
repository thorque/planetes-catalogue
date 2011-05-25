/**
 * 
 */
package de.planetes.catalogue.db.repository;

import java.util.List;

import de.planetes.catalogue.IConstellation;

/**
 * @author kamann
 *
 */
public interface IConstellationRepository {
	
	List<IConstellation> findAllConstellations();
	
	IConstellation findConstellationByName(String name);
	
	IConstellation findConstellationByCode(String code);
	
	IConstellation persistOrMergeConstellation(IConstellation constellation);

}
