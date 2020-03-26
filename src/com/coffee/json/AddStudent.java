package com.coffee.json;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.coffee.DB.DB;
import com.coffee.entity.Student;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

/**
 * Servlet implementation class AddStudent
 */
@WebServlet("/AddStudent")
public class AddStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 读取请求数据, 转成字符串
				String reqText = readAsText(request.getInputStream(), "UTF-8");
				// 转成 JSON
				Gson jreq=new Gson();
			    Student student=jreq.fromJson(reqText, Student.class);
				Map<String, Object> info = new HashMap <String, Object>();
				try {
					DB.insert(student);
					info.put("error", 0);  
			         info.put("reason", "ok");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					info.put("error", 1);  
			         info.put("reason", e.toString());
				}
				// 返回应答数据
				response.setCharacterEncoding("UTF-8");
				response.setContentType("text/plain");
				Writer writer = response.getWriter();
				writer.write( jreq.toJson(info));
				writer.close();
	}
	public String readAsText(InputStream streamIn, String charset)
			throws IOException 
	{
		ByteArrayOutputStream cache = new ByteArrayOutputStream(1024*16);  
        byte[] data = new byte[1024];  
        while (true)
        {
        	int n = streamIn.read(data); // n: 实际读取的字节数
        	if(n < 0) break; // 连接已经断开
        	if(n == 0) continue; // 数据未完 // TODO: 要防止超时 

        	// 缓存起来
        	cache.write(data, 0, n);        	
        	if(cache.size() > 1024*512) // 上限, 最多读取512K
        		break;
        }  
        
        return cache.toString(charset);
	}
}
