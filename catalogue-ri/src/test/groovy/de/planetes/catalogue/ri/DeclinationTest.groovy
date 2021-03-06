/**
 * 
 */
package de.planetes.catalogue.ri;

import static org.junit.Assert.*

import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

import de.planetes.catalogue.IDeclination
import de.planetes.catalogue.ri.exception.CatalogueValidationException

/**
 * @author kamann
 *
 */
@RunWith(SpringJUnit4ClassRunner)
@ContextConfiguration("/de/planetes/catalogue/ri/RITest-context.xml")
class DeclinationTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	@Test(expected=CatalogueValidationException)
	final void "test creation of a new Declination instance with invalid data"(){
		CatalogueFactory.createDeclination(33, 22, 66)
	}

	@Test
	final void "test creation of a new Declination instance with valid data"(){
		IDeclination declination = CatalogueFactory.createDeclination(33, 22, 11.5d)
		Assert.assertEquals 33, declination.degree
		Assert.assertEquals 22, declination.minutes
		Assert.assertEquals 11.5d, declination.seconds, 0
	}
}
