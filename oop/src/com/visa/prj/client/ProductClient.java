package com.visa.prj.client;

import java.lang.reflect.Method;

import com.visa.prj.entity.Mobile;
import com.visa.prj.entity.Product;
import com.visa.prj.entity.Tv;

public class ProductClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Product[] products = new Product[5]; // Array of 4 Pointers
		products[0] = new Tv(133,"Sony Bravia",135000.00,"LED");
		products[1] = new Mobile(453, "MotoG", 12999.00, "4G");
		products[2] = new Tv(634,"Onida Thunder",3500.00,"CRT");
		products[3] = new Mobile(621, "iPhone XR", 99999.00, "4G");
		products[4] = new Mobile(844, "Oppo", 9999.00, "4G");
		printExpensive(products);
		printInfo(products);
		printInfoOCP(products);
	}

	private static void printInfoOCP(Product[] products) {
		for (Product p : products) {
			Method[] methods = p.getClass().getMethods();
			for(Method m : methods) {
				if(m.getName().startsWith("get")) {
					try {
						Object ret = m.invoke(p);
						System.out.println(ret);
					} catch(Exception ex) {
						System.out.println(ex);
					}
				}
			}
		}
	}

	private static void printInfo(Product[] products) {
		// TODO Auto-generated method stub
		for (Product p : products) {
			System.out.println(p.getName() + "," + p.getPrice());
			if(p.getClass() == Tv.class) {  //strict checking of class
				Tv t = (Tv) p;
				System.out.println(t.getConnectivity());
			}else if(p instanceof Mobile) {  // check if it belongs to family
				Mobile m = (Mobile) p;
				System.out.println(m.getConnectivity());
			}
			System.out.println("******");
		}		
	}

	private static void printExpensive(Product[] products) {
		// TODO Auto-generated method stub
		for (int i = 0; i < products.length; i++) {
			if(products[i].isExpensive()) {  //dynamic binding, polymorphic
				System.out.println(products[i].getName() + " is expensive!! ");
			}
			else {
				System.out.println(products[i].getName() + " is not expensive!! ");
			}
			
		}
		
	}

}
