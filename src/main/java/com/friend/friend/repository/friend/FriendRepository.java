//
// Nghiem Chi Bao
//
package com.friend.friend.repository.friend;

import com.friend.friend.model.friend.Friend;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendRepository extends ReactiveMongoRepository<Friend, String> {
}
