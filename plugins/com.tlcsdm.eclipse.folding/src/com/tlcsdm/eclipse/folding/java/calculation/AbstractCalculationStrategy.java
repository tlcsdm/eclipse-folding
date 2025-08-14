package com.tlcsdm.eclipse.folding.java.calculation;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.ISourceRange;
import org.eclipse.jdt.core.ISourceReference;
import org.eclipse.jdt.core.JavaModelException;

import com.tlcsdm.eclipse.folding.EnhancedPosition;
import com.tlcsdm.eclipse.folding.java.JavaPositionMetadata;

/**
 * Convenience superclass for managing CalculationStrategy lifecycles.
 * 
 * @author R.J. Lorimer
 */
public abstract class AbstractCalculationStrategy implements RegionCalculationStrategy {

	private Set result;

	public AbstractCalculationStrategy() {

	}

	public Set result() throws JavaModelException {
		return result;
	}

	public boolean shouldScan(IJavaElement elem) throws JavaModelException {
		return true;
	}

	public void postScan(int position, IJavaElement elem) throws JavaModelException {

	}

	public void handle(int nextToken, int start, int end, IJavaElement owner) throws JavaModelException {

	}

	public boolean keepProcessing(int nextToken) {
		return false;
	}

	/**
	 * Convenient super-class to add a region during a scan process.
	 * 
	 * @param position
	 */
	protected void addRegion(EnhancedPosition position) {
		((JavaPositionMetadata) position.getMetadata())
				.setOwner(getClass().getName().substring(getClass().getName().lastIndexOf('.') + 1));
		result.add(position);
	}

	/**
	 * Convenient super-class to add a collection of regions.
	 * 
	 * @param regions
	 */
	protected void addAllRegions(Collection regions) {
		result.addAll(regions);
	}

	/**
	 * This method finds the ISourceRange object for an IJavaElement
	 * 
	 * @param elem
	 * @return @throws JavaModelException
	 */
	protected ISourceRange getNaturalRange(IJavaElement elem) throws JavaModelException {
		ISourceReference ref = (ISourceReference) elem;
		return ref.getSourceRange();
	}

	public String toString() {
		// produce helpful message.
		StringBuffer msg = new StringBuffer();
		String nme = getClass().getName();
		msg.append(nme.substring(nme.lastIndexOf(".")));
		msg.append(" - [\n");
		for (Iterator iter = result.iterator(); iter.hasNext();) {
			Object elem = iter.next();
			msg.append(elem).append("\n");
		}
		msg.append("]");
		return msg.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.tlcsdm.eclipse.folding.calculation.RegionCalculationStrategy#dispose()
	 */
	public void dispose() {
		result = null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.tlcsdm.eclipse.folding.calculation.RegionCalculationStrategy#initialize()
	 */
	public void initialize() {
		result = new HashSet();

	}
}