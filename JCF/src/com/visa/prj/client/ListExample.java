package com.visa.prj.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.visa.prj.entity.Product;

public class ListExample {

	public static void main(String[] args) {
		List<Product> products = new ArrayList<>();
		products.add(new Product(645,"Hp Laptop",135000.00,"computer",100));
		products.add(new Product(224,"iPhone",98000.00,"mobile",500));
		products.add(new Product(834,"Logitech Mouse",600.00,"computer",300));
		products.add(new Product(5,"Sony Bravia",125000.00,"tv",900));
		products.add(new Product(912,"One Plus",32000.00,"mobile",100));
		products.add(new Product(88,"HP Printer",19000.00,"computer",100));
		
		Map<String, List<Product>> catMap = 
				products.stream().collect(Collectors.groupingBy(p -> p.getCategory()));
		
		Set<String> keys = catMap.keySet();
		for(String key : keys) {
			System.out.println(key);			//used only for conditional cases not for printing everything
			List<Product> prds = catMap.get(key);
			prds.forEach(System.out::println);
		}
		
		System.out.println("*********");
		
		catMap.forEach((k,v) -> {   ///used when we need to access all and its faster
			System.out.println(k);
			v.forEach(System.out::println);
		}
		);
		
		System.out.println("*********");

		//products.stream().filter(p->p.getCategory().equals("mobile")).forEach(p->System.out.println(p));
		
		List<String> names = products.stream().map(p->p.getName()).collect(Collectors.toList());
		
		for (String n : names) {
			System.out.println(n);
			
		}
		
		double total = products.stream().map(p->p.getPrice()).reduce(0.0,(v1,v2) ->v1+v2);
		System.out.println(total);
		
		//shorter from for lambda when whatever coming from LHS is used
		products.stream().map(p->p.getName()).forEach(System.out::println);
		
		
		
		
//		Collections.sort(products,  (p1,p2) -> Double.compare(p1.getPrice(),p2.getPrice()));
//		//when we want to sort lists use Collections interface
//		
//		System.out.println("for each");
//		for(Product p : products) {
//			System.out.println(p);
//		}
//		
		/*
		System.out.println("iterator");
		
		Iterator<Product> iter = products.iterator();
		while(iter.hasNext()) {
			Product p = iter.next();
			System.out.println(p);
			/*if(p.getCategory().equals("Tv")){
			 * iter.remove();
			 * }
			 
		}
		
		System.out.println("Index based : Avoid");
		for(int i=0; i< products.size(); i++) {	     //Avoid doing this
			System.out.println(products.get(i));
		}
		*/
	}
}
