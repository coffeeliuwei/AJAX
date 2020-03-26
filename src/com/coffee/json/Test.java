package com.coffee.json;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coffee.restful.REST;
import com.google.gson.JsonObject;
@WebServlet("/Test")
public class Test extends REST {

	@Override
	protected Object execute(HttpServletRequest request,
			HttpServletResponse response, JsonObject jreq) throws Exception {
		// TODO Auto-generated method stub
		int id = jreq.get("id").getAsInt();
		if(id <= 0)
			throw new Exception("ID必须为正值!");
		
		// 处理
		
		// 应答数据
		Map<String, Object> jresp = new HashMap <String, Object>();
		//JSONObject jresp = new JSONObject();
		jresp.put("id", id);
		jresp.put("name", "liuwei");
		jresp.put("password", "1381515212");
		jresp.put("email", "333@qq.com");
		return jresp;
	}

}
