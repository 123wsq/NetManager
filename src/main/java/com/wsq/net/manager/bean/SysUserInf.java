package com.wsq.net.manager.bean;

/**
 * 系统用户
 * @author wsq
 *
 */
public class SysUserInf {

	private int id;
	
	private String sysUserName;
	
	private String sysUserPwd;
	
	private String sysCreateTime;
	
	private String sysLastTime;
	
	private int sysLoginCount;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSysUserName() {
		return sysUserName;
	}

	public void setSysUserName(String sysUserName) {
		this.sysUserName = sysUserName;
	}

	public String getSysUserPwd() {
		return sysUserPwd;
	}

	public void setSysUserPwd(String sysUserPwd) {
		this.sysUserPwd = sysUserPwd;
	}

	public String getSysCreateTime() {
		return sysCreateTime;
	}

	public void setSysCreateTime(String sysCreateTime) {
		this.sysCreateTime = sysCreateTime;
	}

	public String getSysLastTime() {
		return sysLastTime;
	}

	public void setSysLastTime(String sysLastTime) {
		this.sysLastTime = sysLastTime;
	}

	public int getSysLoginCount() {
		return sysLoginCount;
	}

	public void setSysLoginCount(int sysLoginCount) {
		this.sysLoginCount = sysLoginCount;
	}
	
	
}
