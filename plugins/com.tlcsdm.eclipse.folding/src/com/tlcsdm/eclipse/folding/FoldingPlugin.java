package com.tlcsdm.eclipse.folding;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import com.tlcsdm.eclipse.folding.java.JavaSettings;
import com.tlcsdm.eclipse.folding.java.preferences.Defaults;
import com.tlcsdm.eclipse.folding.theme.Images;

/**
 * The main plugin class for the FoldingPlugin.
 */
public class FoldingPlugin extends AbstractUIPlugin {

	// The shared instance.
	private static FoldingPlugin plugin;
	// Resource bundle.
	private ResourceBundle resourceBundle;
	private boolean resourceBundleBuilt;

	private Images images;

	private JavaSettings javaDomain;

	/**
	 * The constructor.
	 */
	public FoldingPlugin() {
		super();
		try {

			plugin = this;

			images = new Images();
			Defaults.applyDefaults(getPrefs());
			javaDomain = new JavaSettings(getPrefs());
		} catch (Exception e) {
			log(IStatus.ERROR, "Error initializing FoldingPlugin", e);
		}

	}

	public static void restoreToDefaults() {
		Defaults.restoreDefaults(getPrefs());
	}

	/**
	 * This method is called upon plug-in activation
	 */
	public void start(BundleContext context) throws Exception {

		super.start(context);
	}

	/**
	 * This method is called when the plug-in is stopped
	 */
	public void stop(BundleContext context) throws Exception {
		super.stop(context);
	}

	/**
	 * Returns the shared instance.
	 */
	public static FoldingPlugin getDefault() {
		return plugin;
	}

	public static Images getImages() {
		return getDefault().images;
	}

	public static JavaSettings getJavaDomain() {
		return getDefault().javaDomain;
	}

	public static IPreferenceStore getPrefs() {
		return getDefault().getPreferenceStore();
	}

	/**
	 * Returns the string from the plugin's resource bundle, or 'key' if not found.
	 */
	public static String getMessage(String key) {
		ResourceBundle bundle = FoldingPlugin.getDefault().getResourceBundle();
		try {
			return (bundle != null) ? bundle.getString(key) : key;
		} catch (MissingResourceException e) {
			return key;
		}
	}

	public static boolean getBoolean(String key) {
		return FoldingPlugin.getPrefs().getBoolean(key);
	}

	/**
	 * Returns the plugin's resource bundle,
	 */
	public ResourceBundle getResourceBundle() {
		if (!resourceBundleBuilt) {
			try {
				resourceBundle = ResourceBundle.getBundle("com.tlcsdm.eclipse.folding.FoldingResources");
			} catch (MissingResourceException x) {
				resourceBundle = null;
			}

			resourceBundleBuilt = true;
		}

		return resourceBundle;
	}

	/**
	 * Logs a message with the given severity to the plugin's log.
	 *
	 * @param severity one of IStatus severity constants
	 * @param message  the message to log
	 * @param e        the exception to log, or null
	 */
	public static void log(int severity, String message, Throwable e) {
		getDefault().getLog().log(new Status(severity, "com.tlcsdm.eclipse.folding", message, e));
	}
}