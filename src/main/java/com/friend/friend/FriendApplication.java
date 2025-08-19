//
// Nghiem Chi Bao
//
package com.friend.friend;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FriendApplication {

	public static void main(String[] args) {
		var env = Dotenv.load();
		var mongoDbUri = env.get("MONGODB_URI", "");

		System.setProperty("MONGODB_URI", mongoDbUri);
		SpringApplication.run(FriendApplication.class, args);
	}

}
