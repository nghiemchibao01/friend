//
// Nghiem Chi Bao
//
package com.friend.friend.model.friend;

import java.time.LocalDate;
import lombok.Data;
import com.friend.friend.utils.DateUtils;

@Data
public class Info {
	private  String FullName;
	private String NickName;
	private LocalDate BirthDay;
	private String Hobby;
	private String ElementarySchool;
	private String MiddleSchool;
	private String HighSchool;
	private String University;

	public Info() {}

	public Info(
			String fullName,
			String nickName,
			LocalDate birthDay,
			String hobby,
			String elementarySchool,
			String middleSchool,
			String highSchool,
			String university) {
		FullName = fullName;
		NickName = nickName;
		BirthDay = birthDay;
		Hobby = hobby;
		ElementarySchool = elementarySchool;
		MiddleSchool = middleSchool;
		HighSchool = highSchool;
		University = university;
	}

	// Methods
	public int calculateAge() {
		return DateUtils.calculateAge(BirthDay);
	}
}