package com.dunya.stakechannel.accounts.service;

import java.util.List;

import com.dunya.stakechannel.accounts.model.DelegationStatus;

public interface DelegationStatusAggregatorService {
	List<DelegationStatus> findByAccountNameAndPoolName(String accountName, String poolName);

	List<DelegationStatus> findByAccountNamePoolNameAndDays(String accountName, String poolName, Long queryTimeStamp);

	List<DelegationStatus> findByAccountName(String accountName);

	List<DelegationStatus> findByAccountNameAndDays(String accountName, Long queryTimeStamp);
}