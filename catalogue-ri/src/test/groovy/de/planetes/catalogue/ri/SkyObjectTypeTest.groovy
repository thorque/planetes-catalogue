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

import de.planetes.catalogue.ISkyObjectType
import de.planetes.catalogue.ri.exception.CatalogueValidationException

/**
 * @author Thorsten Kamann
 */
@RunWith(SpringJUnit4ClassRunner)
@ContextConfiguration("/de/planetes/catalogue/ri/RITest-context.xml")
class SkyObjectTypeTest {

	@Test(expected=CatalogueValidationException)
	final void "test creation of a SkyObject instance with invalid data"(){
		CatalogueFactory.createSkyObjectType(null, null)
	}

	@Test
	final void "test creation of a SkyObject instance with valid data"(){

		ISkyObjectType t = CatalogueFactory.createSkyObjectType("name", "cd1")
		Assert.assertEquals "name", t.name
		Assert.assertEquals "cd1", t.code
	}
}
