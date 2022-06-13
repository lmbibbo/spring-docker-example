package com.example.springdockerexample.repository;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@Configuration
public class MongoConfiguration extends AbstractMongoClientConfiguration{

 /* public @Bean MongoDatabaseFactory mongoDatabaseFactory() {
    return new SimpleMongoClientDatabaseFactory(MongoClients.create(), "database");
  } */

  @Override
  public MongoClient mongoClient() {
      final ConnectionString connectionString = new ConnectionString("mongodb://localhost:27017/mygrocerylist");
      final MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
          .applyConnectionString(connectionString)
          .build();
      return MongoClients.create(mongoClientSettings);
  }
  @Override
  protected String getDatabaseName() {
    return "mygrocerylist";
  }
}