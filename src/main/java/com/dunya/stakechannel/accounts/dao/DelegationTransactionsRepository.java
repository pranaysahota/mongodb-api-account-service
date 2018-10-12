package com.dunya.stakechannel.accounts.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.dunya.stakechannel.accounts.model.DelegationTransaction;

@Repository
public interface DelegationTransactionsRepository extends MongoRepository<DelegationTransaction, String> {
	List<DelegationTransaction> findByAccountNameAndPoolName(String accountName, String poolName);

	List<DelegationTransaction> findByAccountNameAndTimestampGreaterThan(String accountName, long queryTime);

	List<DelegationTransaction> findByAccountName(String accountName);

}