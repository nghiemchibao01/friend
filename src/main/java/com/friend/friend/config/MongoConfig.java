package com.friend.friend.config;

import com.friend.friend.infrastructure.mongo.MongoRepositoryAdapter;
import com.friend.friend.repository.base.BaseRepository;
import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;

@Configuration
@Profile("mongo")
public class MongoConfig {

	@Bean
	public MongoClient reactiveMongoClient() {
		Dotenv dotenv = Dotenv.load();
		String uri = dotenv.get("MONGODB_URI","");
		return MongoClients.create(uri);
	}

	@Bean
	public ReactiveMongoTemplate reactiveMongoTemplate(MongoClient mongoClient) {
		Dotenv dotenv = Dotenv.load();
		String dbName = dotenv.get("MONGODB_DBNAME", "");
		return new ReactiveMongoTemplate(mongoClient, dbName);
	}

	@Bean
	public <T> BaseRepository<T, String> mongoRepository(ReactiveMongoOperations mongoOps, Class<T> type) {
		return new MongoRepositoryAdapter<>(mongoOps, type);
	}
}
