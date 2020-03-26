package com.coffee.jsonbase;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * <p>Title: CreatJSON.java</p>  
 * <p>Description: </p>  
 * <p>Copyright: Copyright (c) 2018</p>   
 * @author coffeeliu  
 * @date 2019-2-27  
 * @version 1.0  
 */

/**
 * @author coffeeliu
 * 
 */
public class CreatJSON {
	public static void main(String[] args) {
		JsonObject object = new JsonObject();
		object.addProperty("name", "liuwei");
		JsonArray array = new JsonArray();

		JsonObject a1 = new JsonObject();
		a1.addProperty("id", 1);
		a1.addProperty("skills", "Eclipse");
		a1.addProperty("name", "java");
		array.add(a1);

		JsonObject a2 = new JsonObject();
		a2.addProperty("id", 2);
		a2.addProperty("skills", "VS");
		a2.addProperty("name", "C++");
		array.add(a2);

		JsonObject a3 = new JsonObject();
		a3.addProperty("id", 3);
		a3.addProperty("skills", "VS");
		a3.addProperty("name", "Phyon");
		array.add(a3);

		object.add("skills", array);
		object.addProperty("pop", true);
		System.out.println(object.toString());
	}

}
