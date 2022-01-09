package com.locadora.locacaoapi.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoAuditing
@EnableMongoRepositories(basePackages = {"com.locadora.locacaoapi.repositorys"})
public class MongoConfiguration {
    public MongoConfiguration() {
    }
}
