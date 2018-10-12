package com.dunya.stakechannel.accounts.dao;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.dunya.stakechannel.accounts.model.Account;

@Repository
public interface AccountsRepository extends MongoRepository<Account, String> {
	Optional<Account> findOneByAccountName(String accountName);
}
