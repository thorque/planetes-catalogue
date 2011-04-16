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
class IPositionTest {
    IPosition position
    IRightAscension ra
    IDeclination declination

    @Autowired
    private Validator validator

    @Before
    void setup() {
        ra = [] as IRightAscension
        declination = [] as IDeclination
        position = [getRightAscension: {ra}, getDeclination: {declination}] as IPosition
    }

    @Test
    final void "test validator works fine if no rightascension is set"() {
        ra = null

        def violations = validator.validate(position)
        Assert.assertEquals 1, violations.size()
        violations.each {
            Assert.assertEquals "{javax.validation.constraints.NotNull.message}", it.messageTemplate
        }
    }

    @Test
    final void "test validator works fine if no declination is set"() {
        declination = null

        def violations = validator.validate(position)
        Assert.assertEquals 1, violations.size()
        violations.each {
            Assert.assertEquals "{javax.validation.constraints.NotNull.message}", it.messageTemplate
        }
    }

    @Test
    final void "test validator works fine if all is set correctly"() {
        def violations = validator.validate(position)
        Assert.assertEquals 0, violations.size()
    }
}