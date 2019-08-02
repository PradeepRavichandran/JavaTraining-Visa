package com.visa.prj.client;

import java.util.Arrays;

import com.visa.prj.entity.RTOcodes;

public class RTOSortClient {

	public static void main(String[] args) {
		RTOcodes[] codes = new RTOcodes[5];
		
		codes[0] = new RTOcodes("KA","51", "A9");
		codes[1] = new RTOcodes("KA","02", "L41");
		codes[2] = new RTOcodes("KA","57", "DE111");
		codes[3] = new RTOcodes("KA","57", "AB9011");
		codes[4] = new RTOcodes("KA","04", "500");
		Arrays.sort(codes);

		for(RTOcodes c : codes) {
			System.out.println(c.stateCode+" "+c.zonalCode+" "+c.VCode);
		}
		
	}

}
