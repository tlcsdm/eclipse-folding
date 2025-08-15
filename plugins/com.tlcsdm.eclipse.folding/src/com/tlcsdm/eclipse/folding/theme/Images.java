package com.tlcsdm.eclipse.folding.theme;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;

import com.tlcsdm.eclipse.folding.FoldingPlugin;

/**
 * A centralized class for managing images in the FoldingPlugin.
 * 
 * @author R.J. Lorimer
 */
public class Images {

	private ImageRegistry registry;

	public Images() {
		registry = new ImageRegistry();

		// pre-load.
		registry.put(FoldingPlugin.getMessage("default.icons.title") + ".collapsed",
				FoldingPlugin.imageDescriptorFromPlugin("org.eclipse.jface.text",
						"org/eclipse/jface/text/source/projection/images/collapsed.png"));
		registry.put(FoldingPlugin.getMessage("default.icons.title") + ".expanded",
				FoldingPlugin.imageDescriptorFromPlugin("org.eclipse.jface.text",
						"org/eclipse/jface/text/source/projection/images/expanded.png"));
		registry.put(FoldingPlugin.getMessage("modern.icons.title") + ".collapsed",
				FoldingPlugin.imageDescriptorFromPlugin("com.tlcsdm.eclipse.folding", "icons/theme/collapsed.gif"));
		registry.put(FoldingPlugin.getMessage("modern.icons.title") + ".expanded",
				FoldingPlugin.imageDescriptorFromPlugin("com.tlcsdm.eclipse.folding", "icons/theme/expanded.gif"));

		// TODO - constantify these
		registry.put("CHECKED",
				FoldingPlugin.imageDescriptorFromPlugin("com.tlcsdm.eclipse.folding", "icons/checked.gif"));
		registry.put("UNCHECKED",
				FoldingPlugin.imageDescriptorFromPlugin("com.tlcsdm.eclipse.folding", "icons/unchecked.gif"));
	}

	public Image getImage(String key) {
		return registry.get(key);
	}

	public Image getCheckBoxImage(boolean checked) {
		return ((checked) ? registry.get("CHECKED") : registry.get("UNCHECKED"));
	}

	public void registerImage(String key, ImageLookupKey globalKey) {
		registerImage(key, globalKey.getResourceClass(), globalKey.getResourcePath());
	}

	public void registerImage(String key, Class resourceClass, String resourcePath) {
		if (registry.get(key) != null) {
			throw new IllegalArgumentException("Image with key: " + key + " already exists");
		}
		registry.put(key, ImageDescriptor.createFromFile(resourceClass, resourcePath));
	}

	public String[] getAvailableFoldingKeys() {
		return new String[] { FoldingPlugin.getMessage("default.icons.title"),
				FoldingPlugin.getMessage("modern.icons.title") };
	}

}
