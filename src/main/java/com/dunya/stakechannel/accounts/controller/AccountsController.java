package com.dunya.stakechannel.accounts.controller;

import java.util.Optional;

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
import org.springframework.web.bind.annotation.RestController;

import com.dunya.stakechannel.accounts.dao.AccountsRepository;
import com.dunya.stakechannel.accounts.exception.AccountCreationException;
import com.dunya.stakechannel.accounts.exception.AccountNotFoundException;
import com.dunya.stakechannel.accounts.exception.AccountsServiceException;
import com.dunya.stakechannel.accounts.exception.ErrorResponse;
import com.dunya.stakechannel.accounts.model.Account;

@RestController
public class AccountsController {

	private Logger log = LogManager.getLogger(this.getClass().getName());

	@Autowired
	AccountsRepository accountsRepository;

	@GetMapping("/{account_name}")
	public ResponseEntity<Account> getAccount(@PathVariable("account_name") String accountName) {
		Optional<Account> account;

		try {
			log.debug("Retrieving account details for {} from mongo", accountName);
			account = accountsRepository.findOneByAccountName(accountName);
			if (!account.isPresent()) {
				log.error("Account details not found for account for {}", accountName);
				throw new AccountNotFoundException("Account Data not found for account for " + accountName);
			}
		} catch (Exception e) {
			StringBuilder sb = new StringBuilder();
			sb.append("Error while fetching account. Exception is: ").append(e.getMessage());
			log.error(sb.toString());
			throw new AccountsServiceException(sb.toString());
		}
		return new ResponseEntity<Account>(account.get(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<ErrorResponse> saveAccount(@Valid @RequestBody @NonNull Account account) {
		log.debug("Received account details for {}  to store in mongo.", account.getAccountName());
		account.setScore(100);
		log.debug("Updated score for account: {} details to store in mongo with value:{}", account.getAccountName(),
				account.getScore());
		try {
			accountsRepository.save(account);
			log.info("Successfully saved: {}", account.toString());
			ErrorResponse errorResponse = new ErrorResponse();
			errorResponse.setErrorCode(0);
			errorResponse.setErrorMessage("");
			return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.OK);
		} catch (Exception e) {
			StringBuilder sb = new StringBuilder();
			sb.append("Error while creating account, exception is: ").append(e.getMessage());
			throw new AccountCreationException(sb.toString());
		}
	}
}
