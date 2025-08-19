package com.friend.friend.dto.friend;

import com.friend.friend.model.friend.Contact;
import com.friend.friend.model.friend.Parent;
import com.friend.friend.model.friend.Info;

public class FriendDTO {
	private String friendId;
	private String fullName;
	private Contact contactInfo;
	private Parent parentInfo;
	private Info additionalInfo;

	// Getters & Setters
	public String getFriendId() { return friendId; }
	public void setFriendId(String friendId) { this.friendId = friendId; }

	public String getFullName() { return fullName; }
	public void setFullName(String fullName) { this.fullName = fullName; }

	public Contact getContactInfo() { return contactInfo; }
	public void setContactInfo(Contact contactInfo) { this.contactInfo = contactInfo; }

	public Info getAdditionalInfo() { return additionalInfo; }
	public void setAdditionalInfo(Info additionalInfo) { this.additionalInfo = additionalInfo; }

	public Parent getParentInfo() { return parentInfo; }
	public void setParentInfo(Parent parentInfo) { this.parentInfo = parentInfo; }
}
