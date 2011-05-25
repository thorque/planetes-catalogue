/**
 * 
 */
package de.planetes.catalogue.db;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import de.planetes.catalogue.IConstellation;
import de.planetes.catalogue.IFixedSkyObject;
import de.planetes.catalogue.ri.CatalogueFactory;

/**
 * @author kamann
 * 
 */
@Entity(name = "CONSTELLATION")
public class ConstellationDB {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long identifier;
	private String name;
	private String description;
	private String code;
	@Transient
	private List<IFixedSkyObject> skyObjects;

	public static ConstellationDB transformTo(IConstellation constellation) {
		ConstellationDB cdb = new ConstellationDB();

		cdb.code = constellation.getCode();
		cdb.description = constellation.getDescription();
		cdb.identifier = constellation.getIdentifier();
		cdb.name = constellation.getName();
		cdb.skyObjects = constellation.getSkyObjects();

		return cdb;
	}

	public IConstellation transformFrom() {
		IConstellation constellation = CatalogueFactory.createConstellation(
				name, description, code, skyObjects);
		constellation.setIdentifier(identifier);
		return constellation;
	}
}
