package de.planetes.catalogue.importer;

import static org.junit.Assert.*;

import org.junit.Test;

import de.planetes.catalogue.IConstellation;
import de.planetes.catalogue.db.repository.IConstellationRepository;

class ConstellationImporterTest {
	
	@Test
	final void "test the import into the db"(){
		IConstellationRepository repository = [persistOrMergeConstellation:{def object -> assertImportedData(object)}] as IConstellationRepository
		ConstellationImporter ci = new ConstellationImporter(repository: repository)

		assertEquals 88, ci.importIntoDB();
	}
	
	private void assertImportedData(IConstellation constellation){
		assertNotNull constellation.code
		assertNotNull constellation.name
	}
}
