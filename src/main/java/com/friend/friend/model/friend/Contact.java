//
// Nghiem Chi Bao
//
package com.friend.friend.model.friend;

public class Contact {
	private String FbUrl;
	private  String InsUrl;
	private String phoneNum;
	private String email;

	// Getters & Setters
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getInsUrl() {
		return InsUrl;
	}
	public void setInsUrl(String insUrl) {
		InsUrl = insUrl;
	}

	public String getFbUrl() {
		return FbUrl;
	}
	public void setFbUrl(String fbUrl) {
		FbUrl = fbUrl;
	}
}
