package com.coffee.jsonbase;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.eclipse.jdt.internal.compiler.ast.ThisReference;

import com.google.gson.JsonArray;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

/**
 * <p>Title: ReadJSON.java</p>  
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
public class ReadJSON {
	public static void main(String[] args) {
		JsonParser parser = new JsonParser();
		try {
			
			JsonObject object = (JsonObject) parser.parse(new FileReader(
					"test.json"));
			System.out.println("name=" + object.get("name").getAsString());
			System.out.println("pop=" + object.get("pop").getAsBoolean());

			JsonArray array = object.get("skills").getAsJsonArray();
			for (int i = 0; i < array.size() - 1; i++) {
				System.out.println("----------");
				JsonObject subobject = array.get(i).getAsJsonObject();
				System.out.println("id=" + subobject.get("id").getAsInt());
				System.out.println("skills="
						+ subobject.get("skills").getAsString());
				System.out.println("name="
						+ subobject.get("name").getAsString());
			}
		} catch (JsonIOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonSyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
