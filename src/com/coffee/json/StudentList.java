package com.coffee.json;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coffee.DB.DB;
import com.coffee.restful.REST;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
@WebServlet("/StudentList")
public class StudentList extends REST {

	@Override
	protected Object execute(HttpServletRequest request,
			HttpServletResponse response, JsonObject jreq) throws Exception {
		// TODO Auto-generated method stub
		//Gson jresp = new Gson();
		
		
		return DB.query("select * from student", 0);
		
	}

}
