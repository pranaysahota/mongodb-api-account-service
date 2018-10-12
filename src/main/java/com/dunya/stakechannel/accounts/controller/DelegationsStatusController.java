package com.dunya.stakechannel.accounts.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dunya.stakechannel.accounts.dao.DelegationTransactionsRepository;
import com.dunya.stakechannel.accounts.exception.AccountsServiceException;
import com.dunya.stakechannel.accounts.model.DelegationStatus;
import com.dunya.stakechannel.accounts.model.DelegationStatusResult;
import com.dunya.stakechannel.accounts.service.DelegationStatusAggregatorService;
import com.dunya.stakechannel.accounts.util.Utils;

@RestController
public class DelegationsStatusController {
	private Logger log = LogManager.getLogger(this.getClass().getName());
	@Autowired
	DelegationTransactionsRepository accountDelegationsTxRepository;

	@Autowired
	DelegationStatusAggregatorService delegationStatusAggregatorService;

	@GetMapping("/{account_name}/delegations/status")
	public ResponseEntity<DelegationStatusResult> getAccountDelegationStatus(
			@RequestParam(value = "pool", required = false) String poolName,
			@RequestParam(value = "days", required = false) Integer days,
			@PathVariable("account_name") String accountName) {
		DelegationStatusResult delegations = new DelegationStatusResult();
		List<DelegationStatus> delegationStatusList;
		try {
			if (days != null && poolName != null) {
				delegationStatusList = delegationStatusAggregatorService.findByAccountNamePoolNameAndDays(accountName,
						poolName, Utils.getEpochTimeStampToQuery(days).getStartTime());
				log.info("Successfully retrieved delegation status for account: {},pool: {}, days: {}", accountName,
						poolName, days);
			} else if (days != null && poolName == null) {
				delegationStatusList = delegationStatusAggregatorService.findByAccountNameAndDays(accountName,
						Utils.getEpochTimeStampToQuery(days).getStartTime());
				log.info("Successfully retrieved delegation status for account: {}, days: {}", accountName, days);
			} else if (days == null && poolName != null) {
				delegationStatusList = delegationStatusAggregatorService.findByAccountNameAndPoolName(accountName,
						poolName);
				log.info("Successfully retrieved delegation status for account: {}, pool: {}", accountName, poolName);

			} else {
				delegationStatusList = delegationStatusAggregatorService.findByAccountName(accountName);
				log.info("Successfully retrieved delegation status for account: {}", accountName);
			}
		} catch (Exception e) {
			StringBuilder sb = new StringBuilder();
			sb.append("Error while getting delegation status. Exception is: ").append(e.getMessage());
			log.error(sb.toString());
			throw new AccountsServiceException(sb.toString());
		}
		delegations.setDelegations(delegationStatusList);
		return new ResponseEntity<DelegationStatusResult>(delegations, HttpStatus.OK);
	}
}
