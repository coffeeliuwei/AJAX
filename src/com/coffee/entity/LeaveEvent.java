package com.coffee.entity;

import java.util.Date;

import com.coffee.mysql.annotation.COLUMNS;
import com.coffee.mysql.annotation.TABLE;

/** POJO类，本类不需要手写， 后面会提供专门的生成器
 * 
 *
 */

@TABLE(name="leave_event")
@COLUMNS(generated="id")
public class LeaveEvent
{
	public Long id;
	public Integer stuId;
	public Date daysFrom;
	public Date daysTo;
	public Byte type;
	public String reason;
	
	
	public Long getId()
	{
		return id;
	}
	public void setId(Long id)
	{
		this.id = id;
	}
	public Integer getStuId()
	{
		return stuId;
	}
	public void setStuId(Integer stuId)
	{
		this.stuId = stuId;
	}
	public Date getDaysFrom()
	{
		return daysFrom;
	}
	public void setDaysFrom(Date daysFrom)
	{
		this.daysFrom = daysFrom;
	}
	public Date getDaysTo()
	{
		return daysTo;
	}
	public void setDaysTo(Date daysTo)
	{
		this.daysTo = daysTo;
	}
	public Byte getType()
	{
		return type;
	}
	public void setType(Byte type)
	{
		this.type = type;
	}
	public String getReason()
	{
		return reason;
	}
	public void setReason(String reason)
	{
		this.reason = reason;
	}
	
	
}
