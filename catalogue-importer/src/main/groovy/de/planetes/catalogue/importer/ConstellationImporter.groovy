/**
 * 
 */
package de.planetes.catalogue.importer

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transaction;

import org.aspectj.apache.bcel.Repository;
import org.springframework.transaction.annotation.Transactional;

import de.planetes.catalogue.db.repository.IConstellationRepository
import de.planetes.catalogue.ri.CatalogueFactory;

/**
 * @author kamann
 *
 */
@Named
@Transactional
class ConstellationImporter implements IImporter{
	
	final List constellations = [
		CatalogueFactory.createConstellation("Andromeda", "Andromeda", "AND", []),
		CatalogueFactory.createConstellation("Antilla", "Pump", "ANT", [])
	]
	
	@Inject
	private IConstellationRepository repository
	
	public void importIntoDB(){
		constellations.each{constellation ->
				repository.persistOrMergeConstellation constellation
		}
	} 

}
