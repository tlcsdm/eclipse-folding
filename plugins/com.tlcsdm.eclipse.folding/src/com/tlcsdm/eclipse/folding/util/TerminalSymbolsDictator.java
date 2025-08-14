package com.tlcsdm.eclipse.folding.util;

import java.lang.reflect.Field;

import org.eclipse.jdt.core.compiler.ITerminalSymbols;

/**
 * Uses reflection to print out the name of a token from the ITerminalSymbols
 * class given the token value.
 * 
 * This is NOT intended for production use.
 * 
 * @author R.J. Lorimer
 */
public class TerminalSymbolsDictator {

	public static String dictate(int token) {
		try {
			String tokenName;

			Field[] allTokens = ITerminalSymbols.class.getFields();
			for (int i = 0; i < allTokens.length; i++) {
				Field aField = allTokens[i];
				int fieldValue = ((Integer) aField.get(null)).intValue();
				if (token == fieldValue) {
					return aField.getName();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "<NO TOKEN!>";
	}
}