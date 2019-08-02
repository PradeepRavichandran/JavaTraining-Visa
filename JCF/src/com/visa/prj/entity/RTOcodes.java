package com.visa.prj.entity;

import java.util.HashMap;
import java.util.Map;

public class RTOcodes implements Comparable<RTOcodes>{
	public String stateCode;
	public String zonalCode;
	public String VCode;
	public String location;
	public static Map map = new HashMap<String, String>();
	
	public RTOcodes(String stateCode, String zonalCode, String vCode) {
		super();
		map.put("KA01", "Koramangala");
		map.put("KA02", "Rajajinagar");
		map.put("KA03", "Indiranagar");
		map.put("KA04", "Yeshwanthpur");
		map.put("KA50", "Yelahanka");
		map.put("KA51", "Electronics City");
		map.put("KA52", "Nelamangala");
		map.put("KA53", "K.R.Puram");
		map.put("KA54", "Nagamangala");
		map.put("KA55", "Mysore East");
		map.put("KA56", "Basavakalyan");
		map.put("KA57", "Shantinagar");
		map.put("KA05", "Jayanagar");

		this.stateCode = stateCode;
		this.zonalCode = zonalCode;
		this.VCode = vCode;
		this.location = (String) map.get(this.stateCode+this.zonalCode);
	}
	

	public String getStateCode() {
		return stateCode;
	}
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}
	public String getZonalCode() {
		return zonalCode;
	}
	public void setZonalCode(String zonalCode) {
		this.zonalCode = zonalCode;
	}
	public String getVCode() {
		return VCode;
	}
	public void setVCode(String vCode) {
		VCode = vCode;
	}
	
	@Override
	public int compareTo(RTOcodes c) {
//		System.out.println(this.location);
//		System.out.println(c.location);
		int cmp = this.location.compareToIgnoreCase(c.location);
		if(cmp != 0) {
			return cmp;
		}
		else {
			cmp = this.VCode.compareTo(c.VCode);
			return cmp;
		}
	}
	
}
