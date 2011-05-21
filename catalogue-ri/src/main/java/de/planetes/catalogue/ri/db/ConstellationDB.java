/**
 * 
 */
package de.planetes.catalogue.ri.db;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import de.planetes.catalogue.IConstellation;
import de.planetes.catalogue.IFixedSkyObject;

/**
 * @author kamann
 *
 */
@Entity
public class ConstellationDB implements IConstellation {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	private String name;
	private String description;
	private String code;
	@Transient
	private List<IFixedSkyObject> skyObjects;


	/* (non-Javadoc)
	 * @see de.planetes.catalogue.IConstellation#getName()
	 */
	public String getName() {
		return name;
	}

	/* (non-Javadoc)
	 * @see de.planetes.catalogue.IConstellation#getDescription()
	 */
	public String getDescription() {
		return description;
	}

	/* (non-Javadoc)
	 * @see de.planetes.catalogue.IConstellation#getCode()
	 */
	public String getCode() {
		return code;
	}

	/* (non-Javadoc)
	 * @see de.planetes.catalogue.IConstellation#getSkyObjects()
	 */
	public List<IFixedSkyObject> getSkyObjects() {
		return skyObjects;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @param code
	 *            the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

}
