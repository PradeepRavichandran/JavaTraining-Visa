package com.visa.prj.client;

import java.lang.reflect.Method;
import java.util.Map;

import com.visa.prj.entity.Employee;
import com.visa.prj.entity.Message;

public class XMLGenerate {

	public static void main(String[] args) {

		Employee emp = new Employee(230, "jammy@gmail.com","James");
		//Message msg = new Message("Kim","Peter",new Date(), "Will meet you during coffee break");
		String employeeXml = generateXML(emp);
		//String messageXml = generateXML(msg);
		System.out.println(employeeXml);
		//System.out.println(messagexml);

	}

	private static String generateXML(Object obj) {

		StringBuilder builder = new StringBuilder();
		
		String classname = obj.getClass().getSimpleName().toLowerCase();
		builder.append("<");
		builder.append(classname);
		builder.append(">");
		builder.append("\n");
		
		Class clazz = obj.getClass();
		Method[] methods = clazz.getDeclaredMethods();
		for(Method m : methods) {
			String mName = m.getName();
			if(mName.startsWith("get")){
				builder.append("<");
				builder.append(mName.substring(3).toLowerCase());
				builder.append(">");
				try {
					builder.append((m.invoke(obj)).toString());
				}catch(Exception e) {
					e.printStackTrace();
				}
				builder.append("</");
				builder.append(mName.substring(3).toLowerCase());
				builder.append(">");
				builder.append("\n");
			}
		}
		builder.append("</");
		builder.append(classname.toLowerCase());
		builder.append(">");
		
		return builder.toString();

	}

}
