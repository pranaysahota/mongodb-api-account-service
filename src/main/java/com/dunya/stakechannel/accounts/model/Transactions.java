package com.dunya.stakechannel.accounts.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Transactions {
	@JsonProperty("tx_id")
	private String txId;
	@JsonProperty("actions")
	private List<ActionCount> actionCounts;

	public String getTxId() {
		return txId;
	}

	public void setTxId(String txId) {
		this.txId = txId;
	}

	public List<ActionCount> getActionCounts() {
		return actionCounts;
	}

	public void setActionCounts(List<ActionCount> actionCounts) {
		this.actionCounts = actionCounts;
	}

}
