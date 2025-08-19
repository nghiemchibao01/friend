package com.friend.friend.handler.friend;

import com.friend.friend.model.friend.Friend;
import com.friend.friend.service.friend.FriendService;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class FriendHandler {
	private final FriendService friendService;

	public FriendHandler(FriendService friendService) {
		this.friendService = friendService;
	}

	public Mono<ServerResponse> getAllFriends(ServerRequest request) {
		return ServerResponse.ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(friendService.getAllFriends(), Friend.class);
	}

	public Mono<ServerResponse> getFriendById(@NotNull ServerRequest request) {
		String id = request.pathVariable("id");
		return friendService.getFriendById(id)
				.flatMap(friend -> ServerResponse.ok()
					.contentType(MediaType.APPLICATION_JSON)
					.bodyValue(friend))
				.switchIfEmpty(ServerResponse.notFound().build());
	}

	public Mono<ServerResponse> createFriend(@NotNull ServerRequest request) {
		return request.bodyToMono(Friend.class)
				.flatMap(friendService::createFriend)
				.flatMap(saved -> ServerResponse.ok()
					.contentType(MediaType.APPLICATION_JSON)
					.bodyValue(saved));
	}

	public Mono<ServerResponse> updateFriend(@NotNull ServerRequest request) {
		String id = request.pathVariable("id");
		return request.bodyToMono(Friend.class)
				.flatMap(updated -> friendService.updateFriend(id, updated))
				.flatMap(saved -> ServerResponse.ok().bodyValue(saved))
				.switchIfEmpty(ServerResponse.notFound().build());
	}

	public Mono<ServerResponse> deleteFriend(@NotNull ServerRequest request) {
		String id = request.pathVariable("id");
		return friendService.deleteFriend(id)
				.then(ServerResponse.noContent().build());
	}
}
