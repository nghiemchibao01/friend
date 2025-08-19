package com.friend.friend.config;

import com.mongodb.reactivestreams.client.MongoClients;
import com.mongodb.reactivestreams.client.MongoClient;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;

@Configuration
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
}
