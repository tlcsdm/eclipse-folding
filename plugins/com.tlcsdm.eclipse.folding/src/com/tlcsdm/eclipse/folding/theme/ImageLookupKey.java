package com.tlcsdm.eclipse.folding.theme;

/**
 * A convenience key for mapping images to their lookup information.
 * 
 * @author R.J. Lorimer
 */
public class ImageLookupKey {

	private Class resourceClass;
	private String resourcePath;

	ImageLookupKey(Class resourceClass, String resourcePath) {
		this.resourceClass = resourceClass;
		this.resourcePath = resourcePath;
	}

	public Class getResourceClass() {
		return resourceClass;
	}

	public String getResourcePath() {
		return resourcePath;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || !o.getClass().equals(getClass())) {
			return false;
		}
		ImageLookupKey other = (ImageLookupKey) o;
		return this.resourceClass.equals(other.resourceClass) && this.resourcePath.equals(other.resourcePath);
	}

	@Override

	public int hashCode() {
		return 11 + resourcePath.hashCode() + resourceClass.hashCode();
	}

}