/**
 * 
 */
package de.planetes.catalogue.db.repository;

import static org.junit.Assert.*

import javax.inject.Inject

import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.transaction.annotation.Transactional;

import de.planetes.catalogue.ri.CatalogueFactory

/**
 * @author kamann
 *
 */
@RunWith(SpringJUnit4ClassRunner)
@ContextConfiguration("/de/planetes/catalogue/db/DBTest-context.xml")
@Transactional
class ConstellationRepositoryTest {
	def data = []

	@Inject
	private ConstellationRepository repository
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		5.times{
			data << CatalogueFactory.createConstellation("name$it", "desc$it", "cd$it", [])
		}
		
		data.each{
			repository.persistOrMergeConstellation it
		}
	}
	
	@Test
	final void "test find all persited constellations"(){
		Assert.assertEquals 5, repository.findAllConstellations().size()
	}

}
