/**
 * 
 */
package de.planetes.catalogue.db.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import de.planetes.catalogue.IConstellation;
import de.planetes.catalogue.db.ConstellationDB;

/**
 * @author kamann
 *
 */
@Repository
public class ConstellationRepository implements IConstellationRepository {
	
	@PersistenceContext
	private EntityManager em;

	/* (non-Javadoc)
	 * @see de.planetes.catalogue.db.repository.IConstellationRepository#findAllConstellations()
	 */
	
	@SuppressWarnings("unchecked")
	@Override
	public List<IConstellation> findAllConstellations() {
		List<ConstellationDB> results;
		List<IConstellation> constellations = new ArrayList<IConstellation>();
		
		
		results = em.createQuery("from CONSTELLATION c").getResultList();
		for (ConstellationDB cdb : results) {
			constellations.add(cdb.transformFrom());
		}
		return constellations;
	}

	/* (non-Javadoc)
	 * @see de.planetes.catalogue.db.repository.IConstellationRepository#findConstellationByName(java.lang.String)
	 */
	@Override
	public IConstellation findConstellationByName(String name) {
		//em.getCriteriaBuilder()
		return null;
	}

	/* (non-Javadoc)
	 * @see de.planetes.catalogue.db.repository.IConstellationRepository#findConstellationByCode(java.lang.String)
	 */
	@Override
	public IConstellation findConstellationByCode(String code) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see de.planetes.catalogue.db.repository.IConstellationRepository#persistOrMergeConstellation(de.planetes.catalogue.IConstellation)
	 */
	@Override
	public IConstellation persistOrMergeConstellation(
			IConstellation constellation) {
		ConstellationDB cdb = ConstellationDB.transformTo(constellation);
		if (constellation.getIdentifier() != null){
			em.merge(cdb);
		}else{
			em.persist(cdb);
			constellation.setIdentifier(cdb.identifier);
		}
		return constellation;
	}

}
