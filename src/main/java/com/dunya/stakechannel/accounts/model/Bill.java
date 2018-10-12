package com.dunya.stakechannel.accounts.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonProperty;

@Document(collection = "account_bills")
public class Bill {
	private long timestamp;
	@JsonProperty("account_name")
	@Field("accountName")
	private String _id;
	@JsonProperty("cpu_bill")
	private double cpuBill;
	@JsonProperty("net_bill")
	private double netBill;
	@JsonProperty("tx_id")
	private String txId;
	private String action;
	private int count;

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public double getCpuBill() {
		return cpuBill;
	}

	public void setCpuBill(double cpuBill) {
		this.cpuBill = cpuBill;
	}

	public double getNetBill() {
		return netBill;
	}

	public void setNetBill(double netBill) {
		this.netBill = netBill;
	}

	public String getTxId() {
		return txId;
	}

	public void setTxId(String txId) {
		this.txId = txId;
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Bill [timestamp=");
		builder.append(timestamp);
		builder.append(", _id=");
		builder.append(_id);
		builder.append(", cpuBill=");
		builder.append(cpuBill);
		builder.append(", netBill=");
		builder.append(netBill);
		builder.append(", txId=");
		builder.append(txId);
		builder.append(", action=");
		builder.append(action);
		builder.append(", count=");
		builder.append(count);
		builder.append("]");
		return builder.toString();
	}
}
