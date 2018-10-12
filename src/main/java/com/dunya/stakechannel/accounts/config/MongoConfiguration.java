package com.dunya.stakechannel.accounts.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;

@Configuration
public class MongoConfiguration extends AbstractMongoConfiguration {
	static Logger log = LoggerFactory.getLogger(MongoConfiguration.class);

	@Value("${mongodb.min.connections.per.host:0}")
	private int minConnectionsPerHost;

	@Value("${mongodb.max.connections.per.host:100}")
	private int maxConnectionsPerHost;

	@Value("${mongodb.database.name}")
	private String databaseName;

	@Value("${mongodb.connection.uri}")
	private String host;

	@Override
	public MongoClient mongoClient() {

		MongoClientOptions options = MongoClientOptions.builder().connectionsPerHost(maxConnectionsPerHost)
				.minConnectionsPerHost(minConnectionsPerHost).build();
		MongoClient mongoClient = new MongoClient(host, options);
		log.info(mongoClient.toString());
		return mongoClient;
	}

	@Override
	protected String getDatabaseName() {
		return databaseName;
	}

}
