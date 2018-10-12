package com.dunya.stakechannel.accounts.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.dunya.stakechannel.accounts.model.Bill;

public interface BillsRepository extends MongoRepository<Bill, String> {
}
