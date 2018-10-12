package com.dunya.stakechannel.accounts.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dunya.stakechannel.accounts.dao.DelegationTransactionsRepository;
import com.dunya.stakechannel.accounts.exception.AccountsServiceException;
import com.dunya.stakechannel.accounts.exception.ErrorResponse;
import com.dunya.stakechannel.accounts.model.DelegationTransaction;
import com.dunya.stakechannel.accounts.model.DelegationTransactionResult;
import com.dunya.stakechannel.accounts.util.Utils;

@RestController
public class DelegationTransactionController {
	private Logger log = LogManager.getLogger(this.getClass().getName());
	@Autowired
	DelegationTransactionsRepository accountDelegationsTxRepository;

	@GetMapping("/{account_name}/delegations")
	public ResponseEntity<DelegationTransactionResult> getAccountDelegationTx(
			@RequestParam(value = "days", required = false) Integer days,
			@PathVariable("account_name") String accountName) {
		List<DelegationTransaction> listOfDelegationTxs;
		try {
			if (days != null) {
				listOfDelegationTxs = accountDelegationsTxRepository.findByAccountNameAndTimestampGreaterThan(
						accountName, Utils.getEpochTimeStampToQuery(days).getStartTime());
				log.debug("Successfully retrieved delegations for account: {}, for days: {}", accountName, days);
			} else {
				listOfDelegationTxs = accountDelegationsTxRepository.findByAccountName(accountName);
				log.debug("Successfully retrieved delegations for account: {}", accountName);
			}
		} catch (Exception e) {
			StringBuilder sb = new StringBuilder();
			sb.append("Error while fetching account delegation transactions, exception is: ").append(e.getMessage());
			log.error(sb.toString());
			throw new AccountsServiceException(sb.toString());
		}
		DelegationTransactionResult delegations = new DelegationTransactionResult();
		delegations.setDelegations(listOfDelegationTxs);
		return new ResponseEntity<DelegationTransactionResult>(delegations, HttpStatus.OK);
	}

	@PostMapping("/{account_name}/delegations")
	public ResponseEntity<ErrorResponse> saveAccountDelegationTx(@PathVariable("account_name") String accountName,
			@Valid @NonNull @RequestBody DelegationTransaction accountDelegationReq) {
		accountDelegationReq.setAccountName(accountName);
		try {
			accountDelegationsTxRepository.save(accountDelegationReq);
			log.debug("Saved delegation transaction for account: {}, with {}", accountName,
					accountDelegationReq.toString());
			ErrorResponse errorResponse = new ErrorResponse();
			errorResponse.setErrorCode(0);
			errorResponse.setErrorMessage("");
			return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.OK);
		} catch (Exception e) {
			StringBuilder sb = new StringBuilder();
			sb.append("Error while saving Account Delegation Tx, Exception: ").append(e.getMessage());
			log.error(sb.toString());
			throw new AccountsServiceException(sb.toString());
		}
	}
}
