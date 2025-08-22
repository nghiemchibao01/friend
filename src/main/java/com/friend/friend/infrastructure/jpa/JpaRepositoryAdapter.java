package com.friend.friend.infrastructure.jpa;

import com.friend.friend.repository.base.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Repository
@Profile("jpa")
public class JpaRepositoryAdapter<T> implements BaseRepository<T, String> {

	private final JpaRepository<T, String> repo;

	public JpaRepositoryAdapter(JpaRepository<T, String> repo) {
		this.repo = repo;
	}

	@Override
	public Mono<T> save(T entity) {
		return Mono.fromCallable(() -> repo.save(entity))
				.subscribeOn(Schedulers.boundedElastic());
	}

	@Override
	public Mono<T> findById(String id) {
		return Mono.fromCallable(() -> repo.findById(id))
				.flatMap(opt -> opt.map(Mono::just).orElse(Mono.empty()))
				.subscribeOn(Schedulers.boundedElastic());
	}

	@Override
	public Flux<T> findAll() {
		return Mono.fromCallable(repo::findAll)
				.flatMapMany(Flux::fromIterable)
				.subscribeOn(Schedulers.boundedElastic());
	}

	@Override
	public Mono<Void> deleteById(String id) {
		return Mono.fromRunnable(() -> repo.deleteById(id))
				.subscribeOn(Schedulers.boundedElastic())
				.then();
	}
}
