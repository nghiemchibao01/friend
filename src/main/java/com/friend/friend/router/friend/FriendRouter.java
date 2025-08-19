package com.friend.friend.router.friend;

import com.friend.friend.handler.friend.FriendHandler;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class FriendRouter {
	@Bean
	public RouterFunction<ServerResponse> friendRoutes(@NotNull FriendHandler handler) {
		return route(GET("/friends"), handler::getAllFriends)
				.andRoute(GET("/friends/{id}"), handler::getFriendById)
				.andRoute(POST("/friends"), handler::createFriend)
				.andRoute(PUT("/friends/{id}"), handler::updateFriend)
				.andRoute(DELETE("/friends/{id}"), handler::deleteFriend);
	}
}
