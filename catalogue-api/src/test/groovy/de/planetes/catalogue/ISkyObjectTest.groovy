/**
 * 
 */
package de.planetes.catalogue;

import static org.junit.Assert.*

import javax.validation.Validator

import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

/**
 * @author kamann
 *
 */
@RunWith(SpringJUnit4ClassRunner)
@ContextConfiguration("/META-INF/spring/Validator-context.xml")
class ISkyObjectTest {
	private ISkyObject skyObject
	private IPosition position
	private ISkyObjectType type
	
	@Autowired
	Validator validator

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		position = [] as IPosition
		type = [] as ISkyObjectType
		skyObject = [getPosition: {position}, getType: {type}] as ISkyObject
	}
	
	@Test
	final void "test validator works fine with position set to null"(){
		position = null
		
		def violations = validator.validate(skyObject)
		Assert.assertEquals 1, violations.size()
		violations.each {
			Assert.assertEquals "{javax.validation.constraints.NotNull.message}", it.messageTemplate
		}
	}
	
	@Test
	final void "test validator works fine with skyovjectype set to null"(){
		type = null
		
		def violations = validator.validate(skyObject)
		Assert.assertEquals 1, violations.size()
		violations.each {
			Assert.assertEquals "{javax.validation.constraints.NotNull.message}", it.messageTemplate
		}
	}

}
