package com.tlcsdm.eclipse.folding.java.calculation;

import java.util.Collections;
import java.util.Set;

import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.JavaModelException;

import com.tlcsdm.eclipse.folding.EnhancedPosition;

/**
 * A simple 'do nothing' Strategy.
 * 
 * @author R.J. Lorimer
 */
public class NoOpStrategy extends AbstractCalculationStrategy {

	private static final EnhancedPosition[] EMPTY = new EnhancedPosition[0];

	public NoOpStrategy() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.tlcsdm.eclipse.folding.calculation.CalculationStrategy#shouldScan(org.
	 * eclipse .jdt.core.IJavaElement)
	 */
	public boolean shouldScan(IJavaElement elem) throws JavaModelException {
		// Do not scan.
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.tlcsdm.eclipse.folding.calculation.CalculationStrategy#handle(int,
	 * int, int, org.eclipse.jdt.core.IJavaElement)
	 */
	public void handle(int nextToken, int start, int end, IJavaElement owner) {
		// NO-OP

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.tlcsdm.eclipse.folding.calculation.CalculationStrategy#keepProcessing(
	 * int)
	 */
	public boolean keepProcessing(int nextToken) {
		// NO-OP
		return false;
	}

	public Set result() {
		return Collections.EMPTY_SET;
	}

	public void initialize() {

	}

	public void destroy() {

	}
}