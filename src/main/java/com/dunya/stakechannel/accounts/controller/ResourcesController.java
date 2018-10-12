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

import com.dunya.stakechannel.accounts.dao.ResourcesRepository;
import com.dunya.stakechannel.accounts.exception.AccountsServiceException;
import com.dunya.stakechannel.accounts.exception.ErrorResponse;
import com.dunya.stakechannel.accounts.model.Resource;
import com.dunya.stakechannel.accounts.model.Resources;
import com.dunya.stakechannel.accounts.util.Utils;

@RestController
public class ResourcesController {
	private Logger log = LogManager.getLogger(this.getClass().getName());
	@Autowired
	ResourcesRepository accountResourcesRepository;

	@GetMapping("/{account_name}/resources")
	public ResponseEntity<Resources> getAccountResources(@RequestParam(value = "days", required = false) Integer days,
			@PathVariable("account_name") String accountName) {
		List<Resource> allResources;
		try {
			if (days != null) {
				allResources = accountResourcesRepository.findByAccountNameAndTimestampGreaterThan(accountName,
						Utils.getEpochTimeStampToQuery(days).getStartTime());
				log.debug("Successfully retrieved resources for account: {}, for days: {}", accountName, days);
			} else {
				allResources = accountResourcesRepository.findByAccountName(accountName);
				log.debug("Successfully retrieved delegations for account: {}", accountName);
			}
		} catch (Exception e) {
			StringBuilder sb = new StringBuilder();
			sb.append("Error while fetching account resources, exception is: ").append(e.getMessage());
			log.error(sb.toString());
			throw new AccountsServiceException(sb.toString());
		}
		Resources resources = new Resources();
		resources.setResources(allResources);
		return new ResponseEntity<Resources>(resources, HttpStatus.OK);
	}

	@PostMapping("/{account_name}/resources")
	public ResponseEntity<ErrorResponse> saveAccountResource(@PathVariable("account_name") String accountName,
			@Valid @RequestBody @NonNull Resource accountResources) {
		accountResources.setAccountName(accountName);
		try {
			accountResourcesRepository.save(accountResources);
			log.debug("Saved resources for account: {}", accountName);
			ErrorResponse errorResponse = new ErrorResponse();
			errorResponse.setErrorCode(0);
			errorResponse.setErrorMessage("");
			return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.OK);
		} catch (Exception e) {
			StringBuilder sb = new StringBuilder();
			sb.append("Error while saving Account resources, Exception: ").append(e.getMessage());
			log.error(sb.toString());
			throw new AccountsServiceException(sb.toString());
		}
	}
}
