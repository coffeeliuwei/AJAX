package com.coffee.restful;

/**
 * 通用的异常类,带 error和reason两个属性
 *
 */
public class WebException extends Exception
{
	public int error;
	public String reason;
	
	public WebException()
	{		
	}
	public WebException(int error, String reason)
	{
		this.error = error;
		this.reason = reason;
	}
	@Override
	public String getMessage()
	{
		return reason + "(" + error + ")";
	}
	
	
}
