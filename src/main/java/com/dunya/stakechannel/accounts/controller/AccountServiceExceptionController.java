package com.dunya.stakechannel.accounts.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.dunya.stakechannel.accounts.exception.AccountCreationException;
import com.dunya.stakechannel.accounts.exception.AccountNotFoundException;
import com.dunya.stakechannel.accounts.exception.AccountsServiceException;
import com.dunya.stakechannel.accounts.exception.ErrorResponse;

@RestControllerAdvice
public class AccountServiceExceptionController extends ResponseEntityExceptionHandler {


	@ExceptionHandler(AccountsServiceException.class)
	public final ResponseEntity<ErrorResponse> handleAccountsServiceException(AccountsServiceException ex) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		errorResponse.setErrorMessage(ex.getMessage());
		return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(AccountNotFoundException.class)
	public final ResponseEntity<ErrorResponse> handleAccountNotFoundException(AccountNotFoundException ex) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setErrorCode(HttpStatus.NOT_FOUND.value());
		errorResponse.setErrorMessage(ex.getMessage());
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(AccountCreationException.class)
	public final ResponseEntity<ErrorResponse> handleAccountExistsException(AccountCreationException ex) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setErrorCode(HttpStatus.CONFLICT.value());
		errorResponse.setErrorMessage(ex.getMessage());
		return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
	}
}
