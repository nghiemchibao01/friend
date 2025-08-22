package com.friend.friend.config;

import com.friend.friend.infrastructure.jpa.JpaRepositoryAdapter;
import com.friend.friend.repository.base.BaseRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

@Configuration
@Profile("jpa")
public class JpaConfig {

	@Bean
	public <T> BaseRepository<T, String> jpaRepository(JpaRepository<T, String> repo) {
		return new JpaRepositoryAdapter<>(repo);
	}
}
