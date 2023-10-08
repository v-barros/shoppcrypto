package com.shoppcrypto.shoppcrypto;

import com.mongodb.client.MongoClients;
import com.shoppcrypto.shoppcrypto.model.Person;
import com.shoppcrypto.shoppcrypto.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.springframework.data.mongodb.core.query.Criteria.where;

@SpringBootApplication
public class ShoppcryptoApplication {

	public static void main(String[] args) {
		MongoOperations mongoOps = new MongoTemplate(new SimpleMongoClientDatabaseFactory(MongoClients.create(), "shoppcrypto_dev"));

	//	mongoOps.insert(new Person("Joe", 34));

	//	mongoOps.dropCollection("person");
		SpringApplication.run(ShoppcryptoApplication.class, args);
	}
	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder(11);
	}
}
