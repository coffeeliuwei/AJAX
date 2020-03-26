package com.coffee.json;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coffee.DB.DB;
import com.coffee.mysql.util.SqlWhere;
import com.google.gson.Gson;

/**
 * Servlet implementation class QueryByName
 */
@WebServlet("/QueryByName")
public class QueryByName extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryByName() {
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
        String filter = request.getParameter("filter");
       String string= new String(filter.getBytes("ISO8859-1"), "utf-8");
        //filter= URLDecoder.decode(filter, "UTF-8");
        System.out.println(string);		
		ArrayList<Map> students = new ArrayList<Map>();
		String sql="select * from student";
		SqlWhere where=new SqlWhere();
		where.addLike("name", "%"+string+"%");
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
