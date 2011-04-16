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
 * This class provides some tests to verify the validator configuration.
 * To achieve this the Groovy metaobject abilities are used to create on the fly implementations.
 *
 * @author Thorsten Kamann
 */
@RunWith(SpringJUnit4ClassRunner)
@ContextConfiguration("/META-INF/spring/Validator-context.xml")
class IDeclinationTest {
    IDeclination declination
    int degrees
    int minutes
    double seconds

    @Autowired
    private Validator validator

    @Before
    void setup() {
        degrees = 0
        minutes = 0
        seconds = 0d
        declination = [getDegree: {degrees}, getMinutes: {minutes}, getSeconds: {seconds}] as IDeclination
    }

    @Test
    final void "test if the validator works fine if all is set correctly"() {
        Assert.assertEquals 0, validator.validate(declination).size()
    }

    @Test
    final void "test if the validator works fine for degrees"() {
        degrees = 91
        checkViolations("{javax.validation.constraints.Max.message}");
    }

    @Test
    final void "test if the validator works fine for negative degrees"() {
        degrees = -91
        checkViolations("{javax.validation.constraints.Min.message}")
    }

    @Test
    final void "test if the validator works fine for minutes greater 60"(){
        minutes = 61
        checkViolations "{javax.validation.constraints.Max.message}"
    }

    @Test
    final void "test if the validator works fine for minutes less than 0"(){
        minutes = -1
        checkViolations "{javax.validation.constraints.Min.message}"
    }

    @Test
    final void "test if the validator works fine for seconds greater 60"(){
        seconds = 61
        checkViolations "{javax.validation.constraints.DecimalMax.message}"
    }

    @Test
    final void "test if the validator works fine for seconds less than 0"(){
        seconds = -1
        checkViolations "{javax.validation.constraints.DecimalMin.message}"
    }

    @Test
    final void "test if the validator works fine for too much fraction for seconds" (){
        seconds = 2.34567
        checkViolations "{javax.validation.constraints.Digits.message}"
    }

    private void checkViolations(String messageTemplate) {
        def violations = validator.validate(declination)
        Assert.assertEquals "Expecting one violation", 1, violations.size()

        violations.each {
            Assert.assertEquals messageTemplate, it.messageTemplate
        }
    }
}
