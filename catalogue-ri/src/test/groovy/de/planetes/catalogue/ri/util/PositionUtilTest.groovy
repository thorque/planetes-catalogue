/**
 * 
 */
package de.planetes.catalogue.ri.util;

import static org.junit.Assert.*

import org.junit.Assert
import org.junit.Test

import de.planetes.catalogue.IRightAscension
import de.planetes.catalogue.ri.CatalogueFactory

/**
 * @author kamann
 *
 */
class PositionUtilTest {
	
	@Test
	final void "test computing the decimal value of a right ascension"(){
		IRightAscension ra = CatalogueFactory.createRightAscension(4, 30, 45d)
		
		Assert.assertEquals 60.5125d, new PositionUtil().toDecimalDegrees(ra), 0
	}
	
	@Test
	final void "test computing a right ascension object from a given decimal representation"(){
		IRightAscension ra = CatalogueFactory.createRightAscension(4, 30, 45d)
		Assert.assertEquals "4h 30' 45.0\"", new PositionUtil().fromDecimalDegrees(60.5125d).toString()
	}

}
