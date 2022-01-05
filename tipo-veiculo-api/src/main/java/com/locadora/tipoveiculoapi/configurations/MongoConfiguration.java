package com.locadora.tipoveiculoapi.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoAuditing
@EnableMongoRepositories(basePackages = {"com.locadora.tipoveiculoapi.repositorys"})
public class MongoConfiguration {
}
