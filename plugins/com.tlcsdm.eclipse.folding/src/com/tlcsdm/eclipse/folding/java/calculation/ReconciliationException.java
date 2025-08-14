package com.tlcsdm.eclipse.folding.java.calculation;

/**
 * An Exception that occurs during the reconciliation process (matching foldable
 * regions up after user changes).
 * 
 * @author R.J. Lorimer
 */
public class ReconciliationException extends RuntimeException {

	// {{ Default constructors
	// {{ sub constructors
	public ReconciliationException(String message) {
		super(message);
	}

	public ReconciliationException(String message, Throwable cause) {
		super(message, cause);

	}
	// }}
	// }}
	// {{ Another constructor

	// }}
}