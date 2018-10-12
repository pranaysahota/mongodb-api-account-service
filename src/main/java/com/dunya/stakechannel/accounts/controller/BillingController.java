package com.dunya.stakechannel.accounts.controller;

import java.util.Date;

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

import com.dunya.stakechannel.accounts.dao.BillsRepository;
import com.dunya.stakechannel.accounts.exception.AccountsServiceException;
import com.dunya.stakechannel.accounts.exception.ErrorResponse;
import com.dunya.stakechannel.accounts.model.Bill;
import com.dunya.stakechannel.accounts.model.BillResult;
import com.dunya.stakechannel.accounts.model.TimePeriod;
import com.dunya.stakechannel.accounts.service.BillService;
import com.dunya.stakechannel.accounts.util.Utils;

@RestController
public class BillingController {
	private Logger log = LogManager.getLogger(this.getClass().getName());
	@Autowired
	BillsRepository billsRepository;

	@Autowired
	BillService billService;

	@PostMapping("/{account_name}/bill")
	public ResponseEntity<ErrorResponse> saveBillDetails(@PathVariable("account_name") String accountName,
			@Valid @NonNull @RequestBody Bill bill) {
		try {
			bill.set_id(accountName);
			billsRepository.save(bill);
			log.info("Successfully saved, {}", bill.toString());
			ErrorResponse errorResponse = new ErrorResponse();
			errorResponse.setErrorCode(0);
			errorResponse.setErrorMessage("");
			return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.OK);
		} catch (Exception e) {
			StringBuilder sb = new StringBuilder();
			sb.append("Error while saving Bill for account:").append(accountName).append(", Exception is: ")
					.append(e.getMessage());
			log.error(sb.toString());
			throw new AccountsServiceException(sb.toString());
		}
	}

	@GetMapping("/{account_name}/bill")
	public ResponseEntity<BillResult> getBillForAccount(@RequestParam(value = "days", required = false) Integer days,
			@PathVariable("account_name") String accountName) {
		BillResult billResult;
		try {
			if (days == null) {
				billResult = billService.calculateBill(accountName);
				TimePeriod timePeriod = new TimePeriod();
				timePeriod.setEndTime((new Date()).getTime());
				billResult.setTimePeriod(timePeriod);
				log.info("Calculated Bill for {}, {}", accountName, billResult.toString());
			} else {
				TimePeriod queryTimePeriod = Utils.getEpochTimeStampToQuery(days);
				billResult = billService.calculateBillByDays(accountName, queryTimePeriod.getStartTime());
				billResult.setTimePeriod(queryTimePeriod);
				log.info("Calculated Bill for {}, {}", accountName, billResult.toString());
			}
		} catch (Exception e) {
			StringBuilder sb = new StringBuilder();
			sb.append("Error while calculating bill for account. Exception is: ").append(e.getMessage());
			log.error(sb.toString());
			throw new AccountsServiceException(sb.toString());
		}
		return new ResponseEntity<BillResult>(billResult, HttpStatus.OK);
	}
}
