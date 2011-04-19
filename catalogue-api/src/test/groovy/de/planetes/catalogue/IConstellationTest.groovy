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
class IConstellationTest {
	private IConstellation constellation
	private String name
	private String code
	private List<IFixedSkyObject> skyObjects

	@Autowired
	Validator validator

	@Before
	public void setUp() throws Exception {
		name = "name"
		code = "abc"
		skyObjects = []
		constellation = [getName: {name}, getCode: {code}, getSkyObjects: {skyObjects}] as IConstellation
	}

	@Test
	final void "test if the validator works fine with name set to null"(){
		name = null

		def violations = validator.validate(constellation)
		Assert.assertEquals 1, violations.size()
		violations.each {
			Assert.assertEquals "{javax.validation.constraints.NotNull.message}", it.messageTemplate
		}
	}

	@Test
	final void "test if the validator works fine with code set to null"(){
		code = null

		def violations = validator.validate(constellation)
		Assert.assertEquals 1, violations.size()
		violations.each {
			Assert.assertEquals "{javax.validation.constraints.NotNull.message}", it.messageTemplate
		}
	}

	@Test
	final void "test if the validator works fine with code size is greater than 3 chars"(){
		code = "abcd"

		def violations = validator.validate(constellation)
		Assert.assertEquals 1, violations.size()
		violations.each {
			Assert.assertEquals "{javax.validation.constraints.Size.message}", it.messageTemplate
		}
	}

	@Test
	final void "test if the validator works fine with code size is less than 3 chars"(){
		code = "ab"

		def violations = validator.validate(constellation)
		Assert.assertEquals 1, violations.size()
		violations.each {
			Assert.assertEquals "{javax.validation.constraints.Size.message}", it.messageTemplate
		}
	}

	@Test
	final void "test if the validator works fine with skyObjects set to null"(){
		skyObjects = null

		def violations = validator.validate(constellation)
		Assert.assertEquals 1, violations.size()
		violations.each {
			Assert.assertEquals "{javax.validation.constraints.NotNull.message}", it.messageTemplate
		}
	}
}
