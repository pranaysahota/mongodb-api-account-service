package com.dunya.stakechannel.accounts.controller;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dunya.stakechannel.accounts.dao.AccountsRepository;
import com.dunya.stakechannel.accounts.exception.AccountNotFoundException;
import com.dunya.stakechannel.accounts.exception.AccountsServiceException;
import com.dunya.stakechannel.accounts.exception.ErrorResponse;
import com.dunya.stakechannel.accounts.model.Account;
import com.dunya.stakechannel.accounts.model.Blacklist;

@RestController
public class BlacklistingController {
	private Logger log = LogManager.getLogger(this.getClass().getName());
	@Autowired
	AccountsRepository accountsRepository;

	@Autowired
	MongoOperations mongoOperations;

	@PutMapping(value = "/{accountName}/blacklist")
	public ResponseEntity<ErrorResponse> blacklist(@PathVariable("accountName") String accountName,
			@Valid @RequestBody @NonNull Blacklist blacklistAccount) {
		ErrorResponse errorResponse = new ErrorResponse();
		try {
			Query query = new Query();
			query.addCriteria(Criteria.where("accountName").is(accountName));
			Update update = new Update();
			update.set("blacklist", blacklistAccount.getBlacklist());
			Account account = mongoOperations.findAndModify(query, update, Account.class);
			if (account == null) {
				String msg = "Couldn't find account to update.";
				log.error(msg);
				throw new AccountNotFoundException(msg);
			}
			log.info("Successfully updated blacklist property of {}", account.toString());
			errorResponse.setErrorCode(0);
			errorResponse.setErrorMessage("");
			return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.OK);
		} catch (Exception e) {
			StringBuilder sb = new StringBuilder();
			sb.append("Error while updating blacklist of account, Exception: ").append(e.getMessage());
			log.error(sb.toString());
			throw new AccountsServiceException(sb.toString());
		}
	}
}
