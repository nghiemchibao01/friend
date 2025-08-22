//
// Nghiem Chi Bao
//
package com.friend.friend.model.friend;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "friends")
public class Friend {
	@Id
	private String Id;
	private String Name;
	private Contact Contact;
	private Parent Parent;
	private Info Info;

	public Friend() {}
	public Friend(String id, String name, Contact contact, Parent parent, Info info) {
		Id = id;
		Name = name;
		Contact = contact;
		Parent = parent;
		Info = info;
	}
}
