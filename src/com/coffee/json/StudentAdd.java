package com.coffee.json;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coffee.DB.DB;
import com.coffee.entity.Student;
import com.coffee.restful.REST;
import com.google.gson.JsonObject;

@WebServlet("/StudentAdd")
public class StudentAdd extends REST {

	@Override
	protected Object execute(HttpServletRequest request,
			HttpServletResponse response, JsonObject jreq) throws Exception {
		// TODO Auto-generated method stub
		int id = jreq.get("id").getAsInt();
		String name = jreq.get("name").getAsString();
		boolean sex = jreq.get("sex").getAsBoolean();		
		String cellphone = jreq.get("phone").getAsString();
		
		// 参数检查
		if(id <= 0)
			throw new Exception("ID必须为正值!");
		if(name.length() == 0)
			throw new Exception("姓名不得为空!");
		
		// 保存数据
		Student stu = new Student(id, name, sex, cellphone);
		DB.insert(stu);
		return 111;
	}

}
