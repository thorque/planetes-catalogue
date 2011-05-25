package de.planetes.catalogue;

import javax.inject.Inject;

import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.WebPage;

import de.planetes.catalogue.service.IConstellationService;
import de.planetes.catalogue.service.ISkyObjectService;

public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;

	@SpringBean
	private ISkyObjectService constellationService;
	
    public HomePage(final PageParameters parameters) {
		add(new Label("version", getApplication().getFrameworkSettings().getVersion()));
		add(new Label("myLbl", constellationService.getClass().getSimpleName()));
        // TODO Add your page's components here
    }
}
