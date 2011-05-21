/**
 * 
 */
package de.planetes.catalogue.ri.service.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

/**
 * @author kamann
 *
 */
@Repository
public class SkyObjectRepository {

	@PersistenceContext
	private EntityManager em;

	public List findAllMessierObjects() {
		return em.createQuery("from ConstellationDB c").getResultList();
	}

}
