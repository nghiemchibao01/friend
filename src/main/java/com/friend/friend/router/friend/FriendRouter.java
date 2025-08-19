package com.friend.friend.router.friend;

import com.friend.friend.handler.friend.FriendHandler;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class FriendRouter {
	@Bean
	public RouterFunction<ServerResponse> postRoutes(@NotNull FriendHandler handler) {
		return RouterFunctions.route()
				.POST("/friends", handler::createFriend)
				.build();
	}

	@Bean
	public RouterFunction<ServerResponse> getRoutes(@NotNull FriendHandler handler) {
		return RouterFunctions.route()
				.GET("/friends", handler::getAllFriends)
				.GET("/friends/{id}", handler::getFriendById)
				.build();
	}

	@Bean
	public RouterFunction<ServerResponse> putRoutes(@NotNull FriendHandler handler) {
		return RouterFunctions.route()
				.PUT("/friends/{id}", handler::updateFriend)
				.build();
	}

	@Bean
	public RouterFunction<ServerResponse> deleteRoutes(@NotNull FriendHandler handler) {
		return RouterFunctions.route()
				.DELETE("/friends/{id}", handler::deleteFriend)
				.build();
	}
}
