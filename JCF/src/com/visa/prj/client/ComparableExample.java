package com.visa.prj.client;

import java.util.Arrays;

public class ComparableExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] names = {"Lee", "Kevin", "Angelina", "George", "Brad"};
		//Arrays.sort(names);
		
		//using comparator to specify client logic of comparison
		Arrays.parallelSort(names, (s1,s2) -> s1.length() - s2.length()); 
		for(String name:names ) {
			System.out.println(name);
		}
	}

}
