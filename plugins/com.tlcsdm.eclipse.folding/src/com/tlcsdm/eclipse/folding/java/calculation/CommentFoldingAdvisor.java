package com.tlcsdm.eclipse.folding.java.calculation;

/**
 * API for a class that advises the CommentHelper on what types of comments
 * should be collapsed and folded based on the context of the
 * CommentFoldingAdvisor itself.
 * 
 * @author R.J. Lorimer
 */
public interface CommentFoldingAdvisor {

	boolean shouldCollapseBlockComment();

	boolean shouldCollapseLineComment();

	boolean shouldCollapseJavadoc();

	boolean shouldFoldBlockComment();

	boolean shouldFoldLineComment();

	boolean shouldFoldJavadoc();

}