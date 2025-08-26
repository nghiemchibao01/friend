package com.friend.friend.handler.friend;

import com.friend.friend.dto.friend.FriendDTO;
import com.friend.friend.service.friend.FriendService;
import com.friend.friend.dto.friend.FriendMapper;
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

	public Mono<ServerResponse> getAllFriends(@NotNull ServerRequest request) {
		return ServerResponse.ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(friendService
						.getAllFriends()
						.map(FriendMapper::toDTO),
					FriendDTO.class);
	}

	public Mono<ServerResponse> getFriendById(@NotNull ServerRequest request) {
		String id = request.pathVariable("id");
		return friendService.getFriendById(id)
				.map(FriendMapper::toDTO)
				.flatMap(dto -> ServerResponse.ok()
						.contentType(MediaType.APPLICATION_JSON)
						.bodyValue(dto))
				.switchIfEmpty(ServerResponse.notFound().build());
	}

	public Mono<ServerResponse> createFriend(@NotNull ServerRequest request) {
		return request.bodyToMono(FriendDTO.class)
				.map(FriendMapper::toEntity)
				.flatMap(friendService::createFriend)
				.map(FriendMapper::toDTO)
				.flatMap(saved -> ServerResponse.ok()
						.contentType(MediaType.APPLICATION_JSON)
						.bodyValue(saved));
	}

	public Mono<ServerResponse> updateFriend(@NotNull ServerRequest request) {
		String id = request.pathVariable("id");
		return request.bodyToMono(FriendDTO.class)
				.map(FriendMapper::toEntity)
				.flatMap(updated -> friendService.updateFriend(id, updated))
				.map(FriendMapper::toDTO)
				.flatMap(saved -> ServerResponse.ok().bodyValue(saved))
				.switchIfEmpty(ServerResponse.notFound().build());
	}

	public Mono<ServerResponse> deleteFriend(@NotNull ServerRequest request) {
		String id = request.pathVariable("id");
		return friendService.deleteFriend(id)
				.then(ServerResponse.noContent().build());
	}
}