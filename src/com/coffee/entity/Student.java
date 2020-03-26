package com.coffee.entity;

import java.util.Date;

import com.coffee.mysql.annotation.COLUMNS;
import com.coffee.mysql.annotation.TABLE;

/* POJO类，与数据库表中的字段一一对应 
 * 1 类名与表名一致
 * 2 属性与表字段一致
 *   - 属性的名称与表字段名相同
 *   - 属性的类型与表字段属性一致，且使用包装类型，如 Long, Integer等
 * 3 生成 Getter/Setter方法
 */
@TABLE(name="Student")
@COLUMNS(generated="id")
public class Student
{
	public Integer id;   
	public String name;
	public Boolean sex;
	public String phone;
	public Date birthday;
	
	public Student(int id, String name, boolean sex, String phone)
	{
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.phone = phone;
	}
	public Integer getId()
	{
		return id;
	}
	public void setId(Integer id)
	{
		this.id = id;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public Boolean getSex()
	{
		return sex;
	}
	public void setSex(Boolean sex)
	{
		this.sex = sex;
	}
	public String getPhone()
	{
		return phone;
	}
	public void setPhone(String phone)
	{
		this.phone = phone;
	}
	public Date getBirthday()
	{
		return birthday;
	}
	public void setBirthday(Date birthday)
	{
		this.birthday = birthday;
	}
	

	
}
