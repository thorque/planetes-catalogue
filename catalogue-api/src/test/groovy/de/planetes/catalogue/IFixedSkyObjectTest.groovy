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


@RunWith(SpringJUnit4ClassRunner)
@ContextConfiguration("/META-INF/spring/Validator-context.xml")
class IFixedSkyObjectTest {
	private IFixedSkyObject obj
	private IConstellation constellation
	private double magnitude

	@Autowired
	Validator validator

	@Before
	public void setUp() throws Exception {
		constellation = []as IConstellation
		magnitude = 3d
		def type = []as ISkyObjectType
		def name = "name"
		def position = []as IPosition
		obj = [getConstellation: {constellation}, getMagnitude: {magnitude}, getName: {name}, getType: {type}, getPosition: {position}] as IFixedSkyObject
	}

	@Test
	final void "test validator works fine with constellation set to null"(){
		constellation = null

		def violations = validator.validate(obj)
		Assert.assertEquals 1, violations.size()
		violations.each {
			Assert.assertEquals "{javax.validation.constraints.NotNull.message}", it.messageTemplate
		}
	}

	@Test
	final void "test validator works fine with magnitude set to a to negative value"(){
		magnitude = -10d

		def violations = validator.validate(obj)
		Assert.assertEquals 1, violations.size()
		violations.each {
			Assert.assertEquals "{javax.validation.constraints.DecimalMin.message}", it.messageTemplate
		}
	}

	@Test
	final void "test validator works fine with magnitude set to a to positive value"(){
		magnitude = 26.1d

		def violations = validator.validate(obj)
		Assert.assertEquals 1, violations.size()
		violations.each {
			Assert.assertEquals "{javax.validation.constraints.DecimalMax.message}", it.messageTemplate
		}
	}
}
