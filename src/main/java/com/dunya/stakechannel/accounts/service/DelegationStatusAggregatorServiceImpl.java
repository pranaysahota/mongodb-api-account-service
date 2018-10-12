package com.dunya.stakechannel.accounts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import com.dunya.stakechannel.accounts.model.DelegationStatus;

@Service
public class DelegationStatusAggregatorServiceImpl implements DelegationStatusAggregatorService {
	@Autowired
	MongoOperations mongoOperations;

	private static final String collectionName = "account_delegation_transactions";

	@Override
	public List<DelegationStatus> findByAccountNameAndPoolName(String accountName, String poolName) {
		Aggregation aggregation = Aggregation.newAggregation(
				Aggregation.match(Criteria.where("accountName").is(accountName).and("poolName").is(poolName)),
				Aggregation.group("poolName").sum("eosDelegatedForCpu").as("totalEosDelegatedForCpu")
						.sum("eosUnDelegatedForCpu").as("totalEosUnDelegatedForCpu").sum("eosDelegatedForNet")
						.as("totalEosDelegatedForNet").sum("eosUnDelegatedForNet").as("totalEosUnDelegatedForNet"));
		AggregationResults<DelegationStatus> delegationResults = mongoOperations.aggregate(aggregation, collectionName,
				DelegationStatus.class);
		delegationResults.forEach(action -> action.setAccountName(accountName));
		return delegationResults.getMappedResults();
	}

	@Override
	public List<DelegationStatus> findByAccountNamePoolNameAndDays(String accountName, String poolName,
			Long queryTimeStamp) {
		Aggregation aggregation = Aggregation.newAggregation(
				Aggregation.match(Criteria.where("accountName").is(accountName).and("timestamp")
						.gte(queryTimeStamp.longValue()).and("poolName").is(poolName)),
				Aggregation.group("poolName", "accountName").sum("eosDelegatedForCpu").as("totalEosDelegatedForCpu")
						.sum("eosUnDelegatedForCpu").as("totalEosUnDelegatedForCpu").sum("eosDelegatedForNet")
						.as("totalEosDelegatedForNet").sum("eosUnDelegatedForNet").as("totalEosUnDelegatedForNet"));
		AggregationResults<DelegationStatus> delegationResults = mongoOperations.aggregate(aggregation, collectionName,
				DelegationStatus.class);
		delegationResults.forEach(action -> action.set_id(poolName));
		return delegationResults.getMappedResults();
	}

	@Override
	public List<DelegationStatus> findByAccountName(String accountName) {
		Aggregation aggregation = Aggregation.newAggregation(
				Aggregation.match(Criteria.where("accountName").is(accountName)),
				Aggregation.group("poolName").sum("eosDelegatedForCpu").as("totalEosDelegatedForCpu")
						.sum("eosUnDelegatedForCpu").as("totalEosUnDelegatedForCpu").sum("eosDelegatedForNet")
						.as("totalEosDelegatedForNet").sum("eosUnDelegatedForNet").as("totalEosUnDelegatedForNet"));
		AggregationResults<DelegationStatus> delegationResults = mongoOperations.aggregate(aggregation, collectionName,
				DelegationStatus.class);
		delegationResults.forEach(action -> action.setAccountName(accountName));
		return delegationResults.getMappedResults();
	}

	@Override
	public List<DelegationStatus> findByAccountNameAndDays(String accountName, Long queryTimeStamp) {
		Aggregation aggregation = Aggregation.newAggregation(
				Aggregation.match(
						Criteria.where("accountName").is(accountName).and("timestamp").gte(queryTimeStamp.longValue())),
				Aggregation.group("poolName").sum("eosDelegatedForCpu").as("totalEosDelegatedForCpu")
						.sum("eosUnDelegatedForCpu").as("totalEosUnDelegatedForCpu").sum("eosDelegatedForNet")
						.as("totalEosDelegatedForNet").sum("eosUnDelegatedForNet").as("totalEosUnDelegatedForNet"));
		AggregationResults<DelegationStatus> delegationResults = mongoOperations.aggregate(aggregation, collectionName,
				DelegationStatus.class);
		delegationResults.forEach(action -> action.setAccountName(accountName));
		return delegationResults.getMappedResults();
	}
}
