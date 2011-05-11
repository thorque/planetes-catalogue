package de.planetes.catalogue.ri;

import org.springframework.beans.factory.annotation.Configurable;

import de.planetes.catalogue.IFixedSkyObject;
import de.planetes.catalogue.IMessierObject;
import de.planetes.catalogue.IPosition;
import de.planetes.catalogue.ISkyObject;
import de.planetes.catalogue.ISkyObjectType;

/**
 * RI of the interface {@link ISkyObject}. A SkyObject describes every object
 * you can find at the sky. There are some specialized Interfaces for this
 * general class.
 * 
 * @author Thorsten Kamann
 * 
 * @see IFixedSkyObject
 * @see IMessierObject
 */
@Configurable
public class SkyObject extends AbstractValidatedCatalogue implements ISkyObject {
	private String name;
	private String description;
	private IPosition position;
	private ISkyObjectType type;

	/**
	 * Constructor to create a new instance of a SkyObject. It's protected
	 * because the creation should be done through a Factory. Therefore no
	 * setter methods existing.
	 * 
	 * @param name
	 * @param description
	 * @param position
	 * @param type
	 */
	protected SkyObject(String name, String description, IPosition position,
			ISkyObjectType type) {
		this.name = name;
		this.description = description;
		this.position = position;
		this.type = type;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.planetes.catalogue.ISkyObject#getName()
	 */
	public String getName() {
		return name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.planetes.catalogue.ISkyObject#getDescription()
	 */
	public String getDescription() {
		return description;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.planetes.catalogue.ISkyObject#getPosition()
	 */
	public IPosition getPosition() {
		return position;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.planetes.catalogue.ISkyObject#getType()
	 */
	public ISkyObjectType getType() {
		return type;
	}

}
