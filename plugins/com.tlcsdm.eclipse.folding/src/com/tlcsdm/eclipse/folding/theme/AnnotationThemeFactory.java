package com.tlcsdm.eclipse.folding.theme;

import org.eclipse.jface.text.source.projection.ProjectionAnnotation;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;

/**
 * Selects theme controls based on the format of the annotation provided.
 * 
 * @author R.J. Lorimer
 */
public abstract class AnnotationThemeFactory {

	private static final DefaultAnnotationRangeIndicator defaultRangeIndicator = new DefaultAnnotationRangeIndicator();

	private static DefaultAnnotationThemeFactory defaultAnnotations = new DefaultAnnotationThemeFactory();

	/**
	 * Factory method for selecting a factory based on the annotation object.
	 * 
	 * @param annotation
	 * @return An annotation image factory for selecting annotation images
	 */
	public static AnnotationThemeFactory getFactory(ProjectionAnnotation annotation) {
		return getFactory(annotation.getClass());
	}

	public static AnnotationThemeFactory getFactory(Class annotationType) {
		return defaultAnnotations;
	}

	protected Image getImage(String key, boolean isFolded) {

		String trueKey = key + ((isFolded) ? ".collapsed" : ".expanded");
		return FoldingPlugin.getImages().getImage(trueKey);
	}

	public abstract Image getCollapsedImage(Display disp, ProjectionAnnotation annotation);

	public abstract Image getExpandedImage(Display disp, ProjectionAnnotation annotation);

	public abstract ProjectionAnnotationRangeIndicator getRangeIndicator(ProjectionAnnotation annotation);

	protected ProjectionAnnotationRangeIndicator getDefaultRangeIndicator() {
		return defaultRangeIndicator;
	}

}
