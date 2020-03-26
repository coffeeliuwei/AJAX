package com.coffee.json;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import com.coffee.DB.DB;
import com.coffee.entity.Student;
import com.google.gson.Gson;
import com.google.gson.stream.JsonWriter;

/**
 * Servlet implementation class studentQuery
 */
@WebServlet("/studentQuery")
public class studentQuery extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public studentQuery() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Map> students = new ArrayList<Map>();
		String sql="select * from student";
		try {
		students=	(ArrayList<Map>) DB.query(sql, 0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Gson jarray = new Gson();
		JSONArray jarray1 = new JSONArray(students);  
		// 
		response.setCharacterEncoding("UTF-8"); /* 设置字符集编码 */
		response.setContentType("text/plain"); /* 设置内容格式 */
		
		PrintWriter out = response.getWriter();	
	//	out.write(jarray.toJson(students));	
	//	System.out.println( jarray.toJson(students) );
        out.write(jarray1.toString());
		System.out.println( jarray1.toString() );
	}

}
