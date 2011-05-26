package de.planetes.catalogue;

import java.util.List;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigator;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.markup.repeater.data.ListDataProvider;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;

import de.planetes.catalogue.service.IConstellationService;

public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;

	@SpringBean
	private IConstellationService constellationService;

	@SuppressWarnings({ "rawtypes", "serial", "unchecked" })
	public HomePage(final PageParameters parameters) {
		add(new Label("version", getApplication().getFrameworkSettings()
				.getVersion()));
		// add(new Label("myLbl",
		// "Const: "+constellationService.findAllConstellations().size()));
		// TODO Add your page's components here

		List<IConstellation> constellations = constellationService
				.findAllConstellations();

		final DataView dataView = new DataView("simple", new ListDataProvider(
				constellations)) {
			public void populateItem(final Item item) {
				final IConstellation constellation = (IConstellation) item
						.getModelObject();
				item.add(new Label("name", constellation.getName()));
				item.add(new Label("description", constellation.getDescription()));
				item.add(new Label("code", constellation.getCode()));
			}
		};

		// dataView.setItemsPerPage(10);

		add(dataView);

		add(new PagingNavigator("navigator", dataView));

	}
}
