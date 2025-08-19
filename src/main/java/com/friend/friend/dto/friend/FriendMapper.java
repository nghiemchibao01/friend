package com.friend.friend.dto.friend;


import com.friend.friend.model.friend.Friend;
import com.friend.friend.model.friend.Contact;
import com.friend.friend.model.friend.Parent;
import com.friend.friend.model.friend.Info;
import org.jetbrains.annotations.NotNull;

public class FriendMapper {
	public FriendDTO toDTO(@NotNull Friend friend) {
		FriendDTO dto = new FriendDTO();
		dto.setFriendId(friend.getId());
		dto.setFullName(friend.getName());
		dto.setContactInfo(friend.getContact());
		dto.setParentInfo(friend.getParent());
		dto.setAdditionalInfo(friend.getInfo());
		return dto;
	}

	public Friend toEntity(@NotNull FriendDTO dto) {
		Friend friend = new Friend();
		friend.setId(dto.getFriendId());
		friend.setName(dto.getFullName());
		friend.setContact(dto.getContactInfo());
		friend.setParent(dto.getParentInfo());
		friend.setInfo(dto.getAdditionalInfo());
		return friend;
	}
}
