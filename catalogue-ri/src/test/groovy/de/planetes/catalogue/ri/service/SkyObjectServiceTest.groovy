package de.planetes.catalogue.ri.service;

import static org.junit.Assert.*

import org.junit.Assert
import org.junit.Before
import org.junit.Test

import de.planetes.catalogue.IConstellation
import de.planetes.catalogue.IDeclination
import de.planetes.catalogue.IPosition
import de.planetes.catalogue.IRightAscension
import de.planetes.catalogue.ISkyObjectType
import de.planetes.catalogue.ri.CatalogueFactory
import de.planetes.catalogue.ri.MessierObject

/**
 * @author kamann
 *
 */
class SkyObjectServiceTest {
	def messierObjects = []

	@Before
	void setup(){
		IRightAscension ra = CatalogueFactory.createRightAscension (11, 11, 11)
		IDeclination d = CatalogueFactory.createDeclination (22, 22, 22)
		IPosition p = CatalogueFactory.createPosition(ra, d)
		ISkyObjectType type = CatalogueFactory.createSkyObjectType("name", "cd1")
		IConstellation c = CatalogueFactory.createConstellation( "name", "description", "cd1", [])

		10.times{
			messierObjects << new MessierObject("M$it", "Messier Object M$it",p, type, c, 2.3d)
		}
	}

//	@Test
//	final void "test if the service can returns all messier objects"(){
//		SkyObjectRepository repository = [findAllMessierObjects: {messierObjects}] as SkyObjectRepository
//		SkyObjectService service = new SkyObjectService(skyObjectRepository: repository)
//
//		Assert.assertEquals 10, service.findAllMessierObjects().size()
//	}
//
//	@Test
//	final void "test if the service returns an empty list if no messier objects was found"(){
//		SkyObjectRepository repository = [findAllMessierObjects: {[]}] as SkyObjectRepository
//		SkyObjectService service = new SkyObjectService(skyObjectRepository: repository)
//
//		Assert.assertEquals 0, service.findAllMessierObjects().size()
//	}
}
