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

import de.planetes.catalogue.IConstellation
import de.planetes.catalogue.IFixedSkyObject
import de.planetes.catalogue.ri.exception.CatalogueValidationException

/**
 * @author Thorsten Kamann
 */
@RunWith(SpringJUnit4ClassRunner)
@ContextConfiguration("/de/planetes/catalogue/ri/RITest-context.xml")
class ConstellationTest {

	@Test(expected=CatalogueValidationException)
	final void "test creation of a Constellation instance with invalid data"(){
		CatalogueFactory.createConstellation(null, null, null, null)
	}

	@Test
	final void "test creation of a Constellation instance with valid data"(){
		List<IFixedSkyObject> skyObjects = []
		IConstellation c = CatalogueFactory.createConstellation("name", "description", "cd1", skyObjects)

		Assert.assertEquals "name", c.name
		Assert.assertEquals "description", c.description
		Assert.assertEquals "cd1", c.code
		Assert.assertEquals skyObjects, c.skyObjects
	}
}
