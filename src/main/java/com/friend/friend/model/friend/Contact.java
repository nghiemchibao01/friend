//
// Nghiem Chi Bao
//
package com.friend.friend.model.friend;

import lombok.Data;

@Data
public class Contact {
	private String FbUrl;
	private  String InsUrl;
	private String PhoneNum;
	private String Email;

	public Contact() {}
	public Contact(String insUrl, String phoneNum, String email, String fbUrl) {
		InsUrl = insUrl;
		PhoneNum = phoneNum;
		Email = email;
		FbUrl = fbUrl;
	}
}
