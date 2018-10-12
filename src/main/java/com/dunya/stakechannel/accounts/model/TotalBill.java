package com.dunya.stakechannel.accounts.model;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TotalBill {
	@JsonProperty("account_name")
	private String accountName;
	@JsonProperty("total_cpu_bill")
	@JsonFormat(shape = JsonFormat.Shape.NUMBER_FLOAT)
	private BigDecimal totalCpuBill;
	@JsonProperty("total_net_bill")
	@JsonFormat(shape = JsonFormat.Shape.NUMBER_FLOAT)
	private BigDecimal totalNetBill;
	@JsonProperty("time_period")
	private TimePeriod timePeriod;
	@JsonProperty("transactions")
	private List<Transactions> transactions;

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public BigDecimal getTotalCpuBill() {
		return totalCpuBill;
	}

	public void setTotalCpuBill(BigDecimal totalCpuBill) {
		this.totalCpuBill = totalCpuBill;
	}

	public BigDecimal getTotalNetBill() {
		return totalNetBill;
	}

	public void setTotalNetBill(BigDecimal totalNetBill) {
		this.totalNetBill = totalNetBill;
	}

	public TimePeriod getTimePeriod() {
		return timePeriod;
	}

	public void setTimePeriod(TimePeriod timePeriod) {
		this.timePeriod = timePeriod;
	}

	public List<Transactions> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transactions> transactions) {
		this.transactions = transactions;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TotalBill [accountName=");
		builder.append(accountName);
		builder.append(", totalCpuBill=");
		builder.append(totalCpuBill);
		builder.append(", totalNetBill=");
		builder.append(totalNetBill);
		builder.append(", timePeriod=");
		builder.append(timePeriod);
		builder.append(", transactions=");
		builder.append(transactions);
		builder.append("]");
		return builder.toString();
	}
	
}
