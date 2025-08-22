package com.friend.friend.repository.base;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BaseRepository<T, ID> {
	Mono<T> save(T entity);
	Mono<T> findById(ID id);
	Flux<T> findAll();
	Mono<Void> deleteById(ID id);
}

