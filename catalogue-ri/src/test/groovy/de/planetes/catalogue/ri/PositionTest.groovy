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
import de.planetes.catalogue.ri.exception.CatalogueValidationException

/**
 * @author kamann
 *
 */
@RunWith(SpringJUnit4ClassRunner)
@ContextConfiguration("/de/planetes/catalogue/ri/RITest-context.xml")
class PositionTest {

	@Test(expected=CatalogueValidationException)
	final void "test creation of a Position instance with invalid data"(){
		CatalogueFactory.createPosition(CatalogueFactory.createRightAscension (11, 11, 11), null)
	}

	@Test
	final void "test creation of a Positon instance with valid data"(){
		IRightAscension ra = CatalogueFactory.createRightAscension (11, 11, 11)
		IDeclination d = CatalogueFactory.createDeclination (22, 22, 22)
		IPosition p = CatalogueFactory.createPosition(ra, d)
		Assert.assertEquals ra, p.rightAscension
		Assert.assertEquals d, p.declination
	}
}
