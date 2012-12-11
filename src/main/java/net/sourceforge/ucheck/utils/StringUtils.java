package net.sourceforge.ucheck.utils;

public class StringUtils {

	public static boolean isBlank(final String test) {
		return test == null || "".equals(test.trim());
	}
	public static boolean isEmpty(final String test) {
		return test == null || "".equals(test);
	}
}
