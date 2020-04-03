package com.coffee.json;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coffee.restful.REST;
import com.google.gson.JsonObject;
@WebServlet("/AddUser")
public class AddUser extends REST {

	@Override
	protected Object execute(HttpServletRequest request,
			HttpServletResponse response, JsonObject jreq) throws Exception {
		String name = jreq.get("name").getAsString();
		String password = jreq.get("password").getAsString();
		String email = jreq.get("email").getAsString();
		
		// 后台处理部分 .. 省略 ...
		System.out.println("用户:" + name + ",密码: " + password
				+ ", 邮件: " + email );		

		// 可以返回 null, 或者 int, long, double, String, 或者  JSONObject / JSONArray
		return 123;
	}
	

}
