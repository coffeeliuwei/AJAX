package com.coffee.jsonbase;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

/**
 * <p>Title: Json2pojo.java</p>  
 * <p>Description: </p>  
 * <p>Copyright: Copyright (c) 2018</p>   
 * @author coffeeliu  
 * @date 2020-3-19  
 * @version 1.0  
 */

/**
 * @author Administrator
 *
 */
public class Json2pojo {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		JsonParser parser = new JsonParser();
		JsonObject object;
		try {
			object = (JsonObject) parser.parse(new FileReader(
					"test.json"));
			Gson gson=new Gson();
			POJO pojo=gson.fromJson(object, POJO.class) ;
			System.out.println(pojo.toString());
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
