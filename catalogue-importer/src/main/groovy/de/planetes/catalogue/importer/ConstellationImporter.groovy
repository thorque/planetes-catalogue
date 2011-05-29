/**
 * 
 */
package de.planetes.catalogue.importer

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transaction;

import org.aspectj.apache.bcel.Repository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import de.planetes.catalogue.db.repository.IConstellationRepository
import de.planetes.catalogue.ri.CatalogueFactory;

/**
 * @author kamann
 *
 */
@Component
@Transactional
class ConstellationImporter implements IImporter{
	
	@Inject
	private IConstellationRepository repository

	public int importIntoDB(){
		File dataFile = new File("src/main/resources/importdata/constellations.csv");
		int recordCounter = 0
		dataFile.eachLine { String line ->
			List items = line.split(";")
			repository.persistOrMergeConstellation(CatalogueFactory.createConstellation(items.get(0), items.get(1)))
			recordCounter++
		}
		return recordCounter;
	} 

}
