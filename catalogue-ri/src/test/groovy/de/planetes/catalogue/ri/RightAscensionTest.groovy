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

import de.planetes.catalogue.IRightAscension
import de.planetes.catalogue.ri.exception.CatalogueValidationException

/**
 * @author kamann
 *
 */
@RunWith(SpringJUnit4ClassRunner)
@ContextConfiguration("/de/planetes/catalogue/ri/RITest-context.xml")
class RightAscensionTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	@Test(expected=CatalogueValidationException)
	final void "test factory method with wrong data"(){
		IRightAscension ra = CatalogueFactory.createRightAscension(12, 22, 66)
	}

	@Test
	final void "test factory method with correct data"(){
		IRightAscension ra = CatalogueFactory.createRightAscension(12, 22, 11.5d)
		Assert.assertEquals 12, ra.hours
		Assert.assertEquals 22, ra.minutes
		Assert.assertEquals 11.5d, ra.seconds, 0
	}
}
