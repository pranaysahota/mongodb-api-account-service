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

import com.dunya.stakechannel.accounts.dao.ActionsRepository;
import com.dunya.stakechannel.accounts.exception.AccountsServiceException;
import com.dunya.stakechannel.accounts.exception.ErrorResponse;
import com.dunya.stakechannel.accounts.model.Action;
import com.dunya.stakechannel.accounts.model.Actions;
import com.dunya.stakechannel.accounts.util.Utils;

@RestController
public class ActionsController {
	private Logger log = LogManager.getLogger(this.getClass().getName());
	@Autowired
	ActionsRepository actionsRepository;

	@GetMapping("/{account_name}/actions")
	public ResponseEntity<Actions> getAccountActions(@RequestParam(value = "days", required = false) Integer days,
			@PathVariable("account_name") String accountName) {
		List<Action> actions;
		try {
			if (days != null) {
				actions = actionsRepository.findByAccountNameAndTimestampGreaterThan(accountName,
						Utils.getEpochTimeStampToQuery(days).getStartTime());
			} else {
				actions = actionsRepository.findByAccountName(accountName);
			}
			log.info("Retrieved actions for account: {}", accountName);
		} catch (Exception e) {
			throw new AccountsServiceException("Error while fetching account actions, exception is: " + e.getMessage());
		}
		Actions actionsObj = new Actions();
		actionsObj.setActions(actions);
		return new ResponseEntity<Actions>(actionsObj, HttpStatus.OK);
	}

	@PostMapping("/{account_name}/actions")
	public ResponseEntity<ErrorResponse> saveAccountAction(@PathVariable("account_name") String accountName,
			@Valid @RequestBody @NonNull Action accountAction) throws Exception {
		accountAction.setAccountName(accountName);
		log.debug("Received action details for account: {}; with details:", accountName, accountAction.toString());
		try {
			actionsRepository.save(accountAction);
			log.info("Successfully saved action for account: {}", accountName);
			ErrorResponse errorResponse = new ErrorResponse();
			errorResponse.setErrorCode(0);
			errorResponse.setErrorMessage("");
			return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.OK);
		} catch (Exception e) {
			StringBuilder sb = new StringBuilder();
			sb.append("Error while saving account action, Exception: ").append(e.getMessage());
			log.error(sb.toString());
			throw new AccountsServiceException(sb.toString());
		}
	}
}
