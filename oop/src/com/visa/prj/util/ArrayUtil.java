package com.visa.prj.util;

public class ArrayUtil {

	public static int getSum(int[] elems) {
		int sum = 0;
		for(int i = 0; i < elems.length; i++ ) {
			sum += elems[i];
			
		}
		return sum;
	}
	
	public static int getCount(int[] elems, int no) {
		int count = 0;
		for(int i=0; i<elems.length; i++) {
			if(no == elems[i]) {
				count++;
			}
		}
		
		return count;
	}
	
	public static void sort(int[] elems) {
		for(int i=0; i<elems.length; i++) {
			for(int j = i+1; j<elems.length; j++) {
				if(elems[i] > elems[j]) {
					int temp = elems[i];
					elems[i] = elems[j];
					elems[j] = temp;
				}
			}
		}
	}
}
