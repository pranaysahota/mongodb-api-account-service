package com.dunya.stakechannel.accounts.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.dunya.stakechannel.accounts.model.Action;

@Repository
public interface ActionsRepository extends MongoRepository<Action, String> {

	List<Action> findByAccountName(String accountName);
	List<Action> findByAccountNameAndTimestampGreaterThan(String accountName, long start);

}
