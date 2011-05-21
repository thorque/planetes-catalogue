package de.planetes.catalogue.ri.db;

import static org.junit.Assert.*

import javax.inject.Inject

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.transaction.TransactionConfiguration
import org.springframework.transaction.annotation.Transactional

import de.planetes.catalogue.ri.service.repository.SkyObjectRepository

@TransactionConfiguration
@ContextConfiguration(["classpath:META-INF/spring/component-context.xml"])
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
class ConstellationDBTest {

	@Inject
	SkyObjectRepository repository

	@Test
	final void "count the number of persons"(){
		Assert.assertNotNull(repository.findAllMessierObjects().size())
	}
}
