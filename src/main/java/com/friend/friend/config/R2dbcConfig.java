package com.friend.friend.config;

import com.friend.friend.infrastructure.r2dbc.R2dbcRepositoryAdapter;
import com.friend.friend.repository.base.BaseRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;

@Configuration
@Profile("r2dbc")
public class R2dbcConfig {

	@Bean
	public <T> BaseRepository<T, String> r2dbcRepository(R2dbcEntityTemplate template, Class<T> type) {
		return new R2dbcRepositoryAdapter<>(template, type);
	}
}
