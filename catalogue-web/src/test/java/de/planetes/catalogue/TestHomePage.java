package de.planetes.catalogue;

import org.apache.wicket.util.tester.WicketTester;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Simple test using the WicketTester
 */
public class TestHomePage {
	private WicketTester tester;

	@Before
	@Ignore
	public void setUp() {
		tester = new WicketTester(new WicketApplication());
	}

	@Test
	@Ignore
	public void homepageRendersSuccessfully() {
		tester.startPage(HomePage.class);
		tester.assertRenderedPage(HomePage.class);
	}
}
