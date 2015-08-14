package net.sourceforge.ucheck.utils;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class StringUtilsTest {

	public StringUtilsTest() {
		super();
	}
	
	@Test
	public void testIsBlank() {
		assertTrue(StringUtils.isBlank(null));
		assertTrue(StringUtils.isBlank(""));
		assertTrue(StringUtils.isBlank(" "));
		assertTrue(StringUtils.isBlank("\t"));
		assertTrue(StringUtils.isBlank("\n"));
		assertTrue(StringUtils.isBlank("\r"));
		assertFalse(StringUtils.isBlank("a"));
	}
	
	@Test
	public void testIsEmpty() {
		assertTrue(StringUtils.isEmpty(null));
		assertTrue(StringUtils.isEmpty(""));
		assertFalse(StringUtils.isEmpty(" "));
		assertFalse(StringUtils.isEmpty("a"));
	}
}
