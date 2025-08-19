//
// Nghiem Chi Bao
//
package com.friend.friend.repository.friend;

import com.friend.friend.model.friend.Friend;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendRepository extends MongoRepository<Friend, String> {
}
