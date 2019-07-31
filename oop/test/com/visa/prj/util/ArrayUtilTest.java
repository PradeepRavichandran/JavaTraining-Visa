package com.visa.prj.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArrayUtilTest {

	@Test
	public void testGetSum() {
		int[] data = {5,6,4};
		assertEquals(15,  ArrayUtil.getSum(data));
		
		int[] elems = {-1, 0, 1};
		assertEquals(0,  ArrayUtil.getSum(elems));
	}

	@Test
	public void testGetCount() {
		int[] elems = {5, 11, 34, 67, 44, 56, 67, 67, 1, 67};
		assertEquals(4,  ArrayUtil.getCount(elems, 67));
	}

	@Test
	public void testSort() {
		int[] elems = {11, -2, 10, 0, 5, 22, 19, -7};
		ArrayUtil.sort(elems);
		int[] expected = {-7, -2, 0, 5, 10, 11, 19, 22};
		assertArrayEquals(expected, elems);  //assertArryEquals if not addresses will be compared
	}

}
