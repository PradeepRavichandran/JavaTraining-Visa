package com.visa.prj.client;

import java.util.ArrayList;
import java.util.List;

import com.visa.prj.entity.Fruits;

public class FruitsClient {

	public static void main(String[] args) {

		List<Fruits> fruits = new ArrayList<>();
		
		fruits.add(new Fruits("Mango",7));
		fruits.add(new Fruits("Apple",5));
		fruits.add(new Fruits("Apple",7));
		fruits.add(new Fruits("Mango",7));
		fruits.add(new Fruits("Mango",7));
		
		
		
	}

}
