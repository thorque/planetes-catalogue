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
class ISkyObjectTypeTest {
	private ISkyObjectType type
	private String name
	private String code

	@Autowired
	Validator validator

	@Before
	public void setUp() throws Exception {
		name = "name"
		code="abc"
		type = [getName: {name}, getCode: {code}] as ISkyObjectType
	}

	@Test
	final void "test validator works fine with name set to null"(){
		name = null

		def violations = validator.validate(type)
		Assert.assertEquals 1, violations.size()
		violations.each {
			Assert.assertEquals "{javax.validation.constraints.NotNull.message}", it.messageTemplate
		}
	}

	@Test
	final void "test validator works fine with code set to null"(){
		code = null

		def violations = validator.validate(type)
		Assert.assertEquals 1, violations.size()
		violations.each {
			Assert.assertEquals "{javax.validation.constraints.NotNull.message}", it.messageTemplate
		}
	}

	@Test
	final void "test validator works fine with code set to value with more than 3 chars"(){
		code = "abcd"

		def violations = validator.validate(type)
		Assert.assertEquals 1, violations.size()
		violations.each {
			Assert.assertEquals "{javax.validation.constraints.Size.message}", it.messageTemplate
		}
	}
}
