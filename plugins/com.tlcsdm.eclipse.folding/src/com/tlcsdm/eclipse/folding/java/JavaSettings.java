package com.tlcsdm.eclipse.folding.java;

import org.eclipse.jface.preference.IPreferenceStore;

import com.tlcsdm.eclipse.folding.java.user.UserDefinedSettings;

/**
 * The JavaSettings class is the Java domain extension to the folding plug-in.
 * 
 * @author R.J. Lorimer
 */
public class JavaSettings {

	private UserDefinedSettings userDefinedSettings;

	public JavaSettings(IPreferenceStore store) {
		userDefinedSettings = new UserDefinedSettings(store);

	}

	public UserDefinedSettings getUserDefinedSettings() {
		return userDefinedSettings;
	}

	public void save() {

		userDefinedSettings.save();
	}

}
