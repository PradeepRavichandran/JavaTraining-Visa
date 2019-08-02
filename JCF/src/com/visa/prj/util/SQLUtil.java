package com.visa.prj.util;
import java.lang.reflect.Method;

import com.visa.prj.annotations.Column;
import com.visa.prj.annotations.Table;

public class SQLUtil {

	public static String generateCreateSQL(Class<?> clazz) {
		StringBuilder builder = new StringBuilder(); //builder used as its just a  local var inside method
		Table t = clazz.getAnnotation(Table.class);
		if(t != null) {
			builder.append("create table");
			builder.append(" ");
			builder.append(t.name());
			builder.append("(");
			
			Method[] methods = clazz.getDeclaredMethods();
			for(Method m : methods) {
				if(m.getName().startsWith("get")) {
					Column c = m.getAnnotation(Column.class);
					if(c != null) {
						builder.append(c.name());
						builder.append(" ");
						builder.append(c.type());
						builder.append(",");
					}
				}
			}
			
		}
		//create table products(prd_id NUMERIC(12), prd_name VARCHAR(150),
		builder.setCharAt(builder.lastIndexOf(","), (')')); //find last occurrence of ',' and replace with ')'
		
		//create table products(prd_id NUMERIC(12), prd_name VARCHAR(150))
		return builder.toString();   //getMethods() can get the methods in any order
	}
	
	//insert into products values(120, 'iPhone XR');
	//insert into emp values(3, 'Smith');
	public static String generateInsertSQL(Object obj) {
		StringBuilder builder = new StringBuilder();
		
		Table t = obj.getClass().getAnnotation(Table.class);
		if(t != null) {
			builder.append("insert into");
			builder.append(" ");
			builder.append(t.name());
			builder.append(" ");
			builder.append("values(");
		
			Method[] methods = obj.getClass().getDeclaredMethods();
			for(Method m : methods) {
				if(m.getName().startsWith("get")) {
					Column c = m.getAnnotation(Column.class);
					if(c!=null) {
						try {		
						builder.append(c.name());
						builder.append("=");
						builder.append(m.invoke(obj));
						builder.append(",");
					}catch(Exception e) {
						e.printStackTrace();
					}
					}
				}
			}
		}

		builder.setCharAt(builder.lastIndexOf(","), (')'));	
		return builder.toString();
		
	}
}



