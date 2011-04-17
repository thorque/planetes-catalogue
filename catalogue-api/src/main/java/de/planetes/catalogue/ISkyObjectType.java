package de.planetes.catalogue;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by IntelliJ IDEA. User: kamann Date: 15.04.11 Time: 10:06 To change
 * this template use File | Settings | File Templates.
 */
public interface ISkyObjectType {

	@NotNull
	public String getName();

	@NotNull
	@Size(max = 3)
	public String getCode();
}
