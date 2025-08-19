//
// Nghiem Chi Bao
//
package com.friend.friend.service.friend;

import com.friend.friend.repository.friend.FriendRepository;
import com.friend.friend.model.friend.Friend;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FriendService {
	private final FriendRepository friendRepository;

	public FriendService(FriendRepository friendRepository) {
		this.friendRepository = friendRepository;
	}

	public List<Friend> getAllFriends() {
		return friendRepository.findAll();
	}

	public Optional<Friend> getFriendById(String id) {
		return friendRepository.findById(id);
	}

	public Friend createFriend(Friend friend) {
		return friendRepository.save(friend);
	}

	public Friend updateFriend(String id, Friend updatedFriend) {
		return friendRepository.findById(id)
				.map(friend -> {
					friend.setName(updatedFriend.getName());
					friend.setParent(updatedFriend.getParent());
					return friendRepository.save(friend);
				})
				.orElseThrow(() -> new RuntimeException("Friend not found with id " + id));
	}

	public void deleteFriend(String id) {
		friendRepository.deleteById(id);
	}
}
