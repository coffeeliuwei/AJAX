package com.coffee.jsonbase;
import java.util.List;

/**
 * <p>
 * Title: pojo.java
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2018
 * </p>
 * 
 * @author coffeeliu
 * @date 2020-3-19
 * @version 1.0
 */
public class POJO {
	private String name;
	private List<Skills> skills;
	private boolean pop;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Skills> getSkills() {
		return skills;
	}

	public void setSkills(List<Skills> skills) {
		this.skills = skills;
	}

	public boolean isPop() {
		return pop;
	}

	public void setPop(boolean pop) {
		this.pop = pop;
	}

	@Override
	public String toString() {
		return "POJO [name=" + name + ", skills=" + skills + ", pop=" + pop
				+ "]";
	}

}

class Skills {
	private int id;
	private String skills;
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Skills [id=" + id + ", skills=" + skills + ", name=" + name
				+ "]";
	}
}