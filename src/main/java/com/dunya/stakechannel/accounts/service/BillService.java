package com.dunya.stakechannel.accounts.service;

import com.dunya.stakechannel.accounts.model.BillResult;

public interface BillService {
	BillResult calculateBill(String accountName);

	BillResult calculateBillByDays(String accountName, Long queryTime);
}
