package com.dunya.stakechannel.accounts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import com.dunya.stakechannel.accounts.model.BillResult;

@Service
public class BillServiceImpl implements BillService {
	private static final String collectionName = "account_bills";
	@Autowired
	MongoOperations mongoOperations;

	@Override
	public BillResult calculateBillByDays(String accountName, Long queryTime) {

		Aggregation aggregation = Aggregation.newAggregation(
				Aggregation.match(Criteria.where("accountName").is(accountName).and("timestamp").gte(queryTime)),
				Aggregation.group("accountName").sum("$cpuBill").as("totalCpuBill").sum("$netBill").as("totalNetBill"));
		AggregationResults<BillResult> billResult = mongoOperations.aggregate(aggregation, collectionName,
				BillResult.class);
		billResult.forEach(action -> action.setAccountName(accountName));
		if (billResult.getMappedResults().size() == 0)
			return new BillResult(); // empty Object -> bill value is empty
		return billResult.getMappedResults().get(0);

	}

	@Override
	public BillResult calculateBill(String accountName) {
		Aggregation aggregation = Aggregation.newAggregation(
				Aggregation.match(Criteria.where("accountName").is(accountName)),
				Aggregation.group("accountName").sum("$cpuBill").as("totalCpuBill").sum("$netBill").as("totalNetBill"));
		AggregationResults<BillResult> billResult = mongoOperations.aggregate(aggregation, collectionName,
				BillResult.class);
		billResult.forEach(action -> action.setAccountName(accountName));
		if (billResult.getMappedResults().size() == 0)
			return new BillResult(); // empty Object -> bill value is empty
		return billResult.getMappedResults().get(0);
	}

}
