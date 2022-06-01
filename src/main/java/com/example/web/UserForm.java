package com.example.web;

import java.io.Serializable;

public class UserForm implements Serializable {

	private static final long serialVersionUID = 1L;

	private String userId;
	private String passwd;
	private String passwdConf;

	/**
	 * @return passwdConf
	 */
	public String getPasswdConf() {
		return passwdConf;
	}
	/**
	 * @param passwdConf セットする passwdConf
	 */
	public void setPasswdConf(String passwdConf) {
		this.passwdConf = passwdConf;
	}

	/**
	 * @return userId
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * @param userId セットする userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * @return passwd
	 */
	public String getPasswd() {
		return passwd;
	}
	/**
	 * @param passwd セットする passwd
	 */
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

}
