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
import de.planetes.catalogue.IDeclination
import de.planetes.catalogue.IFixedSkyObject
import de.planetes.catalogue.IPosition
import de.planetes.catalogue.IRightAscension
import de.planetes.catalogue.ISkyObjectType
import de.planetes.catalogue.ri.exception.CatalogueValidationException

/**
 * @author Thorsten Kamann
 */
@RunWith(SpringJUnit4ClassRunner)
@ContextConfiguration("/de/planetes/catalogue/ri/RITest-context.xml")
class MessierObjectTest {

	@Test(expected=CatalogueValidationException)
	final void "test creation of a MessierObject instance with invalid data"(){
		CatalogueFactory.createMessierObject(null, null, null, null, null, 0)
	}

	@Test
	final void "test creation of a MessierObject instance with valid data"(){
		IRightAscension ra = CatalogueFactory.createRightAscension (11, 11, 11)
		IDeclination d = CatalogueFactory.createDeclination (22, 22, 22)
		IPosition p = CatalogueFactory.createPosition(ra, d)
		ISkyObjectType type = CatalogueFactory.createSkyObjectType("name", "cd1")
		IConstellation c = CatalogueFactory.createConstellation( "name", "description", "cd1", [])

		IFixedSkyObject mo = CatalogueFactory.createMessierObject("name", "description", p, type, c, 2.3d)
		Assert.assertEquals "name", mo.name
		Assert.assertEquals "description", mo.description
		Assert.assertEquals type, mo.type
		Assert.assertEquals p, mo.position
		Assert.assertEquals 2.3d, mo.magnitude,0
	}
}
