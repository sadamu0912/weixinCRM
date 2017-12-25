package com.xjxspace.model;

import java.util.Date;

public class User {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 姓名
     */
    private String username;

    /**
     * 生日
     */
    private String password;

    /**
     * 地址
     */
    private Integer enable;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getEnable() {
		return enable;
	}

	public void setEnable(Integer enable) {
		this.enable = enable;
	}

   
}
