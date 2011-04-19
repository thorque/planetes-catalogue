package de.planetes.catalogue

import javax.validation.Validator

import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

/**
 * @author Thorsten Kamann
 */
@RunWith(SpringJUnit4ClassRunner)
@ContextConfiguration("/META-INF/spring/Validator-context.xml")
public class IRightAscensionTest{
	IRightAscension ra
	int hours
	int minutes
	double seconds

	@Autowired
	private Validator validator

	@Before
	void setup() {
		hours = 0
		minutes = 0
		seconds = 0d
		ra = [getHours: {hours}, getMinutes: {minutes}, getSeconds: {seconds}] as IRightAscension
	}

	@Test
	final void "test if the validator works fine if all is set correctly"() {
		Assert.assertEquals 0, validator.validate(ra).size()
	}

	@Test
	final void "test validator works fine for hours greater than 23"(){
		hours = 24
		checkViolations "{javax.validation.constraints.Max.message}"
	}

	@Test
	final void "test validator works fine for hours less than 0"(){
		hours = -1
		checkViolations "{javax.validation.constraints.Min.message}"
	}

	@Test
	final void "test validator works fine for minutes greater than 59"(){
		minutes = 60
		checkViolations "{javax.validation.constraints.Max.message}"
	}

	@Test
	final void "test validator works fine for minutes less than 0"(){
		minutes = -1
		checkViolations "{javax.validation.constraints.Min.message}"
	}

	@Test
	final void "test if the validator works fine for seconds greater 60"(){
		seconds = 60
		checkViolations "{javax.validation.constraints.DecimalMax.message}"
	}

	@Test
	final void "test if the validator works fine for seconds less than 0"(){
		seconds = -1
		checkViolations "{javax.validation.constraints.DecimalMin.message}"
	}

	@Test
	final void "test if the validator works fine for too much fraction for seconds" (){
		seconds = 2.34567d
		checkViolations "{javax.validation.constraints.Digits.message}"
	}


	private void checkViolations(String messageTemplate) {
		def violations = validator.validate(ra)
		Assert.assertEquals "Expecting one violation", 1, violations.size()

		violations.each {
			Assert.assertEquals messageTemplate, it.messageTemplate
		}
	}
}