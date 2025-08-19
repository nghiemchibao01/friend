package com.friend.friend.dto.friend;

import lombok.Data;

import java.time.LocalDate;

@Data
public class FriendDTO {
	private String friendId;
	private String friendName;
	private ContactDto contactInfo;
	private ParentDto parentInfo;
	private InfoDto additionalInfo;

	public FriendDTO() {
	}
	public FriendDTO(
			String friendId,
			String friendName,
			ContactDto contactInfo,
			ParentDto parentInfo,
			InfoDto additionalInfo) {
		this.friendId = friendId;
		this.friendName = friendName;
		this.contactInfo = contactInfo;
		this.parentInfo = parentInfo;
		this.additionalInfo = additionalInfo;
	}

	@Data
	public static class ContactDto {
		private String fb;
		private String ins;
		private String phone;
		private String email;

		public ContactDto() {}
		public ContactDto(
				String fb,
				String ins,
				String phone,
				String email) {
			this.fb = fb;
			this.ins = ins;
			this.phone = phone;
			this.email = email;
		}
	}

	@Data
	public static class ParentDto {
		private String fatherName;
		private String motherName;

		public ParentDto() {}
		public ParentDto(String fatherName, String motherName) {
			this.fatherName = fatherName;
			this.motherName = motherName;
		}
	}

	@Data
	public static class InfoDto {
		private  String name;
		private String nickName;
		private LocalDate birth;
		private String hobby;
		private String elementarySchool;
		private String middleSchool;
		private String highSchool;
		private String university;

		public InfoDto() {}
		public InfoDto(
				String name,
				String nickName,
				LocalDate birth,
				String hobby,
				String elementarySchool,
				String middleSchool,
				String highSchool,
				String university) {
			this.name = name;
			this.nickName = nickName;
			this.birth = birth;
			this.hobby = hobby;
			this.elementarySchool = elementarySchool;
			this.middleSchool = middleSchool;
			this.highSchool = highSchool;
			this.university = university;
		}
	}
}