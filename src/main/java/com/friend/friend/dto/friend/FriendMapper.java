package com.friend.friend.dto.friend;

import com.friend.friend.model.friend.*;
import org.jetbrains.annotations.NotNull;

public class FriendMapper {
	public static FriendDTO toDTO(@NotNull Friend friend) {
		var friendContact = friend.getContact();
		var friendParent = friend.getParent();
		var friendInfo = friend.getInfo();
		return new FriendDTO(
				friend.getId(),
				friend.getName(),
				new FriendDTO.ContactDto(
						safe(friendContact, Contact::getFbUrl),
						safe(friendContact, Contact::getInsUrl),
						safe(friendContact, Contact::getPhoneNum),
						safe(friendContact, Contact::getEmail)
				),
				new FriendDTO.ParentDto(
						safe(friendParent, Parent::getFatherName),
						safe(friendParent, Parent::getMotherName)
				),
				new FriendDTO.InfoDto(
						safe(friendInfo, Info::getFullName),
						safe(friendInfo, Info::getNickName),
						safe(friendInfo, Info::getBirthDay),
						safe(friendInfo, Info::getHobby),
						safe(friendInfo, Info::getElementarySchool),
						safe(friendInfo, Info::getMiddleSchool),
						safe(friendInfo, Info::getHighSchool),
						safe(friendInfo, Info::getUniversity)
				)
		);
	}

	public static Friend toEntity(@NotNull FriendDTO dto) {
		var dtoContact = dto.getContactInfo();
		var dtoParent = dto.getParentInfo();
		var dtoInfo = dto.getAdditionalInfo();
		return new Friend(
				dto.getFriendId(),
				dto.getFriendName(),
				new Contact(
						safe(dtoContact, FriendDTO.ContactDto::getFb),
						safe(dtoContact, FriendDTO.ContactDto::getIns),
						safe(dtoContact, FriendDTO.ContactDto::getPhone),
						safe(dtoContact, FriendDTO.ContactDto::getEmail)
				),
				new Parent(
						safe(dtoParent, FriendDTO.ParentDto::getFatherName),
						safe(dtoParent, FriendDTO.ParentDto::getMotherName)
				),
				new Info(
						safe(dtoInfo, FriendDTO.InfoDto::getName),
						safe(dtoInfo, FriendDTO.InfoDto::getNickName),
						safe(dtoInfo, FriendDTO.InfoDto::getBirth),
						safe(dtoInfo, FriendDTO.InfoDto::getHobby),
						safe(dtoInfo, FriendDTO.InfoDto::getElementarySchool),
						safe(dtoInfo, FriendDTO.InfoDto::getMiddleSchool),
						safe(dtoInfo, FriendDTO.InfoDto::getHighSchool),
						safe(dtoInfo, FriendDTO.InfoDto::getUniversity)
				)
		);
	}

	private static  <T, R> R safe(T obj, java.util.function.Function<T, R> extractor) {
		return obj == null ? null : extractor.apply(obj);
	}
}