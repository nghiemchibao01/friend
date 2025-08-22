//
// Nghiem Chi Bao
//
package com.friend.friend.model.friend;

import lombok.Data;

@Data
public class Parent {
	private String FatherName;
	private String MotherName;

	public Parent() {}
	public Parent(String fatherName, String motherName) {
		FatherName = fatherName;
		MotherName = motherName;
	}
}
