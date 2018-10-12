package com.dunya.stakechannel.accounts.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.dunya.stakechannel.accounts.model.Resource;

@Repository
public interface ResourcesRepository extends MongoRepository<Resource, String> {
	List<Resource> findByAccountName(String accountName);
	List<Resource> findByAccountNameAndTimestampGreaterThan(String accountName, long queryTime);
}
