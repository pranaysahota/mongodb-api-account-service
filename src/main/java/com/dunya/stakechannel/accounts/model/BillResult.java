package com.dunya.stakechannel.accounts.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BillResult {
	@JsonProperty("account_name")
	private String accountName="";
	@JsonProperty("total_cpu_bill")
	private BigDecimal totalCpuBill=new BigDecimal(0);
	@JsonProperty("total_net_bill")
	private BigDecimal totalNetBill=new BigDecimal(0);
	@JsonProperty("time_period")
	private TimePeriod timePeriod;

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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BillResult [accountName=");
		builder.append(accountName);
		builder.append(", totalCpuBill=");
		builder.append(totalCpuBill);
		builder.append(", totalNetBill=");
		builder.append(totalNetBill);
		builder.append(", timePeriod=");
		builder.append(timePeriod);
		builder.append("]");
		return builder.toString();
	}

}
