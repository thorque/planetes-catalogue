/**
 * 
 */
package de.planetes.catalogue.ri;

import static org.junit.Assert.*

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

import de.planetes.catalogue.IDeclination
import de.planetes.catalogue.IPosition
import de.planetes.catalogue.IRightAscension
import de.planetes.catalogue.ISkyObject
import de.planetes.catalogue.ISkyObjectType
import de.planetes.catalogue.ri.exception.CatalogueValidationException

/**
 * @author Thorsten Kamann
 */
@RunWith(SpringJUnit4ClassRunner)
@ContextConfiguration("/de/planetes/catalogue/ri/RITest-context.xml")
class SkyObjectTest {

	@Test(expected=CatalogueValidationException)
	final void "test creation of a SkyObject instance with invalid data"(){
		CatalogueFactory.createSkyObject(null, null, null, null)
	}

	@Test
	final void "test creation of a SkyObject instance with valid data"(){
		IRightAscension ra = CatalogueFactory.createRightAscension (11, 11, 11)
		IDeclination d = CatalogueFactory.createDeclination (22, 22, 22)
		IPosition p = CatalogueFactory.createPosition(ra, d)
		ISkyObjectType type = CatalogueFactory.createSkyObjectType("name", "cd1")
		ISkyObject s = CatalogueFactory.createSkyObject("name", "description", p, type)
		Assert.assertEquals "name", s.name
		Assert.assertEquals "description", s.description
		Assert.assertEquals p, s.position
		Assert.assertEquals type, s.type
	}
}
