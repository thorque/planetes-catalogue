/**
 * 
 */
package de.planetes.catalogue.ri;

import static org.junit.Assert.*

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

import de.planetes.catalogue.IDeclination

/**
 * @author kamann
 *
 */
@RunWith(SpringJUnit4ClassRunner)
@ContextConfiguration
class DeclinationTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	@Test
	final void "test factory method with wrong data"(){
		IDeclination declination = Declination.createDeclination(33, 22, 66)
	}
}
