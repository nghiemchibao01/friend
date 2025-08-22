package com.friend.friend.infrastructure.r2dbc;

import com.friend.friend.repository.base.BaseRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.data.relational.core.query.Criteria.where;
import static org.springframework.data.relational.core.query.Query.query;

@Repository
@Profile("r2dbc")
public class R2dbcRepositoryAdapter<T> implements BaseRepository<T, String> {

	private final R2dbcEntityTemplate template;
	private final Class<T> type;

	public R2dbcRepositoryAdapter(R2dbcEntityTemplate template, Class<T> type) {
		this.template = template;
		this.type = type;
	}

	@Override
	public Mono<T> save(T entity) { return template.insert(entity); }

	@Override
	public Mono<T> findById(String id) {
		return template.select(type)
				.matching(query(where("id").is(id)))
				.one();
	}

	@Override
	public Flux<T> findAll() { return template.select(type).all(); }

	@Override
	public Mono<Void> deleteById(String id) {
		return findById(id).flatMap(e -> template.delete(e).then());
	}
}
