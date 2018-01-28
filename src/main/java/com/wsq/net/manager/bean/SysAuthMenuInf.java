package com.wsq.net.manager.bean;

public class SysAuthMenuInf {

	
	int id;
	
	//菜单ID
	String menu_id;
	//父级菜单的ID
	String parent_id;
	
	//菜单名称
	String menu_name;
	
	//菜单级别
	int menu_level;
	
	//菜单状态  0可用  1不可用
	int menu_state;
	
	//菜单url
	String menu_url;
	
	//菜单类型  0 表示菜单  1表示按钮
	int menu_type;
	
	
	String user_id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMenu_id() {
		return menu_id;
	}

	public void setMenu_id(String menu_id) {
		this.menu_id = menu_id;
	}

	public String getMenu_name() {
		return menu_name;
	}

	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}

	public int getMenu_level() {
		return menu_level;
	}

	public void setMenu_level(int menu_level) {
		this.menu_level = menu_level;
	}

	public int getMenu_state() {
		return menu_state;
	}

	public void setMenu_state(int menu_state) {
		this.menu_state = menu_state;
	}

	public String getMenu_url() {
		return menu_url;
	}

	public void setMenu_url(String menu_url) {
		this.menu_url = menu_url;
	}

	public int getMenu_type() {
		return menu_type;
	}

	public void setMenu_type(int menu_type) {
		this.menu_type = menu_type;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getParent_id() {
		return parent_id;
	}

	public void setParent_id(String parent_id) {
		this.parent_id = parent_id;
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[id = "					+		id+
				", menu_id = "			+		menu_id+
				", parent_id = "			+		parent_id+
				", menu_name = "			+		menu_name+
				", menu_level = "		+		menu_level+
				", menu_state = "		+		menu_state+
				", menu_url = "			+		menu_url+
				", menu_type = "			+		menu_type+
				", user_id = "			+		user_id+
				"]";
	}
	
	
	
}
