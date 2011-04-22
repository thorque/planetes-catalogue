/**
 * 
 */
package de.planetes.catalogue.ri.validator;

import static org.junit.Assert.*

import javax.validation.Validator
import javax.validation.constraints.NotNull

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

/**
 * 
 * @author kamann
 *
 */
@RunWith(SpringJUnit4ClassRunner)
@ContextConfiguration
class ValidatorHelperTest {
	private ValidatorHelper helper

	@Autowired
	Validator validator

	@Test
	final void "test if the ValidatorHelper returns the correct error message"(){
		helper = new ValidatorHelper(validator: validator)
		helper.doValidate (new ValidatorDummy())

		Assert.assertTrue helper.toString().contains("There are violations [${helper.ls}")
		Assert.assertTrue helper.toString().contains("de.planetes.catalogue.ri.validator.ValidatorDummy.m1")
		Assert.assertTrue helper.toString().contains("de.planetes.catalogue.ri.validator.ValidatorDummy.m2")
		Assert.assertTrue helper.toString().contains("${helper.ls}]")
	}
}

/**
 * Dummy class to fire a validator with more than 1 violation.
 * 
 * @author Thorsten Kamann
 */
public class ValidatorDummy{

	@NotNull
	String getM1(){
		null
	}

	@NotNull
	String getM2(){
		null
	}
}
