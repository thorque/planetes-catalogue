/**
 * 
 */
package de.planetes.catalogue.ri.exception;

/**
 * @author kamann
 *
 */
public class WrongPositionDataException extends RuntimeException {
	private static final long serialVersionUID = -3960718312362922349L;

	/**
	 * 
	 */
	public WrongPositionDataException() {
		super();
	}

	/**
	 * @param arg0
	 */
	public WrongPositionDataException(String arg0) {
		super(arg0);
	}

	/**
	 * @param arg0
	 */
	public WrongPositionDataException(Throwable arg0) {
		super(arg0);
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public WrongPositionDataException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

}
