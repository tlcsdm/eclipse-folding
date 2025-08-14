package com.tlcsdm.eclipse.folding.preferences;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

/**
 * TODO Javadoc.
 * 
 * @author R.J. Lorimer
 */
public interface PreferencesTab {

	String getTabName();

	Control getTabControl(Composite parent);
}
