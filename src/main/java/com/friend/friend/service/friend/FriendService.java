//
// Nghiem Chi Bao
//
package com.friend.friend.service.friend;

import com.friend.friend.repository.friend.FriendRepository;
import com.friend.friend.model.friend.Friend;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class FriendService {
	private final FriendRepository friendRepository;

	public FriendService(FriendRepository friendRepository) {
		this.friendRepository = friendRepository;
	}

	public Flux<Friend> getAllFriends() {
		return friendRepository.findAll();
	}

	public Mono<Friend> getFriendById(String id) {
		return friendRepository.findById(id);
	}

	public Mono<Friend> createFriend(Friend friend) {
		return friendRepository.save(friend);
	}

	public Mono<Friend> updateFriend(String id, Friend updatedFriend) {
		return friendRepository.findById(id)
				.flatMap(friend -> {
					friend.setName(updatedFriend.getName());
					friend.setParent(updatedFriend.getParent());
					friend.setInfo(updatedFriend.getInfo());
					friend.setContact(updatedFriend.getContact());
					return friendRepository.save(friend);
				})
				.switchIfEmpty(Mono.error(new RuntimeException("Friend not found with id " + id)));
	}

	public Mono<Void> deleteFriend(String id) {
		return friendRepository.deleteById(id);
	}
}
