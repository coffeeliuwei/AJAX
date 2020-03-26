package com.coffee.jsonbase;
import java.util.ArrayList;
import java.util.List;

import javax.print.attribute.standard.Sides;

import com.google.gson.Gson;

/**
 * <p>Title: pojo2json.java</p>  
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
public class pojo2json {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		POJO pojo=new POJO();
		List<Skills> skills=new ArrayList<Skills>();
		Skills skill=new Skills();
		skill.setId(1);
		skill.setName("java");
		skill.setSkills("eclipe");
		skills.add(skill);
		skill.setId(2);
		skill.setName("VS");
		skill.setSkills("C++");
		skills.add(skill);
		skill.setId(3);
		skill.setName("VS");
		skill.setSkills("python");
		skills.add(skill);
		pojo.setName("liuwei");
		pojo.setSkills(skills);
		pojo.setPop(true);
		Gson gson=new Gson();
		System.out.println(gson.toJson(pojo));
	}

}
