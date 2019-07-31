package com.visa.prj.dao;

import java.util.ResourceBundle;

import com.visa.prj.dao.impl.MobileDaoDbImpl;

public class MobileDaoFactory {
	
	private static String NAME = "";
	
	static { // static block
		ResourceBundle res = ResourceBundle.getBundle("database");
		NAME = res.getString("MOBILE_CLASS").trim();
	}

	public static MobileDao getMobileDao() { //static to avoid memory waste due to unnecessary object creation
		//return new MobileDaoDbImpl();
		
		try {
			return (MobileDao) Class.forName(NAME).newInstance();
		}
		catch(Exception ex) {
			System.out.println(ex);
		}
		return null;
}
}
