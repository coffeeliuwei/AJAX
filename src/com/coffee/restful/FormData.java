package com.coffee.restful;

import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

/**
 * 用于解析存储表单文本  
 * 对于HTTP GET, 可以从URL里读取 Query参数
 * 对于HTTP POST, 可以从HTTP 正文里读取数据
 *
 */
public class FormData extends HashMap<String, String>
{
	public FormData()
	{		
	}
	
	// 解析query字会串
	public static FormData parse( String query, String charset)
	{
		FormData result = new FormData();
		if (query == null)	return result; 

		String[] ppp = query.split("&"); // 用&分隔
		for (String p : ppp)
		{
			String[] kv = p.split("="); // key=value
			String key = kv[0];
			String value = "";
			if (key.length() > 1)
				value = kv[1]; // 有时候参数里传的是空值
			if (charset != null && value.indexOf('%') >= 0)
			{
				// 如果存在百分号, 则进行URL解码
				try
				{
					value = URLDecoder.decode(value, charset);
				} catch (Exception e)
				{
					System.out.println("** URL解码出错: " 
							+ key + ", " + value 
							+ ", ERROR" + e.getMessage());
				}
			}
			result.put(key, value);
		}
		return result;
	}
	
	// 从参数中取值
	public int getInt(String key, int defValue)
	{
		try
		{
			return Integer.valueOf(this.get(key));
		} catch (Exception e)
		{
			return defValue;
		}
	}

	public long getLong(String key, long defValue)
	{
		try
		{
			return Long.valueOf(this.get(key));
		} catch (Exception e)
		{
			return defValue;
		}
	}

	public String getString(String key, String defValue)
	{
		try
		{
			String val = this.get(key);
			if (val != null)
				return val;
		} catch (Exception e)
		{
		}
		return defValue;
	}

	public boolean getBoolean(String key, boolean defValue)
	{
		try
		{
			return Boolean.valueOf(this.get(key));
		} catch (Exception e)
		{
			return defValue;
		}
	}
}
