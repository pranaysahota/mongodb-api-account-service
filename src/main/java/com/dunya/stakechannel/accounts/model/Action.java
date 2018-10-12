package com.dunya.stakechannel.accounts.model;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

@Document(collection = "account_actions")
public class Action {
	@JsonProperty("tx_id")
	private String txId;
	@JsonProperty("timestamp")
	@Indexed
	private long timestamp;
	private String action;
	@Indexed
	@JsonProperty("account_name")
	private String accountName;
	private int count;
	@JsonProperty("cpu_usage")
	private double cpuUsage;
	@JsonProperty("net_usage")
	private double netUsage;

	public String getTxId() {
		return txId;
	}

	public void setTxId(String txId) {
		this.txId = txId;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public double getCpuUsage() {
		return cpuUsage;
	}

	public void setCpuUsage(double cpuUsage) {
		this.cpuUsage = cpuUsage;
	}

	public double getNetUsage() {
		return netUsage;
	}

	public void setNetUsage(double netUsage) {
		this.netUsage = netUsage;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Action [txId=");
		builder.append(txId);
		builder.append(", timestamp=");
		builder.append(timestamp);
		builder.append(", action=");
		builder.append(action);
		builder.append(", accountName=");
		builder.append(accountName);
		builder.append(", count=");
		builder.append(count);
		builder.append(", cpuUsage=");
		builder.append(cpuUsage);
		builder.append(", netUsage=");
		builder.append(netUsage);
		builder.append("]");
		return builder.toString();
	}
	
}
