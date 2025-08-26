package com.friend.friend.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.web.reactive.error.ErrorWebExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@Configuration
@Order(-2) // make sure it has high precedence
public class GlobalErrorHandler implements ErrorWebExceptionHandler {

	private final ObjectMapper objectMapper = new ObjectMapper();

	@Override
	public Mono<Void> handle(ServerWebExchange exchange, Throwable ex) {
		// default status
		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
		String message = "Something went wrong";

		// customize based on exception type
		if (ex instanceof IllegalArgumentException) {
			status = HttpStatus.BAD_REQUEST;
			message = ex.getMessage();
		}

		// build JSON response
		Map<String, Object> error = new HashMap<>();
		error.put("status", status.value());
		error.put("error", status.getReasonPhrase());
		error.put("message", message);

		byte[] bytes;
		try {
			bytes = objectMapper.writeValueAsBytes(error);
		} catch (Exception e) {
			bytes = ("{\"error\":\"" + message + "\"}")
					.getBytes(StandardCharsets.UTF_8);
		}

		exchange.getResponse().setStatusCode(status);
		exchange.getResponse().getHeaders().setContentType(MediaType.APPLICATION_JSON);

		return exchange.getResponse()
				.writeWith(Mono.just(exchange.getResponse()
						.bufferFactory()
						.wrap(bytes)));
	}
}