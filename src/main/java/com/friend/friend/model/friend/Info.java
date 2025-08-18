package com.friend.friend.model.friend;

import java.time.LocalDate;

public class Info {
	private  String fullName;
	private String nickName;
	private LocalDate birthday;
	private String hobby;
	private String elementarySchool;
	private String middleSchool;
	private String highSchool;
	private String university;

	// Getters & Setters
	public String getFullName() { return fullName; }
	public void setFullName(String fullName) { this.fullName = this.fullName; }

	public String getNickName() { return nickName; }
	public void setNickName(String nickName) { this.nickName = this.nickName; }

	public LocalDate getBirthday() { return birthday; }
	public void setBirthday(LocalDate birthday) { this.birthday = birthday; }

	public String getHobby() { return hobby; }
	public void setHobby(String hobby) { this.hobby = hobby; }

	public String getElementarySchool() { return elementarySchool; }
	public void setElementarySchool(String elementarySchool) { this.elementarySchool = elementarySchool; }

	public String getMiddleSchool() { return middleSchool; }
	public void setMiddleSchool(String middleSchool) { this.middleSchool = middleSchool; }

	public String getHighSchool() { return highSchool; }
	public void setHighSchool(String highSchool) { this.highSchool = highSchool; }

	public String getUniversity() { return university; }
	public void setUniversity(String university) { this.university = university; }

	// Methods
	public int calculateAge() {
		return DateUtils.calculateAge(birthday);
	}
}
