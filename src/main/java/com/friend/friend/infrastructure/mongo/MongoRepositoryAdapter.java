package com.friend.friend.infrastructure.mongo;

import com.friend.friend.repository.base.BaseRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
@Profile("mongo")
public class MongoRepositoryAdapter<T> implements BaseRepository<T, String> {

	private final ReactiveMongoOperations mongoOps;
	private final Class<T> type;

	public MongoRepositoryAdapter(ReactiveMongoOperations mongoOps, Class<T> type) {
		this.mongoOps = mongoOps;
		this.type = type;
	}

	@Override
	public Mono<T> save(T entity) { return mongoOps.save(entity); }

	@Override
	public Mono<T> findById(String id) { return mongoOps.findById(id, type); }

	@Override
	public Flux<T> findAll() { return mongoOps.findAll(type); }

	@Override
	public Mono<Void> deleteById(String id) {
		return mongoOps.findById(id, type)
				.flatMap(e -> mongoOps.remove(e).then());
	}
}
