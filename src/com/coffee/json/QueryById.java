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
import com.coffee.mysql.util.SqlWhere;
import com.google.gson.Gson;

/**
 * Servlet implementation class QueryById
 */
@WebServlet("/QueryById")
public class QueryById extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryById() {
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
		// 从 request 里取得参数
		String strFrom = request.getParameter("from");
		String strTo = request.getParameter("to");
				
		// 参数处理
		int from = Integer.valueOf( strFrom );
		int to = Integer.valueOf( strTo);
		ArrayList<Map> students = new ArrayList<Map>();
		String sql="select * from student";
		SqlWhere where=new SqlWhere();
		where.add("id",">", from).add("id", "<", to);
		sql=sql+where;
		System.out.println(sql);
		try {
		students=	(ArrayList<Map>) DB.query(sql, 0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Gson jarray = new Gson();
		response.setCharacterEncoding("UTF-8"); /* 设置字符集编码 */
		response.setContentType("text/plain"); /* 设置内容格式 */
		PrintWriter out = response.getWriter();	
		out.write(jarray.toJson(students));	
		System.out.println( jarray.toJson(students) );
	}

}
