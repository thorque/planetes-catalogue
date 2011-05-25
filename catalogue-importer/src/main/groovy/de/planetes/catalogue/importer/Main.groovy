/**
 * 
 */
package de.planetes.catalogue.importer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author kamann
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/META-INF/spring/*-context.xml");

		applicationContext.getBean("constellationImporter").importIntoDB()
	}

}
